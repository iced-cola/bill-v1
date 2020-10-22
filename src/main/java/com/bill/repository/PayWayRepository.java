package com.bill.repository;

import com.bill.po.PayWayPo;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author :  zhulongkun20@gmail.com
 * @create :  10-22-2020 08:11:19
 * @description :  pay way repository
 * @since :  v1.0
 */
public interface PayWayRepository extends JpaRepository<PayWayPo, Integer> {

}
