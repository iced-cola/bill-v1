package com.bill.service.impl;

import com.bill.constant.ExceptionEnum;
import com.bill.converter.BillPo2BillFormConverter;
import com.bill.exception.BillException;
import com.bill.form.BillForm;
import com.bill.po.BillPo;
import com.bill.po.PayWayPo;
import com.bill.po.SearchForm;
import com.bill.po.UsageTypePo;
import com.bill.repository.BillRepository;
import com.bill.repository.PayWayRepository;
import com.bill.repository.UsageTypeRepository;
import com.bill.service.BillService;
import com.bill.vo.MyPage;
import com.google.common.base.Strings;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.List;

/**
 * @author :  zhulongkun20@gmail.com
 * @create :  10-19-2020 20:04:11
 * @description :  账单Service功能实现
 * @since :  v1.0
 */
@Service
@Slf4j
public class BillServiceImpl implements BillService {

    private static final String BILL_ID_START_NO = "001";

    @Autowired
    private BillRepository billRepository;

    @Autowired
    private UsageTypeRepository usageTypeRepository;

    @Autowired
    private PayWayRepository payWayRepository;

    @Override
    public BillPo create(BillPo billPo) {
        // 1. 判断参数是否齐全
        if (!isValidBill(billPo)) {
            log.error("【创建账单】参数不正确, billPo={}", billPo);
            throw new BillException(ExceptionEnum.PARAM_ERROR);
        }

        // 格式化日期
        String billDate = billPo.getBillDate().replace("-", "");
        billPo.setBillDate(billDate);

        // 2. 生成主键id
        billPo.setBillId(genBillId(billPo.getBillDate()));

        // 3. 保存数据库
        return billRepository.save(billPo);
    }

    private boolean isValidBill(BillPo billPo) {
        return billPo != null
                && !Strings.isNullOrEmpty(billPo.getBillDate())
                && !Strings.isNullOrEmpty(String.valueOf(billPo.getAmount()))
                && !Strings.isNullOrEmpty(String.valueOf(billPo.getInOut()))
                && !Strings.isNullOrEmpty(billPo.getUsageType())
                && !Strings.isNullOrEmpty(billPo.getPayWay())
                && !Strings.isNullOrEmpty(billPo.getDetail());
    }

    /**
     * 根据账单日期生成最大编号作为id
     *
     * @param billDate 账单日期
     * @return 新记录的id
     */
    private String genBillId(String billDate) {
        String maxBillId = billRepository.findMaxIdByBillDate(billDate);
        if (Strings.isNullOrEmpty(maxBillId)) {
            maxBillId = billDate + BILL_ID_START_NO;
        } else {
            int no = Integer.parseInt(maxBillId.substring(maxBillId.length() - 3)) + 1;
            maxBillId = billDate + Strings.padStart(String.valueOf(no), 3, '0');
        }
        return maxBillId;
    }

    @Override
    public BillPo modify(BillPo billPo) {
        return null;
    }

    @Override
    public void delete(String id) {

    }

    @Override
    public MyPage<BillForm> findBillList(Pageable pageable) {
        PageRequest pageRequest = PageRequest.of(pageable.getPageNumber() - 1, pageable.getPageSize());
        Page<BillPo> billPoPage = billRepository.findAll(pageRequest);
        List<UsageTypePo> usageTypePoList = usageTypeRepository.findAll();
        List<PayWayPo> payWayPoList = payWayRepository.findAll();
        List<BillForm> billFormList = BillPo2BillFormConverter.converter(billPoPage.getContent(), usageTypePoList, payWayPoList);
        MyPage<BillForm> billFormMyPage = new MyPage<>();
        billFormMyPage.setTotalPages(billPoPage.getTotalPages());
        billFormMyPage.setDataList(billFormList);
        return billFormMyPage;
    }

    @Override
    public MyPage<BillForm> searchBillList(SearchForm searchForm) {
        if (searchForm == null) {
            log.error("【条件检索】参数不正确，检索条件全部为空");
            throw new BillException(ExceptionEnum.PARAM_ERROR);
        }
        Specification<BillPo> specification = (Specification<BillPo>) (root, criteriaQuery, criteriaBuilder) -> {
            List<Predicate> predicateList = new ArrayList<>();

            // 检索条件中年份和月份同时存在时
            if (searchForm.getYear() != null && searchForm.getMonth() != null) {
                String month = Strings.padStart(searchForm.getMonth(), 2, '0');
                String condition1 = searchForm.getYear() + month;
                predicateList.add(criteriaBuilder.like(root.get("billDate"), condition1 + "%"));
            }

            // 只有年份时
            if (searchForm.getYear() != null) {
                predicateList.add(criteriaBuilder.like(root.get("billDate"), searchForm.getYear() + "%"));
            }

            if (searchForm.getUsageType() != null && !searchForm.getUsageType().equals("选择用途分类")) {
                predicateList.add(criteriaBuilder.equal(root.get("usageType"), searchForm.getUsageType()));
            }

            if (searchForm.getPayWay() != null && !searchForm.getPayWay().equals("选择支付方式分类")) {
                predicateList.add(criteriaBuilder.equal(root.get("payWay"), searchForm.getPayWay()));
            }

            return criteriaBuilder.and(predicateList.toArray(new Predicate[0]));
        };

        List<BillPo> billPoList = this.billRepository.findAll(specification);

        List<UsageTypePo> usageTypePoList = usageTypeRepository.findAll();
        List<PayWayPo> payWayPoList = payWayRepository.findAll();
        List<BillForm> billFormList = BillPo2BillFormConverter.converter(billPoList, usageTypePoList, payWayPoList);
        MyPage<BillForm> myPage = new MyPage<>();
        myPage.setTotalPages(1);
        myPage.setDataList(billFormList);
        return myPage;
    }
}
