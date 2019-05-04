package com.trifail.stock.service.impl;

import com.trifail.basis.core.ErrorCode;
import com.trifail.basis.service.impl.V1BaseServiceImpl;
import com.trifail.stock.common.StockErrorcode;
import com.trifail.stock.databean.V1GoodsWrapper;
import com.trifail.stock.service.IGoodsService;
import org.springframework.stereotype.Service;

@Service
public class GoodsServiceImpl extends V1BaseServiceImpl implements IGoodsService {


    @Override
    public ErrorCode checkGoodsStocks(V1GoodsWrapper goodsInfo) {
        if (goodsInfo == null || goodsInfo.getGoods().size() == 0) {
            return StockErrorcode.GOODS_NOT_EXISTS;
        }
        return null;
    }
}
