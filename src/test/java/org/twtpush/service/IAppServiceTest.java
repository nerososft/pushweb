package org.twtpush.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.twtpush.dto.Operate;
import org.twtpush.entity.App;

import java.util.List;


/**
 * Created by nero on 16-8-20.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-dao.xml",
        "classpath:spring/spring-service.xml"})
public class IAppServiceTest {


    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private IAppService appService;

    @Test
    public void addApp() throws Exception {
        String grouppath="/opt/apache-apollo-1.7.1/bin/twt/etc/groups.properties";
        String userpath="/opt/apache-apollo-1.7.1/bin/twt/etc/users.properties";
        String appname="twtpush_by";
        long developerid=3;
        Operate operate = appService.addApp(grouppath,userpath,appname,developerid);
        logger.info("addapp={}",operate.toString());

    }

    @Test
    public void deleteApp() throws Exception {
        long  id =2;
        Operate operate=appService.deleteApp(id);
        logger.info("result={}",operate);
    }

    @Test
    public void resetApp() throws Exception {
        long  id =3;
        Operate operate=appService.resetApp(id,"new name");
        logger.info("result={}",operate);
    }

    @Test
    public void changeAppName() throws Exception {
        long  id =3;
        Operate operate=appService.changeAppName(id,"yang");
        logger.info("result={}",operate);
    }
    @Test
    public void all() throws Exception {
        List<App> app = appService.all(0,10);
        logger.info("result={}",app.toString());
    }

    @Test
    public void findByDeveloperId() throws Exception {
        long id =3;
        List<App> app = appService.findByDeveloperId(id);
        logger.info("result={}",app.toString());
    }

    @Test
    public void findById() throws Exception {
        long id =5;
        App app = appService.findById(id);
        logger.info("result={}",app.toString());
    }

    @Test
    public void findByName() throws Exception {
        String name="yang";
        App app = appService.findByName(name);
        logger.info("result={}",app.toString());
    }

    @Test
    public void checkApp() throws Exception {
        String key="weipeiyang_ios_014dd069e98bb226f32929b7d39a3035";
        String secret="75d32ba7a8d2ed7408bfc0796770c166)7fAru(qkm2Jab3bc4c77b267725a15bad618fe1fcb2";
        App app = appService.checkApp(key,secret);
        logger.info("result={}",app.toString());
    }

}