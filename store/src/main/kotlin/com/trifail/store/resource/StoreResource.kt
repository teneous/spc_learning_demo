package com.trifail.store.resource

import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/v1/store")
class StoreResource {


    /**
     * 出库
     */
    @PostMapping("/deliver")
    fun deliverGoods(): Any {

        return Any();
    }

}