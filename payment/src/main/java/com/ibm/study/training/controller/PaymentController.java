package com.ibm.study.training.controller;

import com.ibm.study.training.pojo.PaymentDTO;
import com.ibm.study.training.pojo.RespMsg;
import com.ibm.study.training.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/payment")
@Slf4j
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @PostMapping("findById")
    public RespMsg findById(@RequestBody PaymentDTO paymentDTO) {
        log.info("begin findById");
        RespMsg respMsg = new RespMsg();
        PaymentDTO payment = paymentService.findById(paymentDTO.getId());
        respMsg.setCode("1305");
        respMsg.setStatus(true);
        respMsg.setData(payment);
        respMsg.setMsg("find successful.");
        return respMsg;
    }

    @PostMapping("findByUserId/{userId}")
    public RespMsg findByUserId(@PathVariable("userId") Long userId) {
        log.info("begin findByUserId");
        RespMsg respMsg = new RespMsg();
        List<PaymentDTO> paymentList = paymentService.findByUserId(userId);
        respMsg.setCode("1301");
        respMsg.setStatus(true);
        respMsg.setData(paymentList);
        respMsg.setMsg("find successful.");
        return respMsg;
    }

    @PostMapping("save")
    public @ResponseBody RespMsg save(@RequestBody PaymentDTO paymentDTO) {
        log.info("begin save");
        RespMsg respMsg = new RespMsg();
        if(paymentService.save(paymentDTO)) {
            respMsg.setCode("1302");
            respMsg.setStatus(true);
            respMsg.setMsg("save successful.");
        } else {
            respMsg.setCode("0302");
            respMsg.setMsg("save failure.");
        }
        return respMsg;
    }

    @PostMapping("update")
    public @ResponseBody RespMsg update(@RequestBody PaymentDTO paymentDTO) {
        log.info("begin update");
        RespMsg respMsg = new RespMsg();
        if(paymentService.update(paymentDTO)) {
            respMsg.setCode("1303");
            respMsg.setStatus(true);
            respMsg.setMsg("update successful.");
        } else {
            respMsg.setCode("0303");
            respMsg.setStatus(false);
            respMsg.setMsg("update failure.");
        }
        return respMsg;
    }

    @PostMapping("delete")
    public @ResponseBody RespMsg delete(@RequestBody PaymentDTO paymentDTO) {
        log.info("begin delete");
        RespMsg respMsg = new RespMsg();
        if(paymentService.delete(paymentDTO.getId())) {
            respMsg.setCode("1304");
            respMsg.setStatus(true);
            respMsg.setMsg("delete successful.");
        } else {
            respMsg.setCode("0304");
            respMsg.setMsg("delete failure.");
        }
        return respMsg;
    }

}
