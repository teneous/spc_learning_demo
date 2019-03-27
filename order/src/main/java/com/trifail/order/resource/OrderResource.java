package com.trifail.order.resource;

import com.trifail.order.api.vo.CustomerOrderInfo;
import com.trifail.order.config.RedisRepository;
import com.trifail.order.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * Created by syoka on 2019/3/12.
 */
@RestController
@RequestMapping("/v1/order")
public class OrderResource {

    private final IOrderService orderService;
    private final RedisRepository redisRepository;

    @Autowired
    public OrderResource(IOrderService orderService, RedisRepository redisRepository) {
        this.orderService = orderService;
        this.redisRepository = redisRepository;
    }

    @GetMapping("/customer/{cid}")
    public List<CustomerOrderInfo> getCustomerOrders(@PathVariable Long cid){
        String a = redisRepository.get("a");
        return orderService.getCustomerOrderList(cid);
    }

//    @GetMapping("/a/")
//    public void aaaa(){
//        ResponseEntity<String> forEntity = restTemplate.getForEntity("http://gateway/hello", String.class);
//        System.out.println(forEntity);
//    }
}
