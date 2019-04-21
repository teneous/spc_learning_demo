package com.trifail.basis.vo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;


public class JwtConfig {

//    @Value(value = "${Jwt.header}")
    public String header = "Authorization";
//    @Value(value = "${Jwt.prefix}")
    public String prefix ="Bearer ";
//    @Value(value = "${Jwt.signkey}")
    public String signkey ="49ced7862ea5ec9f0746";

}
