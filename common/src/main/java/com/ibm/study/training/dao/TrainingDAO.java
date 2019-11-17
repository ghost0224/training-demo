package com.ibm.study.training.dao;

import com.ibm.study.training.entity.TrainingEO;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TrainingDAO extends JpaRepository<TrainingEO, Long> {

    List<TrainingEO> findByTitleLike(String title);

}
