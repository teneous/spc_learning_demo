package com.trifail.authentication.config.security;

import com.trifail.authentication.config.database.DataSourceConfig;
import com.trifail.authentication.config.jwt.JwtTokenConfig;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.provider.token.TokenEnhancerChain;
import java.util.Arrays;

/**
 * 认证
 */
@Configuration
public class OAuth2AuthorizationConfig extends AuthorizationServerConfigurerAdapter {

    private final DataSourceConfig dataSourceConfig;
    private final JwtTokenConfig jwtTokenConfig;
    private final WebSecurityConfig webSecurityConfig;

    public OAuth2AuthorizationConfig(DataSourceConfig dataSourceConfig, JwtTokenConfig jwtTokenConfig, WebSecurityConfig webSecurityConfig) {
        this.dataSourceConfig = dataSourceConfig;
        this.jwtTokenConfig = jwtTokenConfig;
        this.webSecurityConfig = webSecurityConfig;
    }

    /**
     * 用来配置客户端详情服务（ClientDetailsService）
     */
    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        clients.jdbc(dataSourceConfig.dataSource());
    }

    /**
     * 用来配置授权（authorization）以及令牌（token）的访问端点和令牌服务(token services)
     * @param endpoints
     */
    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
        TokenEnhancerChain enhancerChain = new TokenEnhancerChain();
        enhancerChain.setTokenEnhancers(Arrays.asList(
                jwtTokenConfig.jwtTokenEnhancer(),
                jwtTokenConfig.jwtAccessTokenConverter()));

        endpoints.authenticationManager(webSecurityConfig.authenticationManager())
                .userDetailsService(webSecurityConfig.userDetailsService())
                .tokenStore(jwtTokenConfig.tokenStore())
                .tokenEnhancer(enhancerChain)
                .accessTokenConverter(jwtTokenConfig.jwtAccessTokenConverter());
    }

}
