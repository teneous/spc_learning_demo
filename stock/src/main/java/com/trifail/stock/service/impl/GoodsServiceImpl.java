package com.trifail.stock.service.impl;

import com.trifail.protocol.core.ErrorCode;
import com.trifail.protocol.service.impl.V1BaseServiceImpl;
import com.trifail.stock.common.StockErrorCode;
import com.trifail.stock.databean.V1GoodsWrapper;
import com.trifail.stock.service.IGoodsService;
import org.springframework.stereotype.Service;

@Service
public class GoodsServiceImpl extends V1BaseServiceImpl implements IGoodsService {

    @Override
    public ErrorCode checkGoodsStocks(V1GoodsWrapper goodsInfo) {
        if (goodsInfo == null || goodsInfo.getGoods().size() == 0) {
            return StockErrorCode.GOODS_NOT_EXISTS;
        }
        return null;
    }
}
