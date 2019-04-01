package com.trifail.store.repository

import com.trifail.store.module.Store
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface StoreRepository :JpaRepository<Store,Long>