package com.trifail.order.service.impl;

import com.trifail.basis.common.CommonIdVo;
import com.trifail.basis.core.ErrorCode;
import com.trifail.basis.core.RestPageRequestVo;
import com.trifail.basis.core.RestResponseVo;
import com.trifail.order.common.OrderErrorcode;
import com.trifail.order.databean.CustomerOrderInfo;
import com.trifail.order.config.RedisRepository;
import com.trifail.order.databean.v1.V1OrderInfo;
import com.trifail.order.model.Order;
import com.trifail.order.repository.IOrderRepository;
import com.trifail.order.service.IOrderService;
import com.trifail.order.common.OrderConstant;
import com.trifail.order.utils.SerializationUtils;
import com.trifail.order.utils.SnowFlakeGenerator;
import com.trifail.order.utils.TimeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by syoka on 2019/3/11.
 */
@Service
public class OrderServiceImpl implements IOrderService {

    private final IOrderRepository orderRepository;
    private final RedisRepository redisRepository;


    @Autowired
    public OrderServiceImpl(IOrderRepository orderRepository, RedisRepository redisRepository) {
        this.orderRepository = orderRepository;
        this.redisRepository = redisRepository;
    }

    @Override
    public RestResponseVo createOrder(V1OrderInfo orderInfo) {
        long serino = SnowFlakeGenerator.getInstance().nextId();
        return new RestResponseVo<>(serino + "");
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
            redisRepository.refreshExpireTime(OrderConstant.REDIS_ORDER + cid,OrderConstant.THREE_HOUR);
            return new RestResponseVo<>((List<CustomerOrderInfo>) SerializationUtils.byteToObject(bytes));
        }
        List<Order> orderList = orderRepository.findByCustomerId(Long.valueOf(cid));
        Page<Order> byCustomerId = orderRepository.findByCustomerId(PageRequest.of(1,1), Long.valueOf(cid));

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
}
