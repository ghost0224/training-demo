package com.ibm.study.training.dao;

import com.ibm.study.training.entity.RoleEO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleDAO extends JpaRepository<RoleEO, Long> {

    RoleEO findByName(String name);

}
