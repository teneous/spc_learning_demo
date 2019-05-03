package com.trifail.order.repository;

import com.trifail.order.model.Order;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by syoka on 2019/3/12.
 */
@Repository
public interface IOrderRepository extends JpaRepository<Order, Long> {

    List<Order> findByCustomerId(Long cid);

    @Query("select o from Order o where o.customerId = :cid")
    Page<Order> selectAllByCustomerId(@Param("cid") Long cid, Pageable  pageRequest);

    Order findByserialNo(String serialNo);
}
