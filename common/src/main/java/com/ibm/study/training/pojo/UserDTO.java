package com.ibm.study.training.pojo;

import lombok.Data;

@Data
public class UserDTO {

    private Long id;
    private String name;
    private String email;
    private String username;
    private String password;
    private RoleDTO role;
    private String verifyCode;

}
