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
        String appname="weipeiyang_android";
        long developerid=3;
        Operate operate = appService.addApp(appname,developerid);
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

}