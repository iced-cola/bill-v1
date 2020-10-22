package com.bill.util;

import com.bill.constant.ResultEnum;
import com.bill.vo.ResultVO;

/**
 * @author :  zhulongkun20@gmail.com
 * @create :  10-21-2020 17:20:48
 * @description :  返回结果前端用
 * @since :  v1.0
 */
public class ResultUtil<T> {

    public static ResultVO success(Object object) {
        ResultVO resultVO = new ResultVO();
        resultVO.setCode(ResultEnum.SUCCESS.getCode());
        resultVO.setMessage(ResultEnum.SUCCESS.getMessage());
        resultVO.setData(object);
        return resultVO;
    }

}
