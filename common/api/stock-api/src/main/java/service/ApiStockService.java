package service;

import com.trifail.protocol.core.ErrorCode;
import io.swagger.annotations.ApiOperation;
import model.V1GoodWrapper;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/v1/inter_api")
public interface ApiStockService {

    @PostMapping("/validation")
    @ApiOperation(value = "库存商品校验", response = String.class)
    ErrorCode checkGoodsWithStock(@RequestBody V1GoodWrapper goodsInfo);


    @PostMapping("/delivergoods")
    @ApiOperation(value = "商品出库", response = String.class)
    boolean deliverGoods(@RequestBody V1GoodWrapper goodsInfo);
}
