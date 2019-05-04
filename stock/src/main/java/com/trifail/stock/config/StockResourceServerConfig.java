//package com.trifail.stock.config;
//
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
//
//@Configuration
//public class StockResourceServerConfig extends ResourceServerConfigurerAdapter {
//
//    @Override
//    public void configure(HttpSecurity http) throws Exception {
//        http.authorizeRequests()
//                .antMatchers("/api/stock/*/**")
//                .hasRole("ADMIN")
//                .antMatchers("swagger-ui.html").permitAll()
//                .anyRequest()
//                .authenticated();
//    }
//}
