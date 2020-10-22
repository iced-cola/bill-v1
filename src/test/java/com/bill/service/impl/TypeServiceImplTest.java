//package com.bill.service.impl;
//
//import com.bill.constant.ConstantValue;
//import com.bill.po.CodePo;
//import com.bill.service.TypeService;
//import lombok.extern.slf4j.Slf4j;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit4.SpringRunner;
//
//import javax.annotation.Resource;
//
//@RunWith(SpringRunner.class)
//@SpringBootTest
//@Slf4j
//public class TypeServiceImplTest {
//
//    @Resource
//    private TypeService codeService;
//
//    @Test
//    public void createTest() {
//        CodePo codePo = new CodePo();
//        codePo.setCode(ConstantValue.PAY_WAY_PREFIX);
//        codePo.setCodeName("支付宝银行卡");
//        codeService.create(codePo);
//
//        CodePo codePo1 = new CodePo();
//        codePo1.setCode(ConstantValue.USAGE_TYPE);
//        codePo1.setCodeName("餐饮");
//        codeService.create(codePo1);
//    }
//}