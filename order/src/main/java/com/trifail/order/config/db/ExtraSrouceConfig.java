package com.trifail.order.config.db;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

/**
 * Created by syoka on 2019/3/26.
 */
@Configuration
public class ExtraSrouceConfig {
    /*JPA and DataSource*/
    @Value("${order.mysql.datasource.url}")
    public String url;
    @Value("${order.mysql.datasource.driver}")
    public String driver;
    @Value("${order.mysql.datasource.username}")
    public String username;
    @Value("${order.mysql.datasource.password}")
    public String password;
    @Value("${order.mysql.datasource.withInitialization}")
    public Boolean initialized;
    @Value("${order.jpa.show.sql}")
    public Boolean showSql;
    @Value("${order.jpa.ddl.auto}")
    public String ddlAuto;
    @Value("${order.jpa.dialect}")
    public String dialect;
    @Value("${order.jpa.format_sql}")
    public Boolean formatable;
//    @Value("${order.jpa.unique_constraint_strategy}")
//    String uniqueConstraintStrategy;

    /*Redis*/
    @Value("${order.redis.master.ip}")
    public String redisMasterIp;
    @Value("${order.redis.master.port}")
    public String redisMasterPort;
//    @Value("${order.redis.salve.ip}")
//    String redisSlaveIp;
//    @Value("${order.redis.salve.port}")
//    String redisSlavePort;
    @Value("${order.redis.password}")
    public String redisPassword;

    @Value("${swagger.api.title}")
    public String swaggerTitle;

    @Value("${swagger.api.description}")
    public String swaggerDescription;

    @Value("${swagger.api.termsOfServiceUrl}")
    public String swaggerTermsOfServiceUrl;

    @Value("${swagger.api.version}")
    public String swaggerVersion;

    @Value("${swagger.api.controller.basepackage}")
    public String swaggerBasePackage;
}
