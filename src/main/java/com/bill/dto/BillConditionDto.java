package com.bill.dto;

import lombok.Data;

import java.util.List;

/**
 * @author :  zhulongkun20@gmail.com
 * @create :  12-19-2020 22:21:47
 * @description :  账单检索条件
 * @since :  v1.0
 */
@Data
public class BillConditionDto {

    private String billDateFrom;

    private String billDateTo;

    private List<String> inOutNameList;

    private List<String> usageTypeList;

    private List<String> payWayList;

    private String detail;

}
