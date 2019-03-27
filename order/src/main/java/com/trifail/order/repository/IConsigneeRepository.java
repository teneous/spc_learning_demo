package com.trifail.order.repository;

import com.trifail.order.model.Consignee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IConsigneeRepository extends JpaRepository<Consignee, Long> {
}

