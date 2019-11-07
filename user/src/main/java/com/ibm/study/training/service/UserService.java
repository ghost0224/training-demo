package com.ibm.study.training.service;


import com.ibm.study.training.pojo.UserDTO;

public interface UserService {

    UserDTO login(UserDTO accountDTO);

    boolean save(UserDTO accountDTO);

    boolean delete(Long id);

    boolean update(UserDTO accountDTO);

    UserDTO findById(Long id);
}
