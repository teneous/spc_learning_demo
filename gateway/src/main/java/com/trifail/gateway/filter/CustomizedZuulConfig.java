package com.trifail.gateway.filter;

import com.trifail.gateway.filter.access.TokenValidFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CustomizedZuulConfig {

    @Bean
    public TokenValidFilter tokenValidFilter(){
        return new TokenValidFilter();
    }
}
