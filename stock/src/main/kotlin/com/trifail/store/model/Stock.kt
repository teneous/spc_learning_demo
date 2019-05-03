package com.trifail.store.model

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "stock")
class Stock{

    @Id
    var id: Long = 0
    @Column(name = "product_id", length = 20, nullable = false)
    var productId: String = ""
    @Column(name = "product_name", length = 225, nullable = false)
    var productName: String = ""
    @Column(name = "market_price", length = 11, nullable = false)
    var marketPrice: Int = 0
    @Column(name = "stock_number", length = 11, nullable = false)
    var stockNumber: Int = 0
    @Column(name = "remain_number", length = 11, nullable = false)
    var remainNumber: Int = 0
    @Column(name = "shopid", length = 20, nullable = false)
    var shopId: Long = 0
}