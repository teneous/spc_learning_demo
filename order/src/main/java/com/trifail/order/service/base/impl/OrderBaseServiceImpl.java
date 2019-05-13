package com.trifail.order.service.base.impl;

import com.trifail.order.service.base.IOrderBaseService;
import com.trifail.protocol.core.RestPageRequestVo;
import com.trifail.protocol.service.impl.V1BaseServiceImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import java.util.Optional;

public class OrderBaseServiceImpl extends V1BaseServiceImpl implements IOrderBaseService {


    protected PageRequest pageConvertor(RestPageRequestVo requestVo) {
        Optional.of(requestVo).map(e -> {
            Sort.Direction direction;
            direction = e.getOrder_type().equals("desc") ? Sort.Direction.DESC : Sort.Direction.ASC;
            return PageRequest.of(e.getCurrent_page(), e.getPage_size(), direction, requestVo.getOrder_field());
        });
        return null;
    }
}
