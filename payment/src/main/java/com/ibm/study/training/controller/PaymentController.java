package com.ibm.study.training.controller;

import com.ibm.study.training.pojo.RespMsg;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
@Slf4j
public class PaymentController {

    @GetMapping("list")
    public RespMsg list() {
        log.info("begin list");
        RespMsg respMsg = new RespMsg();
        respMsg.setData("payment list");
        respMsg.setCode("1000");
        respMsg.setStatus(true);
        respMsg.setMsg("list successful.");
        return respMsg;
    }


}
