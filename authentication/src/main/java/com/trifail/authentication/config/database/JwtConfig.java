package com.trifail.authentication.config.database;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JwtConfig {

    @Value(value = "${authentication.jwt.header}")
    public String header;
    @Value(value = "${authentication.jwt.prefix}")
    public String prefix;
    @Value(value = "${authentication.jwt.signkey}")
    public String signkey;

}
