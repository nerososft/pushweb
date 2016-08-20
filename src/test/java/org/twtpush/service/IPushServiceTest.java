package org.twtpush.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.twtpush.dto.Operate;

import javax.annotation.Resource;

import static org.junit.Assert.*;

/**
 * Created by nero on 16-8-20.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-dao.xml",
        "classpath:spring/spring-service.xml"})
public class IPushServiceTest {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private IPushService pushService;

    @Test
    public void push() throws Exception {
        String broker = "asd";
        String appname ="asd";
        String appkey="asd";
        String secretkey="asd";
        String topic="asd";
        String content="asd";
        Operate operate = pushService.push(broker,appname,appkey,secretkey,topic,content);
        logger.info("pushresult={}",operate.toString());
    }

}