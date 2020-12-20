package com.bill.repository;

import com.bill.po.InOutPo;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class InOutRepositoryTest {

    @Resource
    private InOutRepository repository;

    @Test
    public void test() {
        List<InOutPo> all = repository.findAll();
        assertNotNull(all);
        log.info("result: {}", all);
    }

}
