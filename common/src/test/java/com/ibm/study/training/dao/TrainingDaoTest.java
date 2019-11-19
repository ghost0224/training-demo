package com.ibm.study.training.dao;

import com.ibm.study.training.entity.TrainingEO;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = {CommonStarter.class})
@Transactional
@Slf4j
public class TrainingDaoTest {

    @Autowired
    private TrainingDAO trainingDAO;

    @Test
    @Rollback
    public void testFindByTitleName() {
        String title = "%Java%";
        List<TrainingEO> result = trainingDAO.findByTitleLike(title);
        System.out.println(result);
        Assert.assertTrue(result.size() > 0);
    }

}
