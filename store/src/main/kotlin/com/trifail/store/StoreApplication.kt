package com.trifail.store

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.openfeign.EnableFeignClients

@SpringBootApplication
@EnableFeignClients
class StoreApplication

fun main(args: Array<String>) {
    runApplication<StoreApplication>(*args)
}
