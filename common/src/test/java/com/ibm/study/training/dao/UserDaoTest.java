package com.ibm.study.training.dao;

import com.ibm.study.training.entity.RoleEO;
import com.ibm.study.training.entity.UserEO;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.Random;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = {CommonStarter.class})
@Transactional
@Slf4j
public class UserDaoTest {

    @Autowired
    private UserDAO userDao;

    @Test
    @Rollback
    public void testSave() {
        Random random = new Random();
        RoleEO role = new RoleEO();
        role.setId(3L);
        UserEO user = new UserEO();
        user.setName(random.nextInt(1000)+"");
        user.setUsername(random.nextInt(1000)+"");
        user.setPassword(random.nextInt(1000)+"");
        user.setEmail(random.nextInt(1000)+"");
        user.setRole(role);
        userDao.save(user);
    }

}
