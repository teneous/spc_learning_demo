package com.trifail.stock.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

/**
 * Created by syoka on 2019/3/26.
 */
@Configuration
public class ExtraSrouceConfig {
    /*JPA and DataSource*/
    @Value("${stock.mysql.datasource.url}")
    String url;
    @Value("${stock.mysql.datasource.driver}")
    String driver;
    @Value("${stock.mysql.datasource.username}")
    String username;
    @Value("${stock.mysql.datasource.password}")
    String password;
    @Value("${stock.mysql.datasource.withInitialization}")
    Boolean initialized;
    @Value("${stock.jpa.show.sql}")
    Boolean showSql;
    @Value("${stock.jpa.ddl.auto}")
    String ddlAuto;
    @Value("${stock.jpa.dialect}")
    String dialect;
    @Value("${stock.jpa.format_sql}")
    Boolean formatable;
//    @Value("${stock.jpa.unique_constraint_strategy}")
//    String uniqueConstraintStrategy;

    /*Redis*/
//    @Value("${stock.redis.master.ip}")
//    String redisMasterIp;
//    @Value("${stock.redis.master.port}")
//    String redisMasterPort;
    //    @Value("${stock.redis.salve.ip}")
//    String redisSlaveIp;
//    @Value("${stock.redis.salve.port}")
//    String redisSlavePort;
//    @Value("${stock.redis.password}")
//    String redisPassword;
//
//    @Value("${swagger.api.title}")
//    String swaggerTitle;
//
//    @Value("${swagger.api.description}")
//    String swaggerDescription;
//
//    @Value("${swagger.api.termsOfServiceUrl}")
//    String swaggerTermsOfServiceUrl;
//
//    @Value("${swagger.api.version}")
//    String swaggerVersion;
//
//    @Value("${swagger.api.controller.basepackage}")
//    String swaggerBasePackage;
}
