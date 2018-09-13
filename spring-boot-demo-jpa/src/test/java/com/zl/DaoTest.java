package com.zl;

import com.zl.Application;
import com.zl.dao.UserDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @AUTH zhuolin
 * @DATE 2018/8/2
 * @description:
 **/
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class DaoTest {

    @Autowired
    private UserDao userDao;

    @Test
    public void select() {
        System.out.println(userDao.findAll());
    }


}
