package com.ibm.study.training.service.impl;

import com.ibm.study.training.dao.UserDAO;
import com.ibm.study.training.entity.RoleEO;
import com.ibm.study.training.entity.UserEO;
import com.ibm.study.training.pojo.UserDTO;
import com.ibm.study.training.service.UserService;
import com.ibm.study.training.util.CopyUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDAO userDAO;

    public UserDTO login(UserDTO userDTO) {
        UserEO userEO = userDAO.findByUsername(userDTO.getUsername());
        if (null != userEO && userEO.getPassword().equals(userDTO.getPassword())) {
            UserDTO result = CopyUtils.copy(userEO, UserDTO.class);
            return result;
        } else {
            return null;
        }
    }

    @Override
    public boolean save(UserDTO userDTO) {
        UserEO userEO = CopyUtils.copy(userDTO, UserEO.class);
        userEO.setId(null);
        RoleEO role = CopyUtils.copy(userDTO.getRole(), RoleEO.class);
        userEO.setRole(role);
        userDAO.save(userEO);
        if (null != userEO.getId()) {
            return true;
        }
        return false;
    }

    @Override
    public boolean delete(Long id) {
        userDAO.deleteById(id);
        return true;
    }

    @Override
    public boolean update(UserDTO userDTO) {
        UserEO userEO = CopyUtils.copy(userDTO, UserEO.class);
        userDAO.save(userEO);
        return true;
    }

    @Override
    public UserDTO findById(Long id) {
        UserEO userEO = userDAO.findById(id).get();
        UserDTO userDTO = CopyUtils.copy(userEO, UserDTO.class);
        return userDTO;
    }

}
