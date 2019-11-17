package com.ibm.study.training.dao;

import com.ibm.study.training.entity.PaymentEO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentDAO extends JpaRepository<PaymentEO, Long> {

}
