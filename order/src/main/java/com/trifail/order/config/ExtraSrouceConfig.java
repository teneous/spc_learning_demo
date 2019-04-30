package com.trifail.order.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

/**
 * Created by syoka on 2019/3/26.
 */
@Configuration
public class ExtraSrouceConfig {
    /*JPA and DataSource*/
    @Value("${order.mysql.datasource.url}")
    String url;
    @Value("${order.mysql.datasource.driver}")
    String driver;
    @Value("${order.mysql.datasource.username}")
    String username;
    @Value("${order.mysql.datasource.password}")
    String password;
    @Value("${order.mysql.datasource.withInitialization}")
    Boolean initialized;
    @Value("${order.jpa.show.sql}")
    Boolean showSql;
    @Value("${order.jpa.ddl.auto}")
    String ddlAuto;
    @Value("${order.jpa.dialect}")
    String dialect;
    @Value("${order.jpa.format_sql}")
    Boolean formatable;
//    @Value("${order.jpa.unique_constraint_strategy}")
//    String uniqueConstraintStrategy;

    /*Redis*/
    @Value("${order.redis.master.ip}")
    String redisMasterIp;
    @Value("${order.redis.master.port}")
    String redisMasterPort;
//    @Value("${order.redis.salve.ip}")
//    String redisSlaveIp;
//    @Value("${order.redis.salve.port}")
//    String redisSlavePort;
    @Value("${order.redis.password}")
    String redisPassword;

    @Value("${swagger.api.title}")
    String swaggerTitle;

    @Value("${swagger.api.description}")
    String swaggerDescription;

    @Value("${swagger.api.termsOfServiceUrl}")
    String swaggerTermsOfServiceUrl;

    @Value("${swagger.api.version}")
    String swaggerVersion;

    @Value("${swagger.api.controller.basepackage}")
    String swaggerBasePackage;
}
