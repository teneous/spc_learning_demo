package com.trifail.order.service.base.impl;

import com.trifail.basis.core.RestPageRequestVo;
import com.trifail.basis.service.impl.V1BaseServiceImpl;
import com.trifail.order.service.base.IOrderBaseService;
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
