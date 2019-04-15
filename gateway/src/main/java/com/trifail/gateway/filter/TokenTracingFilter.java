package com.trifail.gateway.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import com.trifail.basis.model.ClientInfo;
import com.trifail.gateway.utils.FilterUtils;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Header;
import io.jsonwebtoken.Jwts;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TokenTracingFilter extends ZuulFilter {

    @Autowired
    private FilterUtils filterUtils;
    private String signingKey = "trifail";

    @Override
    public String filterType() {
        return FilterUtils.PRE_TYPE;
    }

    @Override
    public int filterOrder() {
        return 6;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        RequestContext currentContext = RequestContext.getCurrentContext();
        ClientInfo infoFromJwt = getInfoFromJwt();
        return null;
    }

    private ClientInfo getInfoFromJwt(){
        String authToken = filterUtils.getAuthToken();
        ClientInfo clientInfo = null;
        if (StringUtils.isNotEmpty(authToken)) {
            if (authToken.startsWith("Bearer ")) {
                String jwtToken = authToken.replace("Bearer ", "");
                Claims body = Jwts.parser()
                        .setSigningKey(signingKey.getBytes())
                        .parseClaimsJwt(jwtToken).getBody();
                Header header = Jwts.parser()
                        .setSigningKey(signingKey.getBytes())
                        .parseClaimsJwt(jwtToken).getHeader();
                clientInfo = body.get("client_info", ClientInfo.class);
                return clientInfo;
            }
        }
        return null;
    }
}
