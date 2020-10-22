package com.bill.converter;

import com.bill.constant.InOutEnum;
import com.bill.form.BillForm;
import com.bill.po.BillPo;
import com.bill.po.PayWayPo;
import com.bill.po.UsageTypePo;
import com.bill.util.DateFormatUtil;
import com.bill.util.EnumUtil;
import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @author :  zhulongkun20@gmail.com
 * @create :  10-21-2020 22:40:52
 * @description :  转换类
 * @since :  v1.0
 */
public class BillPo2BillFormConverter {

    public static List<BillForm> converter(List<BillPo> billPoList, List<UsageTypePo> usageTypePoList, List<PayWayPo> payWayPoList) {
        List<BillForm> billFormList = new ArrayList<>();
        billPoList.forEach(billPo -> {
            BillForm billForm = new BillForm();
            BeanUtils.copyProperties(billPo, billForm);
            billForm.setFormattedBillDate(DateFormatUtil.format(billPo.getBillDate()));
            billForm.setInOutName(Objects.requireNonNull(EnumUtil.getByCode(billPo.getInOut(), InOutEnum.class)).getNote());
            for (UsageTypePo usageTypePo : usageTypePoList) {
                if (Objects.equals(billPo.getUsageType(), String.valueOf(usageTypePo.getId()))) {
                    billForm.setUsageTypeName(usageTypePo.getTypeName());
                }
            }
            for (PayWayPo payWayPo : payWayPoList) {
                if (Objects.equals(billPo.getPayWay(), String.valueOf(payWayPo.getId()))) {
                    billForm.setPayWayName(payWayPo.getWayName());
                }
            }
            billFormList.add(billForm);
        });
        return billFormList;
    }

}
