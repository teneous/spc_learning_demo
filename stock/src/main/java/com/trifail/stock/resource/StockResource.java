package com.trifail.stock.resource;

import com.trifail.basis.core.ErrorCode;
import com.trifail.stock.databean.V1GoodsWrapper;
import com.trifail.stock.service.IGoodsService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/v1")
public class StockResource {

    private final IGoodsService goodsService;

    @Autowired
    public StockResource(IGoodsService goodsService) {
        this.goodsService = goodsService;
    }

    /**
     * 内部模块调用
     * @param goodsInfo
     * @return
     */
    @ApiOperation(value = "库存商品校验", response = String.class)
    @PostMapping("/validation")
    public ErrorCode goodsValidation(@RequestBody V1GoodsWrapper goodsInfo){
        return goodsService.checkGoodsStocks(goodsInfo);
    }

    @ApiOperation(value = "商品出库", response = String.class)
    @PostMapping("/delivergoods")
    boolean deliverGoods(@RequestBody V1GoodsWrapper goodsInfo){
        return true;
    }

}
