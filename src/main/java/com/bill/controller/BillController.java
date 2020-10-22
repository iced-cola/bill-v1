package com.bill.controller;

import com.bill.constant.ConstantValue;
import com.bill.form.BillForm;
import com.bill.po.BillPo;
import com.bill.po.PayWayPo;
import com.bill.po.SearchForm;
import com.bill.po.UsageTypePo;
import com.bill.repository.PayWayRepository;
import com.bill.repository.UsageTypeRepository;
import com.bill.service.BillService;
import com.bill.util.ResultUtil;
import com.bill.vo.MyPage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

import static com.bill.constant.ConstantValue.RESULT_KEY;

/**
 * @author :  zhulongkun20@gmail.com
 * @create :  10-19-2020 19:45:51
 * @description :  账单api
 * @since :  v1.0
 */
@Controller
@RequestMapping("/bill")
@Slf4j
public class BillController {

    @Autowired
    private UsageTypeRepository usageTypeRepository;

    @Autowired
    private PayWayRepository payWayRepository;

    @Autowired
    private BillService billService;

    @GetMapping("/list")
    public ModelAndView list(@RequestParam(value = "page", defaultValue = "1") Integer page,
                             @RequestParam(value = "size", defaultValue = ConstantValue.DEFAULT_PAGE_SIZE_STR) Integer size) {
        ModelAndView modelAndView = new ModelAndView();
        PageRequest pageRequest = PageRequest.of(page, size);
        MyPage<BillForm> billPoPage = billService.findBillList(pageRequest);
        var result = ResultUtil.success(billPoPage);
        modelAndView.addObject(RESULT_KEY, result);
        modelAndView.addObject("currentPage", page);
        List<UsageTypePo> usageTypePos = usageTypeRepository.findAll();
        modelAndView.addObject("usageList", usageTypePos);
        List<PayWayPo> payWayPos = payWayRepository.findAll();
        modelAndView.addObject("payWayList", payWayPos);
        modelAndView.setViewName("bill");
        return modelAndView;
    }

    @PostMapping("/create")
    public String create(@RequestParam("billDate") String billDate,
                         @RequestParam("amount") BigDecimal amount,
                         @RequestParam("inOut") Integer inOut,
                         @RequestParam("usageType") String usageType,
                         @RequestParam("payWay") String payWay,
                         @RequestParam("detail") String detail) {
        BillPo billPo = new BillPo(billDate, amount, inOut, usageType, payWay, detail);
        log.info("【创建账单】参数billPo={}", billPo);
        billService.create(billPo);
        return "redirect:/bill/list";
    }

    @GetMapping("/search")
    public ModelAndView search(String year, String month, String usageType, String payWay) {
        ModelAndView modelAndView = new ModelAndView();
        SearchForm searchForm = new SearchForm(year, month, usageType, payWay);
        MyPage<BillForm> billPoPage = billService.searchBillList(searchForm);
        var result = ResultUtil.success(billPoPage);
        modelAndView.addObject(RESULT_KEY, result);
        modelAndView.addObject("currentPage", 1);
        List<UsageTypePo> usageTypePos = usageTypeRepository.findAll();
        modelAndView.addObject("usageList", usageTypePos);
        List<PayWayPo> payWayPos = payWayRepository.findAll();
        modelAndView.addObject("payWayList", payWayPos);
        modelAndView.setViewName("bill");
        return modelAndView;
    }

    @GetMapping("/type")
    public ModelAndView type() {
        ModelAndView modelAndView = new ModelAndView();
        List<String> usageTypeList = usageTypeRepository.findAll()
                .stream()
                .map(UsageTypePo::getTypeName)
                .collect(Collectors.toList());
        List<String> payWayList = payWayRepository.findAll()
                .stream()
                .map(PayWayPo::getWayName)
                .collect(Collectors.toList());
        modelAndView.addObject("typeList", usageTypeList);
        modelAndView.addObject("wayList", payWayList);
        modelAndView.setViewName("types");
        return modelAndView;
    }

}
