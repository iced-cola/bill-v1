package com.bill.util;

/**
 * @author :  zhulongkun20@gmail.com
 * @create :  10-20-2020 21:23:18
 * @description :  日期格式化工具类
 * @since :  v1.0
 */
public class DateFormatUtil {

    private static final String DEFAULT_DATE_SEPARATOR = "-";

    public static String format(String yyyyMMdd, String separator) {
        String year = yyyyMMdd.substring(0, 4);
        String month = yyyyMMdd.substring(4, 6);
        String day = yyyyMMdd.substring(yyyyMMdd.length() - 2);
        return year + separator + month + separator + day;
    }

    public static String format(String yyyyMMdd) {
        return format(yyyyMMdd, DEFAULT_DATE_SEPARATOR);
    }

}
