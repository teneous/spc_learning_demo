package com.trifail.store.resource

import com.trifail.store.databean.V1GoodsInfo
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/v1")
class StockResource {

    @Autowired
//    private lateinit var goodService: IGoodsService

//    @PostMapping("/validation")
//    fun checkGoodsWithStock(@RequestBody goods: List<V1GoodsInfo>):List<V1GoodsInfo>{
//    }

    /**
     * 出库
     */
    @PostMapping("/deliver")
    fun deliverGoods(): Any {
        return Any();
    }

}