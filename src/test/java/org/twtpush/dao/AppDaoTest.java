package org.twtpush.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.twtpush.entity.App;

import javax.annotation.Resource;

import java.util.List;

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
        long developerid = 3;
        List<App> app = appDao.queryByDeveloperId(3);
        System.out.println(app.toString());
    }
    @Test
    public void findAll() throws Exception {
        long offset=0;
        long limit=3;
        List<App> apps= appDao.findAll(offset,limit);
        System.out.println(apps.toString());
    }

    @Test
    public void deleteAppById() throws Exception {
        long id=1;
        int result = appDao.deleteAppById(id);
        System.out.println(result);
    }

    @Test
    public void resetAppById() throws Exception {
        long id =3;
        String appkey="resetappkey";
        String appsecret = "resetsecretkey";
        int result = appDao.resetAppById(id,appkey,appsecret);
        System.out.println(result);
    }

    @Test
    public void changeAppNameById() throws Exception {
        long id =3;
        String newname= "new name";
        int result=appDao.changeAppNameById(id,newname);
        System.out.println(result);
    }
}