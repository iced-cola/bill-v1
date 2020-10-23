package com.bill.service;

import com.bill.form.BillForm;
import com.bill.po.BillPo;
import com.bill.po.SearchForm;
import com.bill.vo.MyPage;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * @author :  zhulongkun20@gmail.com
 * @create :  10-19-2020 19:44:44
 * @description :  账单服务接口
 * @since :  v1.0
 */
public interface BillService {

    /**
     * 创建一条账单记录
     *
     * @param billPo 账单实体
     * @return 账单Dto
     */
    BillPo create(BillPo billPo);

    /**
     * 修改一条账单记录
     *
     * @param billPo 账单实体
     * @return 账单实体
     */
    void modify(BillPo billPo);

    /**
     * 删除一条账单记录
     *
     * @param id 主键id
     */
    void delete(String id);

    MyPage<BillForm> findBillList(Pageable pageable);

    MyPage<BillForm> searchBillList(SearchForm searchForm);

}
