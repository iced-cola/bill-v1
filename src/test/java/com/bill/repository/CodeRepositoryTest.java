//package com.bill.repository;
//
//import com.bill.po.CodePo;
//import lombok.extern.slf4j.Slf4j;
//import org.junit.Assert;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit4.SpringRunner;
//
//@RunWith(SpringRunner.class)
//@SpringBootTest
//@Slf4j
//public class CodeRepositoryTest {
//
//    @Autowired
//    private CodeRepository codeRepository;
//
//    @Test
//    public void saveTest() {
//        CodePo codePo = new CodePo();
//        codePo.setCode("00");
//        codePo.setCodeValue("01");
//        codePo.setCodeName("微信银行卡支付");
//        CodePo result = codeRepository.save(codePo);
//        Assert.assertNotNull(result);
//    }
//
//    @Test
//    public void findTest() {
//        String code = "00";
//        String codeValue = "00";
//        codeRepository.findByCodeAndCodeValue(code, codeValue);
//    }
//
//    @Test
//    public void findMaxCodeValueByCodeTest() {
//        String code = "00";
//        String maxCodeValue = codeRepository.findMaxCodeValueByCode(code);
//        log.info("result: {}", maxCodeValue);
//    }
//
//}