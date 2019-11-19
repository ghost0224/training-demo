package com.ibm.study.training.service.impl;

import com.ibm.study.training.dao.SkillDAO;
import com.ibm.study.training.dao.TrainingDAO;
import com.ibm.study.training.dao.UserDAO;
import com.ibm.study.training.entity.SkillEO;
import com.ibm.study.training.entity.TrainingEO;
import com.ibm.study.training.entity.UserEO;
import com.ibm.study.training.pojo.SkillDTO;
import com.ibm.study.training.pojo.TrainingDTO;
import com.ibm.study.training.service.TrainingService;
import com.ibm.study.training.util.CopyUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class TrainingServiceImpl implements TrainingService {

    @Autowired
    private TrainingDAO trainingDAO;

    @Autowired
    private UserDAO userDAO;

    @Autowired
    private SkillDAO skillDAO;

    @Override
    public boolean save(TrainingDTO trainingDTO) {
        TrainingEO trainingEO = CopyUtils.copy(trainingDTO, TrainingEO.class);
        trainingEO.setId(null);
        SkillEO skillEO = CopyUtils.copy(trainingDTO.getSkill(), SkillEO.class);
        trainingEO.setSkill(skillEO);
        trainingDAO.save(trainingEO);
        if(null != trainingEO.getId()) {
            return true;
        }
        return false;
    }

    @Override
    public boolean delete(Long id) {
        trainingDAO.deleteById(id);
        return true;
    }

    @Override
    public boolean update(TrainingDTO trainingDTO) {
        TrainingEO trainingEO = CopyUtils.copy(trainingDTO, TrainingEO.class);
        SkillEO skillEO = CopyUtils.copy(trainingDTO.getSkill(), SkillEO.class);
        trainingEO.setSkill(skillEO);
        trainingDAO.save(trainingEO);
        return true;
    }

    @Override
    public TrainingDTO findById(Long id) {
        TrainingEO trainingEO = trainingDAO.findById(id).get();
        TrainingDTO trainingDTO = CopyUtils.copy(trainingEO, TrainingDTO.class);
        SkillDTO skillDTO = CopyUtils.copy(trainingEO.getSkill(), SkillDTO.class);
        trainingDTO.setSkill(skillDTO);
        return trainingDTO;
    }

    @Override
    public List<TrainingDTO> findByUserId(Long userId) {
        UserEO user = userDAO.findById(userId).get();
        List<TrainingEO> trainingList = user.getTrainingList();
        List<TrainingDTO> result = new ArrayList<>();
        for (TrainingEO trainingEO : trainingList) {
            TrainingDTO dto = CopyUtils.copy(trainingEO, TrainingDTO.class);
            SkillEO skillEO = skillDAO.findById(dto.getId()).get();
            SkillDTO skillDTO = CopyUtils.copy(skillEO, SkillDTO.class);
            dto.setSkill(skillDTO);
            result.add(dto);
        }
        return result;
    }

    @Override
    public List<TrainingDTO> search(String title) {
        List<TrainingDTO> trainingDTOList = new ArrayList<>();
        List<TrainingEO> trainingEOList = trainingDAO.findByTitleLike("%"+title+"%");
        for (TrainingEO trainingEO : trainingEOList) {
            TrainingDTO trainingDTO = CopyUtils.copy(trainingEO, TrainingDTO.class);
            SkillDTO skillDTO = CopyUtils.copy(trainingEO.getSkill(), SkillDTO.class);
            trainingDTO.setSkill(skillDTO);
            trainingDTOList.add(trainingDTO);
        }
        return trainingDTOList;
    }
}
