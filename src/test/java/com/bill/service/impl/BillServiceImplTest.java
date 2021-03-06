package com.bill.service.impl;

import com.bill.dto.BillConditionDto;
import com.bill.dto.BillDto;
import com.bill.po.BillPo;
import com.bill.service.BillService;
import com.bill.vo.BillPage;
import com.bill.vo.Result;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.math.BigDecimal;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class BillServiceImplTest {

    @Resource
    private BillService billService;

    @Test
    public void create() {
        BillPo billPo = new BillPo();
        billPo.setBillDate("20200101");
        billPo.setAmount(new BigDecimal("50.50"));
//        billPo.setInOut(InOutEnum.EXPENSES.getCode());
        billPo.setUsageType("00");
        billPo.setPayWay("00");
        billPo.setDetail("创建账单测试8");

        BillPo billPo1 = new BillPo();
        billPo1.setBillDate("20200103");
        billPo1.setAmount(new BigDecimal("298.50"));
//        billPo1.setInOut(InOutEnum.EXPENSES.getCode());
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
        String id = "20200101001";
        billService.delete(id);
    }

    @Test
    public void listTest() {
        PageRequest pageRequest = PageRequest.of(1, 5);
        BillConditionDto conditionDto = new BillConditionDto();
        conditionDto.setDetail("外卖");
        Result<BillPage<BillDto>> result = billService.list(conditionDto, pageRequest);
        Assert.assertNotNull(result);
        log.info("result: \n{}", result);
    }
}
