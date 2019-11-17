package com.ibm.study.training.dao;

import com.ibm.study.training.entity.SkillEO;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SkillDAO extends JpaRepository<SkillEO, Long> {

    List<SkillEO> findByNameLike(String name);

}
