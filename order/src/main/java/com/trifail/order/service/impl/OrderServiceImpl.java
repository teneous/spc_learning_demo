package com.trifail.order.service.impl;

import com.trifail.order.api.vo.CustomerOrderInfo;
import com.trifail.order.api.vo.OrderInfo;
import com.trifail.order.model.Order;
import com.trifail.order.repository.IOrderRepository;
import com.trifail.order.service.IOrderService;
import com.trifail.order.utils.TimeUtils;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    public OrderServiceImpl(IOrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public String createOrder(OrderInfo orderInfo) {
        return null;
    }

    @Override
//    @HystrixCommand(fallbackMethod = "getCustomerOrderListFromCache")
    public List<CustomerOrderInfo> getCustomerOrderList(Long cid) {
        List<Order> orderList = orderRepository.findByCustomerId(cid);
        if (orderList.size() > 0) {
            return orderList.stream().map(order -> {
                CustomerOrderInfo customerOrderInfo = new CustomerOrderInfo();
                customerOrderInfo.setSerioNo(order.getSerialNo());
                customerOrderInfo.setTotalMoney(order.getRealPayMoney());
                customerOrderInfo.setCreateTime(TimeUtils.normalFormatDate(order.getCreateTime()));
                return customerOrderInfo;
            }).collect(Collectors.toList());
        }
        return new ArrayList<>();
    }

//    /**
//     * 当获取数据失败时,尝试从老的缓存数据中读取
//     * @param orderInfo
//     */
//    @HystrixCommand(fallbackMethod = "log")
//    private String getCustomerOrderListFromCache(OrderInfo orderInfo) {
//        return null;
//    }
}
