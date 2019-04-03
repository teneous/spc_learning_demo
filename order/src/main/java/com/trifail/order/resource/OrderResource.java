package com.trifail.order.resource;

import com.trifail.basis.core.RestResponseVo;
import com.trifail.order.api.vo.CustomerOrderInfo;
import com.trifail.order.config.RedisRepository;
import com.trifail.order.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * Created by syoka on 2019/3/12.
 */
@RestController
@RequestMapping("/v1/order")
public class OrderResource{

    private final IOrderService orderService;

    @Autowired
    public OrderResource(IOrderService orderService) {
        this.orderService = orderService;
    }

    /**
     * 获取某个顾客的订单记录
     * @param cid
     * @return
     */
    @GetMapping("/customer/{cid}")
    public RestResponseVo<List<CustomerOrderInfo>> getCustomerOrders(@PathVariable Long cid){
        return orderService.getCustomerOrderList(cid);
    }

    /**
     * 订单回滚
     */
    @DeleteMapping("/rollback/{serialno}")
    public RestResponseVo rollbackOrder(@PathVariable String serialno){
        return null;
   }

}
