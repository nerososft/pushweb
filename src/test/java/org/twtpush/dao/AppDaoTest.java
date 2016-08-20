package org.twtpush.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.twtpush.entity.App;

import javax.annotation.Resource;

import static org.junit.Assert.*;

/**
 * Created by nero on 16-8-18.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/spring-dao.xml")

public class AppDaoTest {
    @Resource
    private AppDao appDao;

    @Test
    public void add() throws Exception {
        String appName="testapp";
        String appKey="testkey";
        String appSecretKey="testsecretkey";
        long appDeveloperId=1;
        int result = appDao.add(appName,appKey,appSecretKey,appDeveloperId);
        System.out.println(result);
    }

    @Test
    public void queryById() throws Exception {
        long id = 1;
        App app = appDao.queryById(id);
        System.out.println(app.toString());
    }

    @Test
    public void queryByDeveloperId() throws Exception {
        long developerid = 1;
        App app = appDao.queryById(developerid);
        System.out.println(app.toString());
    }

}