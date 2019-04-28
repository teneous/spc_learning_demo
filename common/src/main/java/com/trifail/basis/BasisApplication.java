package com.trifail.basis;

import com.trifail.basis.common.JwtConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

@EnableEurekaClient
@SpringBootApplication
@RestController
public class BasisApplication {

    @Autowired
    private JwtConfig jwtConfig;

    public static void main(String[] args) {
        SpringApplication.run(BasisApplication.class, args);
    }


}
