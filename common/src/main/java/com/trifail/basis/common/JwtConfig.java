package com.trifail.basis.common;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JwtConfig {

    @Value(value = "${jwt.config.header}")
    public String header = "Authorization";
    @Value(value = "${jwt.config.prefix}")
    public String prefix ="Bearer ";
    @Value(value = "${jwt.config.signkey}")
    public String signkey ="49ced7862ea5ec9f0746";

}
