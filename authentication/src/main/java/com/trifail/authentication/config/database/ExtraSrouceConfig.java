package com.trifail.authentication.config.database;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

/**
 * Created by syoka on 2019/3/26.
 */
@Configuration
public class ExtraSrouceConfig {
    /*JPA and DataSource*/
    @Value("${authentication.mysql.datasource.url}")
    String url;
    @Value("${authentication.mysql.datasource.driver}")
    String driver;
    @Value("${authentication.mysql.datasource.username}")
    String username;
    @Value("${authentication.mysql.datasource.password}")
    String password;
    @Value("${authentication.jpa.dialect}")
    String dialect;
}
