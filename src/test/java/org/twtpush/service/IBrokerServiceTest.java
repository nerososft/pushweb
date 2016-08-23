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
        String u = "testapp_2aba252f013582e96d2ba67d6e8e3947";
        String p = "40bb993e9cb026331da36784a267a3c5MH739zdM)2mla058adeb2fddd7be3ff5149384f15350";
        Result<BrokerStatus> brokerStatus = brokerService.getBrokerStatus(u,p);
        System.out.println(brokerStatus.toString());
    }

}