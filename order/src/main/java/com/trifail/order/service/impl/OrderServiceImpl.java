package com.trifail.order.service.impl;

import com.trifail.basis.core.RestResponseVo;
import com.trifail.order.api.vo.CustomerOrderInfo;
import com.trifail.order.api.vo.OrderInfo;
import com.trifail.order.config.RedisRepository;
import com.trifail.order.model.Order;
import com.trifail.order.repository.IOrderRepository;
import com.trifail.order.service.IOrderService;
import com.trifail.order.utils.SerializationUtils;
import com.trifail.order.utils.TimeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.serializer.support.DeserializingConverter;
import org.springframework.core.serializer.support.SerializingConverter;
import org.springframework.stereotype.Service;

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
            return new RestResponseVo<>((List<CustomerOrderInfo>)SerializationUtils.byteToObject(bytes));
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
                    SerializationUtils.objectToByte(customerInfo),300);
            return new RestResponseVo<>(customerInfo);
        }
        return new RestResponseVo<>(new ArrayList<>());
    }
}
