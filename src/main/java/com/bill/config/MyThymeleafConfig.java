package com.bill.config;

import com.bill.constant.InOutEnum;
import org.springframework.context.annotation.Configuration;
import org.thymeleaf.spring5.view.ThymeleafViewResolver;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * @author :  zhulongkun20@gmail.com
 * @create :  10-22-2020 08:50:01
 * @description :  thymeleaf配置类
 * @since :  v1.0
 */
@Configuration
public class MyThymeleafConfig {
    @Resource
    private void configureThymeleafStaticVars(ThymeleafViewResolver viewResolver) {
        if (viewResolver != null) {
            Map<String, Object> vars = new HashMap<>();
            vars.put("GLOBAL_INOUT_INCOME_CODE", InOutEnum.INCOME.getCode());
            vars.put("GLOBAL_INOUT_INCOME_NAME", InOutEnum.INCOME.getNote());
            vars.put("GLOBAL_INOUT_EXPENSE_CODE", InOutEnum.EXPENSES.getCode());
            vars.put("GLOBAL_INOUT_EXPENSE_NAME", InOutEnum.EXPENSES.getNote());
            vars.put("GLOBAL_INOUT_BORROW_CODE", InOutEnum.BORROW.getCode());
            vars.put("GLOBAL_INOUT_BORROW_NAME", InOutEnum.BORROW.getNote());
            vars.put("GLOBAL_INOUT_LEND_CODE", InOutEnum.LEND.getCode());
            vars.put("GLOBAL_INOUT_LEND_NAME", InOutEnum.LEND.getNote());
            viewResolver.setStaticVariables(vars);
        }
    }
}
