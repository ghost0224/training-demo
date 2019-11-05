package com.ibm.study.training.controller;

import com.ibm.study.training.feignclient.PaymentService;
import com.ibm.study.training.pojo.RespMsg;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/")
@Slf4j
public class LoginController {

    @Autowired
    private PaymentService paymentService;

    @GetMapping("logout")
    public @ResponseBody RespMsg logout(HttpServletRequest request) {
        log.info("begin logout");
        RespMsg respMsg = new RespMsg();
        HttpSession session = request.getSession(true);
        session.setAttribute("user", null);
        Object o = paymentService.list();
        respMsg.setData(o);
        respMsg.setCode("1003");
        respMsg.setStatus(true);
        respMsg.setMsg("logout successful.");
        return respMsg;
    }

    @GetMapping("login")
    public @ResponseBody RespMsg login(HttpServletRequest request) {
        log.info("begin login");
        RespMsg respMsg = new RespMsg();
        respMsg.setCode("0001");
        respMsg.setMsg("no account info or wrong password.");
        return respMsg;
    }

}
