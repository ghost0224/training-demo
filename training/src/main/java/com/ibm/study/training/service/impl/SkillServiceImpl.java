package com.ibm.study.training.service.impl;

import com.ibm.study.training.dao.SkillDAO;
import com.ibm.study.training.entity.SkillEO;
import com.ibm.study.training.pojo.SkillDTO;
import com.ibm.study.training.service.SkillService;
import com.ibm.study.training.util.CopyUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class SkillServiceImpl implements SkillService {

    @Autowired
    private SkillDAO skillDAO;

    @Override
    public boolean save(SkillDTO skillDTO) {
        SkillEO skillEO = CopyUtils.copy(skillDTO, SkillEO.class);
        skillEO.setId(null);
        skillDAO.save(skillEO);
        if (null != skillEO.getId()) {
            return true;
        }
        return false;
    }

    @Override
    public boolean delete(Long id) {
        skillDAO.deleteById(id);
        return true;
    }

    @Override
    public boolean update(SkillDTO skillDTO) {
        SkillEO skillEO = CopyUtils.copy(skillDTO, SkillEO.class);
        skillDAO.save(skillEO);
        if (null != skillEO.getId()) {
            return true;
        }
        return false;
    }

    @Override
    public SkillDTO findById(Long id) {
        SkillEO skillEO = skillDAO.findById(id).get();
        SkillDTO skillDTO = CopyUtils.copy(skillEO, SkillDTO.class);
        return skillDTO;
    }

    @Override
    public List<SkillDTO> search(String name) {
        List<SkillDTO> skillDTOList = new ArrayList<>();
        List<SkillEO> skillEOList = skillDAO.findByNameLike(name);
        for (SkillEO skillEO : skillEOList) {
            skillDTOList.add(CopyUtils.copy(skillEO, SkillDTO.class));
        }
        return skillDTOList;
    }

}
