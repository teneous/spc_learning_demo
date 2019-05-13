package com.trifail.order.feign;

import com.trifail.order.filter.FeignRequestInterceptor;
import com.trifail.protocol.core.ErrorCode;
import model.V1GoodWrapper;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@FeignClient(value = "stock",configuration = FeignRequestInterceptor.class)
public interface StockServiceFeign{

//    @RequestLine(value = "POST /v1/inter_api/validation")
    @PostMapping("/v1/inter_api/validation")
    ErrorCode checkGoodsWithStock(@RequestBody V1GoodWrapper goodsInfo);


//    @RequestLine(value = "POST /v1/inter_api/delivergoods")
    @PostMapping("/v1/inter_api/delivergoods")
    boolean deliverGoods(@RequestBody V1GoodWrapper goodsInfo);
}
