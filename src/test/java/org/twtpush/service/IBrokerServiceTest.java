package org.twtpush.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.twtpush.dto.BrokerStatus.BrokerStatus;
import org.twtpush.dto.Result;

import static org.junit.Assert.*;

/**
 * Created by nero on 16-8-22.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-dao.xml",
        "classpath:spring/spring-service.xml"})
public class IBrokerServiceTest {

    @Autowired
    private IBrokerService brokerService;

    @Test
    public void getBrokerStatus() throws Exception {
        Result<BrokerStatus> brokerStatus = brokerService.getBrokerStatus("admin","password");
        System.out.println(brokerStatus.toString());
    }

}