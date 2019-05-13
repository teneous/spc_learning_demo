//package com.trifail.protocol.util;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.MessageSource;
//import org.springframework.context.i18n.LocaleContextHolder;
//
//import java.util.Locale;
//
//public class PropertyUtil {
//
//    @Autowired
//    private MessageSource messageSource;
//
//    public String getMessage(String result, Object[] params) {
//        String message = "";
//        try {
//            Locale locale = LocaleContextHolder.getLocale();
//            message = messageSource.getMessage(result, params, locale);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return message;
//    }
//
//}
