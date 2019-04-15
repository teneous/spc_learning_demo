package com.trifail.gateway.utils;

import com.netflix.zuul.context.RequestContext;
import org.springframework.stereotype.Component;

@Component
public class FilterUtils {

    public final static String PRE_TYPE = "pre";
    public final static String ROUTE_TYPE = "route";
    public final static String POST_TYPE = "post";
    public final static String ERRPR_TYPE = "error";

    public static final String AUTH_TOKEN     = "Authorization";


    public final String getAuthToken(){
        RequestContext ctx = RequestContext.getCurrentContext();
        return ctx.getRequest().getHeader(AUTH_TOKEN);
    }

}
