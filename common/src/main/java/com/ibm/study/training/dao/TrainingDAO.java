package com.ibm.study.training.dao;

import com.ibm.study.training.entity.TrainingEO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TrainingDAO extends JpaRepository<TrainingEO, Long> {

//    @Query("select t from TraingingEO t where t.title like '%title%'")
    List<TrainingEO> findByTitleLike(String title);

}
