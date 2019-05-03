package com.trifail.store.repository

import com.trifail.store.model.Stock
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface StoreRepository :JpaRepository<Stock,Long>