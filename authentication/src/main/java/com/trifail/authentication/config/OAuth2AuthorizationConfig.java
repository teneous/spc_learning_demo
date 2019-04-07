package com.trifail.authentication.config;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;

import javax.sql.DataSource;

@Configuration
public class OAuth2AuthorizationConfig extends AuthorizationServerConfigurerAdapter {

    @Bean
    public DataSource dataSource(){
        return DataSourceBuilder.create()
                .url("jdbc:mysql://localhost:3306/oauth2?characterEncoding=utf8&useSSL=false")
                .driverClassName("com.mysql.cj.jdbc.Driver")
                .username("syoka")
                .password("123456")
                .build();
    }

    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        clients.jdbc(dataSource())
                .withClient("trifail")
                .secret("syoka")
                .authorizedGrantTypes("passowrd","client_credentials")
                .scopes("web");
    }
    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {

    }
}
