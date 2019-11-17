package com.ibm.study.training.service;


import com.ibm.study.training.pojo.SkillDTO;

import java.util.List;

public interface SkillService {

    boolean save(SkillDTO skillDTO);

    boolean delete(Long id);

    boolean update(SkillDTO skillDTO);

    SkillDTO findById(Long id);

    List<SkillDTO> search(String name);

}
