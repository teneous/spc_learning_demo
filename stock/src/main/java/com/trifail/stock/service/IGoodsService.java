package com.trifail.stock.service;

import com.trifail.basis.core.ErrorCode;
import com.trifail.basis.service.IV1BaseService;
import com.trifail.stock.databean.V1GoodsWrapper;

import java.util.List;

public interface IGoodsService extends IV1BaseService {

    /**
     * 检查上的有效性
     * @return
     */
    ErrorCode checkGoodsStocks(V1GoodsWrapper goodsInfo);
}
