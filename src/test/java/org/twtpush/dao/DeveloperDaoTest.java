package org.twtpush.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.twtpush.entity.Developer;

import javax.annotation.Resource;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by nero on 16-8-18.
 * launcher with spring IOC container
 * spring-test,junit
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-dao.xml"})

public class DeveloperDaoTest {

    @Resource
    private DeveloperDao developerDao;

    @Test
    public void add() throws Exception {
        String name="testusername";
        String email="testemail@testemail.com";
        String password="testpassword";
        int result = developerDao.add(name,email,password);
        System.out.println(result);
    }

    @Test
    public void queryByEmail() throws Exception {
        String email="testemail@testemail.com";
        Developer developer = developerDao.queryByEmail(email);
        System.out.println(developer.toString());
    }

    @Test
    public void queryById() throws Exception {
        long id = 1;
        Developer developer = developerDao.queryById(id);
        System.out.println(developer.toString());
    }

    @Test
    public void queryByEmailAndPassword() throws Exception {
        String email="testemail@testemail.com";
        String password = "testpassword";
        Developer developer = developerDao.queryByEmailAndPassword(email,password);
        System.out.println(developer.toString());
    }
    @Test
    public void queryAll() throws Exception {
        int offset = 0;
        int limit =3;
        List<Developer> developers = developerDao.queryAll(offset,limit);
        for (Developer developer:developers) {
            System.out.println(developer.toString());
        }
    }

    @Test
    public void updateTokenByEmail() throws Exception {
        String newtoken = "testnewtoken";
        String email = "testemail@testemail.com";
        int i = developerDao.updateTokenByEmail(email,newtoken);
        System.out.println(i);
    }

    @Test
    public void updatePassword() throws Exception {
        String newpassword = "testnewpassword";
        String email = "testemail@testemail.com";
        int i = developerDao.updatePassword(email,newpassword);
        System.out.println(i);
    }

    @Test
    public void  updateTokenById() throws Exception {
        String newtoken = "testnewtokenbyid";
        long id = 1;
        int i = developerDao.updateTokenById(id,newtoken);
        System.out.println(i);
    }

    @Test
    public void queryByIdAndToken() throws Exception {
        long id=1;
        String token = "testnewtokenbyid";
        Developer developer = developerDao.queryByIdAndToken(id,token);
        System.out.println(developer.toString());
    }
}