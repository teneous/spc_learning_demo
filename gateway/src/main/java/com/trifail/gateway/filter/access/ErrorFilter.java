//package com.trifail.gateway.filter.access;
//
//import com.netflix.zuul.ZuulFilter;
//import com.netflix.zuul.context.RequestContext;
//import com.netflix.zuul.exception.ZuulException;
//import com.trifail.gateway.filter.FilterUtils;
//
//public class ErrorFilter extends ZuulFilter {
//    @Override
//    public String filterType() {
//        return FilterUtils.ERRPR_TYPE;
//    }
//
//    @Override
//    public int filterOrder() {
//        return 10;
//    }
//
//    @Override
//    public boolean shouldFilter() {
//        return true;
//    }
//
//    @Override
//    public Object run() throws ZuulException {
//        RequestContext currentContext = RequestContext.getCurrentContext();
//        Throwable throwable = currentContext.getThrowable();
//        if (throwable != null) {
//            currentContext.remove("error.status_code");
//            currentContext.getResponse().setContentType("application/json");
//            currentContext.setResponseStatusCode(500);
//        }
//        return null;
//    }
//}
