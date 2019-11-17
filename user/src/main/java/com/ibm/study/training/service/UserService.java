package com.ibm.study.training.service;


import com.ibm.study.training.pojo.TrainingDTO;
import com.ibm.study.training.pojo.UserDTO;

public interface UserService {

    UserDTO login(UserDTO userDTO);

    boolean save(UserDTO userDTO);

    boolean delete(Long id);

    boolean update(UserDTO userDTO);

    UserDTO findById(Long id);

    boolean book(UserDTO userDTO, TrainingDTO trainingDTO);
}
