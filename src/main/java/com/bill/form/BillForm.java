package com.bill.form;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author :  zhulongkun20@gmail.com
 * @create :  10-20-2020 22:09:54
 * @description :  账单表单类
 * @since :  v1.0
 */
@Data
public class BillForm {

    // 检索条件
    private String searchYear;

    private String searchMonth;

    private String searchUsageType;

    private String billId;

    private String billDate;

    private String formattedBillDate;

    private BigDecimal amount;

    private Integer inOut;

    private String inOutName;

    private String usageType;

    private String usageTypeName;

    private String payWay;

    private String payWayName;

    private String detail;

    private Date createTime;

    private Date updateTime;

}
