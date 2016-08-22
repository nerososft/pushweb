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
    public void findByName() throws Exception {
        String name="new name";
        App app =  appDao.findByName(name);
        System.out.println(app.toString());
    }
    @Test
    public void queryByDeveloperId() throws Exception {
        long developerid = 3;
        List<App> app = appDao.queryByDeveloperId(3,0,10);
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
    @Test
    public void findByKeySecretKey() throws Exception {
        String key="weipeiyang_ios_014dd069e98bb226f32929b7d39a3035";
        String secret="75d32ba7a8d2ed7408bfc0796770c166)7fAru(qkm2Jab3bc4c77b267725a15bad618fe1fcb2";
        App app = appDao.findByKeySecretKey(key,secret);
        System.out.println(app.toString());
    }
}