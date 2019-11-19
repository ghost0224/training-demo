package com.ibm.study.training.service;


import com.ibm.study.training.pojo.TrainingDTO;

import java.util.List;

public interface TrainingService {

    boolean save(TrainingDTO trainingDTO);

    boolean delete(Long id);

    boolean update(TrainingDTO trainingDTO);

    TrainingDTO findById(Long id);

    List<TrainingDTO> findByUserId(Long userId);

    List<TrainingDTO> search(String title);

}
