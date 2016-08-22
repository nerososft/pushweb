package org.twtpush.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.twtpush.dto.DeveloperInfo;
import org.twtpush.dto.Login;
import org.twtpush.dto.Logout;
import org.twtpush.dto.Operate;
import org.twtpush.entity.Developer;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by nero on 16-8-19.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-dao.xml",
        "classpath:spring/spring-service.xml"})
public class IDeveloperServiceTest {


    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private IDeveloperService developerService;

    @Test
    public void getDeveloperList() throws Exception {
        int offset = 0;
        int limit =10;
        List<Developer> developers = developerService.getDeveloperList(offset,limit);

        logger.info("developers={}",developers.toString());
    }

    @Test
    public void getDeveloperById() throws Exception {
        int id =1;
        Developer developer = developerService.getDeveloperById(id);
       logger.info("developer={}",developer.toString());
    }

    @Test
    public void login() throws Exception {
        String email="testemail@testemail.com";
        String password = "testnewpassword";
        Login loginResult = developerService.login(email,password);
        logger.info("loginResult={}",loginResult.toString());
    }

    @Test
    public void logout() throws Exception {
        long id =3;
        String token = "87f0e45ef4b61da425b5a3f25b00baa3";
        Logout logoutResult = developerService.logout(id,token);
        logger.info("logoutResult={}",logoutResult.toString());
    }

    @Test
    public void changePassword() throws Exception {
        long id =3;
        String token="dae71bb9116f0993a5d9b92ad77fd02e";
        String oldPassword="newpassword";
        String newPassword ="newpasswordchanged";
        Operate changePasswordOperate = developerService.changePassword(id,token,oldPassword,newPassword);
        logger.info("changePwdResult={}",changePasswordOperate.toString());
    }

    @Test
    public void register() throws Exception {

    }
    @Test
    public void checkDeveloper() throws Exception {
        DeveloperInfo result  = developerService.checkDeveloper(3,"dae71bb9116f0993a5d9b92ad77fd02e");
        logger.info("result={}",result);
    }

}