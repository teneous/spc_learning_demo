package com.trifail.gateway.config;

import com.trifail.gateway.filter.TokenValidFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CustomizedZuulConfig {

    @Bean
    public TokenValidFilter tokenValidFilter(){
        return new TokenValidFilter();
    }
}
