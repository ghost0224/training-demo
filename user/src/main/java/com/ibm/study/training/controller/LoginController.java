package com.ibm.study.training.controller;

import com.ibm.study.training.feignclient.PaymentService;
import com.ibm.study.training.pojo.RespMsg;
import com.ibm.study.training.pojo.UserDTO;
import com.ibm.study.training.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/")
@Slf4j
public class LoginController {

    @Autowired
    private PaymentService paymentService;

    @Autowired
    private UserService userService;

    @PostMapping("logout")
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

    @PostMapping("login")
    public @ResponseBody RespMsg login(HttpServletRequest request, @RequestBody UserDTO userDTO) {
        log.info("begin login");
        RespMsg respMsg = new RespMsg();
        UserDTO user = userService.login(userDTO);
        if (null != user) {
            respMsg.setCode("1001");
            respMsg.setStatus(true);
            respMsg.setMsg("login successful.");
        } else {
            respMsg.setCode("0001");
            respMsg.setMsg("no account info or wrong password.");
        }
        return respMsg;
    }

    @PostMapping("register")
    public @ResponseBody RespMsg register(HttpServletRequest request, @RequestBody UserDTO userDTO) {
        log.info("begin register");
        RespMsg respMsg = new RespMsg();
        if(userService.save(userDTO)) {
            respMsg.setCode("1002");
            respMsg.setStatus(true);
            respMsg.setMsg("register successful.");
        } else {
            respMsg.setCode("0002");
            respMsg.setMsg("register failure.");
        }
        return respMsg;
    }

}
