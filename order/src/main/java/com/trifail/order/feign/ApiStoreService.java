package com.trifail.order.feign;

import com.trifail.basis.core.RestResponseVo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient("/api/v1/store/")
public interface ApiStoreService {

    @PostMapping("/retrieve/product")
    RestResponseVo rollbackProduct(@RequestBody Object obj);

}
