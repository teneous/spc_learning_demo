package com.trifail.gateway.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JwtConfig {

    @Value(value = "${gateway.jwt.header}")
    public String header;
    @Value(value = "${gateway.jwt.prefix}")
    public String prefix;
    @Value(value = "${gateway.jwt.signkey}")
    public String signkey;

}
