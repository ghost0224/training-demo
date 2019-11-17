package com.ibm.study.training.feignclient;

import com.ibm.study.training.pojo.RespMsg;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(serviceId = "payment")
public interface PaymentService {

    @PostMapping("findByUserId/{userId}")
    RespMsg findByUserId(@PathVariable("userId") Long userId);

}
