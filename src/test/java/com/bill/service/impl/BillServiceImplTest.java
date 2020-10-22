package com.bill.service.impl;

import com.bill.constant.InOutEnum;
import com.bill.dto.BillDto;
import com.bill.po.BillPo;
import com.bill.service.BillService;
import com.bill.vo.MyPage;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class BillServiceImplTest {

    @Autowired
    private BillService billService;

    @Test
    public void create() {
        BillPo billPo = new BillPo();
        billPo.setBillDate("20200101");
        billPo.setAmount(new BigDecimal("50.50"));
        billPo.setInOut(InOutEnum.EXPENSES.getCode());
        billPo.setUsageType("00");
        billPo.setPayWay("00");
        billPo.setDetail("创建账单测试8");

        BillPo billPo1 = new BillPo();
        billPo1.setBillDate("20200103");
        billPo1.setAmount(new BigDecimal("298.50"));
        billPo1.setInOut(InOutEnum.EXPENSES.getCode());
        billPo1.setUsageType("01");
        billPo1.setPayWay("01");
        billPo1.setDetail("创建账单测试5");

        billService.create(billPo);
        billService.create(billPo1);
    }

    @Test
    public void modify() {
    }

    @Test
    public void delete() {
    }

    @Test
    public void findBillListTest() {
//        PageRequest pageRequest = PageRequest.of(1, 5);
//        MyPage<BillPo> billList = billService.findBillList(pageRequest);
//        log.info(billList.toString());
//        Assert.assertNotNull(billList);
    }
}