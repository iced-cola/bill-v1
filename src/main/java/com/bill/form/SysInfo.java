package com.bill.form;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author :  zhulongkun20@gmail.com
 * @create :  10-22-2020 12:16:43
 * @description :  系统信息类
 * @since :  v1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SysInfo {

    private String osVersion;

    private String javaVersion;

    private String springBootVersion;

    private String mysqlVersion;

    private String thymeleafVersion;

}
