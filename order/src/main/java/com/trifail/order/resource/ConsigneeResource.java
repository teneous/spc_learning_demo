package com.trifail.order.resource;

import com.trifail.order.api.vo.CustomerOrderInfo;
import com.trifail.order.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
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
public class ConsigneeResource {

}
