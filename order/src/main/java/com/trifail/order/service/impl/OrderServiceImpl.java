package com.trifail.order.service.impl;

import com.trifail.basis.core.ErrorCode;
import com.trifail.basis.core.RestResponseVo;
import com.trifail.order.common.OrderErrorcode;
import com.trifail.order.databean.CustomerOrderInfo;
import com.trifail.order.databean.OrderInfo;
import com.trifail.order.config.RedisRepository;
import com.trifail.order.model.Order;
import com.trifail.order.repository.IOrderRepository;
import com.trifail.order.service.IOrderService;
import com.trifail.order.common.OrderConstant;
import com.trifail.order.utils.SerializationUtils;
import com.trifail.order.utils.TimeUtils;
import org.springframework.beans.factory.annotation.Autowired;
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
    private final String REDIS_ORDER = "order_of_cus_";

    @Autowired
    public OrderServiceImpl(IOrderRepository orderRepository, RedisRepository redisRepository) {
        this.orderRepository = orderRepository;
        this.redisRepository = redisRepository;
    }

    @Override
    public String createOrder(OrderInfo orderInfo) {
        return null;
    }

    @Override
    public RestResponseVo<List<CustomerOrderInfo>> getCustomerOrderList(Long cid) {
        byte[] bytes = redisRepository.get(SerializationUtils.objectToByte(REDIS_ORDER + cid));
        if (bytes != null) {
            return new RestResponseVo<>((List<CustomerOrderInfo>) SerializationUtils.byteToObject(bytes));
        }
        //这里只做一个demo不考虑分页
        List<Order> orderList = orderRepository.findByCustomerId(cid);
        if (orderList.size() > 0) {
            List<CustomerOrderInfo> customerInfo = orderList.stream().map(order -> {
                CustomerOrderInfo customerOrderInfo = new CustomerOrderInfo();
                customerOrderInfo.setSerioNo(order.getSerialNo());
                customerOrderInfo.setTotalMoney(order.getRealPayMoney());
                customerOrderInfo.setCreateTime(TimeUtils.normalFormatDate(order.getCreateTime()));
                return customerOrderInfo;
            }).collect(Collectors.toList());
            redisRepository.setExpire(SerializationUtils.objectToByte(REDIS_ORDER + cid),
                    SerializationUtils.objectToByte(customerInfo), 300);
            return new RestResponseVo<>(customerInfo);
        }
        return new RestResponseVo<>(new ArrayList<>());
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
