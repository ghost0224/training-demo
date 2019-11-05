package com.ibm.study.training.util;

import com.ibm.study.training.pojo.RespMsg;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = RuntimeException.class)
    @ResponseBody
    public RespMsg handle(RuntimeException e){
        log.error(e.getMessage(), e);
        RespMsg respMsg = new RespMsg();
        respMsg.setCode("0000");
        respMsg.setMsg(e.getMessage());
        respMsg.setStatus(false);
        respMsg.setData(e);
        return respMsg;
    }

}
