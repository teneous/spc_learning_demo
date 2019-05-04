package com.trifail.order.feign;

import com.trifail.basis.core.ErrorCode;
import com.trifail.order.databean.api.V1GoodWrapper;
import com.trifail.order.filter.FeignRequestInterceptor;
import feign.RequestLine;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;


@FeignClient(value = "stock",configuration = FeignRequestInterceptor.class)
public interface ApiStockService {

    @RequestLine(value = "POST /v1/validation")
    ErrorCode checkGoodsWithStock(@RequestBody V1GoodWrapper goodsInfo);


    @RequestLine(value = "POST /v1/delivergoods")
    boolean deliverGoods(@RequestBody V1GoodWrapper goodsInfo);
}
