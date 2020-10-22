package com.bill.repository;

import com.bill.po.BillPo;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class BillRepositoryTest {

    @Autowired
    private BillRepository billRepository;

    @Test
    public void saveTest() {
        BillPo billPo = new BillPo();
        billPo.setBillId("20200101005");
        billPo.setBillDate("20200101");
        billPo.setAmount(new BigDecimal("50.20"));
        billPo.setInOut(0);
        billPo.setUsageType("00");
        billPo.setPayWay("00");
        billPo.setDetail("淘宝点外卖的消费记录。");
        BillPo result = billRepository.save(billPo);
        Assert.assertNotNull(result);
    }

    @Test
    public void findOneTest() {
        String id = "20200101001";
        Optional<BillPo> billPo = billRepository.findById(id);
        if (billPo.isPresent()) {
            log.info(String.valueOf(billPo.get()));
        } else {
            log.error("未找到结果。");
        }
    }

    @Test
    public void findAllTest() {
        List<BillPo> billPos = billRepository.findAll();
        Assert.assertSame(5, billPos.size());
    }

    @Test
    public void updateTest() {
        String id = "20200101005";
        Optional<BillPo> billPo = billRepository.findById(id);
        if (billPo.isPresent()) {
            billPo.get().setAmount(new BigDecimal("23.80"));
            billRepository.save(billPo.get());
        }
    }

    @Test
    public void findMaxIdTest() {
        String billDate = "20200101";
        String maxId = billRepository.findMaxIdByBillDate(billDate);
        log.info("maxId = {}", maxId);
    }
}