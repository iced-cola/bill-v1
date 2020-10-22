package com.bill.test;

import java.util.Properties;

/**
 * @author :  zhulongkun20@gmail.com
 * @create :  10-22-2020 12:32:24
 * @description :  测试类
 * @since :  v1.0
 */
public class Text {
    public static void main(String[] args) {
        Properties properties = System.getProperties();
        System.out.println(properties.getProperty("java.version"));
    }
}
