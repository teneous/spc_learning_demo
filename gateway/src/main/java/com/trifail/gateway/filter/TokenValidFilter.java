package com.trifail.gateway.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.trifail.gateway.utils.FilterUtils;
import org.springframework.http.HttpStatus;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;

public class TokenValidFilter extends ZuulFilter {

    @Override
    public String filterType() {
        return FilterUtils.PRE_TYPE;
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() {
        //自定义错误信息
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
        String access_token = request.getHeader("Authorization");
        if (access_token == null) {
            ctx.setSendZuulResponse(false);
            ctx.setResponseStatusCode(HttpStatus.UNAUTHORIZED.value());
            ctx.setResponseBody(getAuthorizationBody());
            ctx.getResponse().setContentType("application/json");
        }
        return null;
    }

    private String getAuthorizationBody() {
        String body = "{\n" +
                "  \"timestamp\": \""+ LocalDateTime.now()+"\",\n" +
                "  \"status\": 401,\n" +
                "  \"error\": \"Internal Server Error\",\n" +
                "  \"message\": \"Not Authorization\"\n" +
                "}";
        return body;
    }
}
