package com.trifail.authentication.resource;

import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class AuthenticationResource {

    @GetMapping(value = "/auth/user",produces = "application/json")
    public Map<String,Object> user(OAuth2Authentication user){
        Map<String,Object> map = new HashMap<>() ;
        map.put("user",user.getUserAuthentication().getPrincipal());
        map.put("authorization",user.getUserAuthentication().getAuthorities());
        return map;
    }
}
