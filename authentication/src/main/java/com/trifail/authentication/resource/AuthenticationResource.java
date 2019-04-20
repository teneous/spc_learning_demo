package com.trifail.authentication.resource;

import com.trifail.authentication.model.SysUser;
import com.trifail.authentication.repository.SysUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@RestController
public class AuthenticationResource {

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    @Autowired
    private SysUserRepository sysUserRepository;

    @GetMapping(value = "/auth/user",produces = "application/json")
    public Map<String,Object> user(OAuth2Authentication user){
        Map<String,Object> map = new HashMap<>() ;
        map.put("user",user.getUserAuthentication().getPrincipal());
        map.put("authorization",user.getUserAuthentication().getAuthorities());
        return map;
    }

    @PostMapping(value = "/sign-up",produces = "application/json")
    public void signUp(@Valid @RequestBody SysUser user){
        String encodePwd = bCryptPasswordEncoder.encode(user.getPassword());
        user.setPassword(encodePwd);
        sysUserRepository.save(user);
    }
}
