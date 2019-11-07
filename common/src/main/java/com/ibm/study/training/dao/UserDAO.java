package com.ibm.study.training.dao;

import com.ibm.study.training.entity.UserEO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDAO extends JpaRepository<UserEO, Long> {

    UserEO findByUsername(String username);

}
