package com.ibm.study.training.dao;

import com.ibm.study.training.entity.RoleEO;
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
public class RoleDaoTest {

    @Autowired
    private RoleDAO roleDao;

    @Test
    @Rollback
    public void testFindByName() {
        RoleEO roleEO = new RoleEO();
        roleEO.setName("Test");
        roleDao.save(roleEO);
        List<RoleEO> roleList = roleDao.findAll();
        Assert.assertTrue(roleList.size() > 0);
    }


}
