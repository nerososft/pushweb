package org.twtpush.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.twtpush.dto.Operate;


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

    }

    @Test
    public void resetApp() throws Exception {

    }

    @Test
    public void changeAppName() throws Exception {

    }

}