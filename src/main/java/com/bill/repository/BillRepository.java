package com.bill.repository;

import com.bill.po.BillPo;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * @author :  zhulongkun20@gmail.com
 * @create :  10-19-2020 17:46:06
 * @description :  账单实体类数据访问接口
 * @since :  v1.0
 */
public interface BillRepository extends JpaRepository<BillPo, String>, JpaSpecificationExecutor<BillPo> {

    // '#{#entityName}'值为'billPo'对象对应的数据表名称(bill)。
    @Query(value = "select max(billId) from #{#entityName} b where b.billId like concat(:billDate, '%')")
    String findMaxIdByBillDate(@Param("billDate") String billDate);

}
