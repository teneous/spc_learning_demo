package com.trifail.stock.resource;

import com.trifail.protocol.core.ErrorCode;
import com.trifail.stock.common.StockErrorCode;
import com.trifail.stock.service.IGoodsService;
import model.V1GoodWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import service.ApiStockService;


@RestController
public class StockResource implements ApiStockService {

    private final IGoodsService goodsService;

    @Autowired
    public StockResource(IGoodsService goodsService) {
        this.goodsService = goodsService;
    }


    @Override
    public ErrorCode checkGoodsWithStock(@RequestBody V1GoodWrapper goodsInfo) {
        System.out.println("chenggong");
        return StockErrorCode.GOODS_NOT_EXISTS;
    }

    @Override
    public boolean deliverGoods(@RequestBody V1GoodWrapper goodsInfo) {
        return false;
    }
}
