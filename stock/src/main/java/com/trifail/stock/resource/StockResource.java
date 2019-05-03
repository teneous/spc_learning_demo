package com.trifail.stock.resource;

import com.trifail.basis.core.RestResponseVo;
import com.trifail.stock.databean.V1GoodsInfo;
import com.trifail.stock.service.IGoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/v1")
public class StockResource {

    @Autowired
    private IGoodsService goodsService;

//    @ApiOperation(value = "创建订单", response = String.class)
    @PostMapping("/validation")
    public RestResponseVo goodsValidattion(@RequestBody List<V1GoodsInfo> goodsInfo){
        System.out.println("1");
        return new RestResponseVo(null);
    }
}
