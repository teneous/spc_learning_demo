package com.trifail.order.feign;

import com.trifail.basis.common.PairVo;
import com.trifail.order.databean.v1.V1OrderGoodsInfo;
import com.trifail.order.filter.FeignRequestInterceptor;
import feign.RequestLine;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient(value = "stock",configuration = FeignRequestInterceptor.class)
public interface ApiStockService {

//    @RequestLine(value = "POST /v1/validation")
    @PostMapping(value = "/v1/validation")
    List<PairVo<String, Integer>> checkGoodsWithStock(@RequestBody List<V1OrderGoodsInfo> goodsInfo);
}
