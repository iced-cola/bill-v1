package com.bill.constant;

import lombok.Getter;

/**
 * @author :  zhulongkun20@gmail.com
 * @create :  10-21-2020 17:23:07
 * @description :  返回状态
 * @since :  v1.0
 */
@Getter
public enum ResultEnum {
    SUCCESS(0, "成功"),
    FAILED(-1, "失败");

    private Integer code;

    private String message;

    ResultEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
