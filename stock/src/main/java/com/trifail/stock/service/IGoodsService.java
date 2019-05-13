package com.trifail.stock.service;

import com.trifail.protocol.core.ErrorCode;
import com.trifail.protocol.service.IV1BaseService;
import com.trifail.stock.databean.V1GoodsWrapper;


public interface IGoodsService extends IV1BaseService {

    /**
     * 检查上的有效性
     * @return
     */
    ErrorCode checkGoodsStocks(V1GoodsWrapper goodsInfo);
}
