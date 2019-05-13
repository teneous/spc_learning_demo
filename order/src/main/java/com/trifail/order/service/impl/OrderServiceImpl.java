package com.trifail.order.service.impl;


import com.trifail.order.common.OrderErrorcode;
import com.trifail.order.databean.CustomerOrderInfo;
import com.trifail.order.config.db.RedisRepository;

import com.trifail.order.feign.StockServiceFeign;
import com.trifail.order.model.Order;
import com.trifail.order.repository.IOrderRepository;
import com.trifail.order.service.IOrderService;
import com.trifail.order.common.OrderConstant;
import com.trifail.order.service.base.impl.OrderBaseServiceImpl;
import com.trifail.order.utils.SerializationUtils;
import com.trifail.order.utils.SnowFlakeGenerator;
import com.trifail.order.utils.TimeUtils;
import com.trifail.protocol.common.CommonIdVo;
import com.trifail.protocol.core.ErrorCode;
import com.trifail.protocol.core.RestPageRequestVo;
import com.trifail.protocol.core.RestResponseVo;
import model.V1GoodWrapper;
import model.V1OrderInfo;
import model.V1OrderReceiverInfo;
import model.V1PaymentInfo;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by syoka on 2019/3/11.
 */
@Service
public class OrderServiceImpl extends OrderBaseServiceImpl implements IOrderService {

    @Autowired
    private IOrderRepository orderRepository;
    @Autowired
    private RedisRepository redisRepository;
    @Autowired(required = false)
    private StockServiceFeign apiStockService;

    @Override
    public RestResponseVo createOrder(V1OrderInfo orderInfo) {
        //校验数据
        ErrorCode errorCode = checkOrderWhenCreated(orderInfo);
        if (errorCode != null) {
            return new RestResponseVo(errorCode);
        }
        BigDecimal realPay = orderInfo.getPayMoney()
                .stream()
                .map(V1PaymentInfo::getPaymoney)
                .reduce((e1, e2) -> (e1.add(e2))).orElse(BigDecimal.ZERO);
        BigDecimal orderMoney = orderInfo.getGoods()
                .stream().map(e -> e.getPrice().multiply(BigDecimal.valueOf(e.getNumber())))
                .reduce((e1, e2) -> (e1.add(e2))).orElse(BigDecimal.ZERO);

        Order order = createNewOrder();
        order.setRealPayMoney(realPay);
        order.setCustomerId(Long.valueOf(orderInfo.getCid()));
        order.setOrderMoney(orderMoney);
        //收货人
        V1OrderReceiverInfo receiver = orderInfo.getReceiver();
        order.setReceiverName(receiver.getReceiverName());
        order.setReceiverAddr(receiver.getReceiverAddr());
        order.setReceiverPhone(receiver.getReceiverPhone());
        orderRepository.save(order);
        //下单成功后,调用库存接口出库接口
        apiStockService.deliverGoods(new V1GoodWrapper(orderInfo.getGoods()));
        return new RestResponseVo<>(order.getSerialNo());
    }

    @Override
    @SuppressWarnings("unchecked")
    public RestResponseVo<List<CustomerOrderInfo>> getCustomerOrderList(RestPageRequestVo<CommonIdVo> cInfo) {
        String cid = cInfo.getSearch_field().getCommon_id();
        if (cInfo.getSearch_field().getCommon_id() == null) {
            return new RestResponseVo(OrderErrorcode.ORDER_NOT_EXISTS);
        }
        byte[] bytes = redisRepository.get(SerializationUtils.objectToByte(OrderConstant.REDIS_ORDER + cid));
        if (bytes != null) {
            redisRepository.refreshExpireTime(OrderConstant.REDIS_ORDER + cid, OrderConstant.THREE_HOUR);
            return new RestResponseVo<>((List<CustomerOrderInfo>) SerializationUtils.byteToObject(bytes));
        }
        PageRequest pageRequest = pageConvertor(cInfo);
        Page<Order> orderPage = orderRepository.selectAllByCustomerId(Long.valueOf(cid), pageRequest);
        List<Order> orderList = orderPage.getContent();

        if (orderList.size() > 0) {
            List<CustomerOrderInfo> customerInfo = orderList.stream().map(order -> {
                CustomerOrderInfo customerOrderInfo = new CustomerOrderInfo();
                customerOrderInfo.setSerioNo(order.getSerialNo());
                customerOrderInfo.setTotalMoney(order.getRealPayMoney());
                customerOrderInfo.setCreateTime(TimeUtils.normalFormatDate(order.getCreateTime()));
                return customerOrderInfo;
            }).collect(Collectors.toList());
            //写入缓存 3hour
            redisRepository.setExpire(SerializationUtils.objectToByte(OrderConstant.REDIS_ORDER + cid),
                    SerializationUtils.objectToByte(customerInfo), OrderConstant.THREE_HOUR);
            return new RestResponseVo<>(customerInfo);
        }
        return new RestResponseVo(OrderErrorcode.ORDER_NOT_EXISTS);
    }


    @Override
    public RestResponseVo rollback(String serialno) {
        ErrorCode errorCode = validate(serialno);
        if (errorCode == null) {
            Order order = orderRepository.findByserialNo(serialno);
            if (order.getType().equals(OrderConstant.WAIT_DELIVER)) {

            }
            order.setUpdateTime(LocalDate.now());
            order.setType(OrderConstant.ROLLBACK);
        }
        return new RestResponseVo(errorCode);
    }

    /**
     * 生成一个订单
     *
     * @return 新订单
     */
    private Order createNewOrder() {
        Order order = new Order();
        //生成订单编号
        long serino = SnowFlakeGenerator.getInstance().nextId();
        LocalDate now = LocalDate.now();
        order.setCreateTime(now);
        order.setType(OrderConstant.WAIT_PAID);
        order.setSerialNo(serino + "");
        return order;
    }


    /**
     * 检查的订单号的有效性
     */
    private ErrorCode validate(String serialno) {
        if (serialno != null) {
            Order order = orderRepository.findByserialNo(serialno);
            if (order != null) {
                if (order.getType().equals(OrderConstant.WAIT_PAID) ||
                        order.getType().equals(OrderConstant.WAIT_DELIVER)) {
                    return null;
                }
                return OrderErrorcode.ORDER_CANNOT_ROLLBACK;
            }
            return OrderErrorcode.ORDER_NOT_EXISTS;
        }
        return OrderErrorcode.ORDER_NOT_EXISTS;
    }


    /**
     * 检查订单
     */
    private ErrorCode checkOrderWhenCreated(V1OrderInfo orderInfo) {
        if (orderInfo.getGoods() == null || orderInfo.getGoods().size() == 0) {
            return OrderErrorcode.ORDER_WITH_NO_PRODUCTS;
        }
        ErrorCode errorCode = apiStockService.checkGoodsWithStock(new V1GoodWrapper(orderInfo.getGoods()));
        if (orderInfo.getReceiver() != null) {
            if (StringUtils.isEmpty(orderInfo.getReceiver().getReceiverPhone())) {
                return OrderErrorcode.ORDER_WITH_RECEIVER_NO_PHONE;
            }
            if (StringUtils.isEmpty(orderInfo.getReceiver().getReceiverAddr())) {
                return OrderErrorcode.ORDER_WITH_RECEIVER_NO_ADDR;
            }
            if (StringUtils.isEmpty(orderInfo.getReceiver().getReceiverName())) {
                return OrderErrorcode.ORDER_WITH_RECEIVER_NO_NAME;
            }
        }
        return null;
    }
}
