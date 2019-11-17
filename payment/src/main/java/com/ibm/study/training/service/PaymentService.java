package com.ibm.study.training.service;


import com.ibm.study.training.pojo.PaymentDTO;

import java.util.List;

public interface PaymentService {

    boolean save(PaymentDTO paymentDTO);

    boolean delete(Long id);

    boolean update(PaymentDTO paymentDTO);

    PaymentDTO findById(Long id);

    List<PaymentDTO> findByUserId(Long userId);

}
