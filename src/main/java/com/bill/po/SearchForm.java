package com.bill.po;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author :  zhulongkun20@gmail.com
 * @create :  10-22-2020 09:35:27
 * @description :  检索条件
 * @since :  v1.0
 */
@Data
@AllArgsConstructor
public class SearchForm {

    private String year;

    private String month;

    private String usageType;

    private String payWay;

}
