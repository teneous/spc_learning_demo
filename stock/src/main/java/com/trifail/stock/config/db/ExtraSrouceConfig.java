package com.trifail.stock.config.db;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

/**
 * Created by syoka on 2019/3/26.
 */
@Configuration
public class ExtraSrouceConfig {
    /*JPA and DataSource*/
    @Value("${stock.mysql.datasource.url}")
    public String url;
    @Value("${stock.mysql.datasource.driver}")
    public String driver;
    @Value("${stock.mysql.datasource.username}")
    public String username;
    @Value("${stock.mysql.datasource.password}")
    public String password;
    @Value("${stock.mysql.datasource.withInitialization}")
    public Boolean initialized;
    @Value("${stock.jpa.show.sql}")
    public Boolean showSql;
    @Value("${stock.jpa.ddl.auto}")
    public String ddlAuto;
    @Value("${stock.jpa.dialect}")
    public String dialect;
    @Value("${stock.jpa.format_sql}")
    public Boolean formatable;
//    @Value("${stock.jpa.unique_constraint_strategy}")
//    String uniqueConstraintStrategy;
    /*Redis*/
    @Value("${stock.redis.master.ip}")
    String redisMasterIp;
    public  @Value("${stock.redis.master.port}")
    String redisMasterPort;
    //    @Value("${stock.redis.salve.ip}")
//    public String redisSlaveIp;
//    @Value("${stock.redis.salve.port}")
//    public String redisSlavePort;
    @Value("${stock.redis.password}")
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
