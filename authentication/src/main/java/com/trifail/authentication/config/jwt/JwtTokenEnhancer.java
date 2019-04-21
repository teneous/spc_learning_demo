package com.trifail.authentication.config.jwt;

import com.trifail.authentication.model.SysUser;
import com.trifail.authentication.repository.SysUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class JwtTokenEnhancer implements TokenEnhancer {

    @Autowired
    private SysUserRepository sysUserRepository;

    @Override
    public OAuth2AccessToken enhance(OAuth2AccessToken accessToken, OAuth2Authentication authentication) {
        Map<String,Object> metaMap = new HashMap<>();
        //不推荐存放敏感信息
        String terminalType = getUser(authentication.getName());
        metaMap.put("provider","syoka");
        metaMap.put("terminal",terminalType);
        ((DefaultOAuth2AccessToken)accessToken).setAdditionalInformation(metaMap);
        return accessToken;
    }

    private String getUser(String username){
        Optional<SysUser> sysUser = sysUserRepository.findByUsername(username);
        return sysUser.map(user -> user.getTerminalType() + "").orElse("-1");
    }
}
