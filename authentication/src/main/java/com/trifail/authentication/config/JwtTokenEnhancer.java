package com.trifail.authentication.config;

import com.trifail.authentication.model.SysUser;
import com.trifail.authentication.repository.SysUserRepository;
import com.trifail.basis.model.ClientInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class JwtTokenEnhancer implements TokenEnhancer {

    @Override
    public OAuth2AccessToken enhance(OAuth2AccessToken accessToken, OAuth2Authentication authentication) {
        Map<String,Object> metaMap = new HashMap<>();
        metaMap.put("email",authentication.getName());
        ((DefaultOAuth2AccessToken)accessToken).setAdditionalInformation(metaMap);
        return accessToken;
    }
}
