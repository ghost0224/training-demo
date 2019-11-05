package com.ibm.study.training.feignclient;

import com.ibm.study.training.pojo.RespMsg;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(serviceId = "payment")
public interface PaymentService {

    @GetMapping("list")
    RespMsg list();

}
