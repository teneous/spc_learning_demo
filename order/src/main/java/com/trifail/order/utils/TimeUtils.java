package com.trifail.order.utils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * Created by syoka on 2019/3/12.
 */
public final class TimeUtils {

    private static final DateTimeFormatter simpleFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    private static final DateTimeFormatter fullFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    private TimeUtils(){ }

    public static String normalFormatDate(LocalDate date){
        return simpleFormat.format(date);
    }

    public static String fullFormatDate(LocalDate date){
        return simpleFormat.format(date);
    }
}
