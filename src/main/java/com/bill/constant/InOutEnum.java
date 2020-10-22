package com.bill.constant;

import lombok.Getter;

/**
 * @author :  zhulongkun20@gmail.com
 * @create :  10-19-2020 18:51:36
 * @description :  收入支出类型枚举
 * @since :  v1.0
 */
@Getter
public enum InOutEnum {
    INCOME(0, "收入"),
    EXPENSES(1, "支出"),
    BORROW(2, "借入"),
    LEND(3, "借出");

    private Integer code;

    private String note;

    InOutEnum(Integer code, String note) {
        this.code = code;
        this.note = note;
    }
}
