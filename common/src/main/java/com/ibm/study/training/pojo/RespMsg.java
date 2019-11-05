package com.ibm.study.training.pojo;

import lombok.Data;

@Data
public class RespMsg {

    private boolean status;
    private String code;
    private String msg;
    private String error;
    private Object data;

}
