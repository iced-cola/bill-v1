package com.bill.util;

import com.bill.constant.InOutEnum;

/**
 * @author :  zhulongkun20@gmail.com
 * @create :  10-20-2020 20:35:19
 * @description :  Enum类型工具类
 * @since :  v1.0
 */
public class EnumUtil {

    public static <T extends InOutEnum> T getByCode(Integer code, Class<T> enumClazz) {
        for (T inOutEnum : enumClazz.getEnumConstants()) {
            if (inOutEnum.getCode().equals(code)) {
                return inOutEnum;
            }
        }
        return null;
    }

}
