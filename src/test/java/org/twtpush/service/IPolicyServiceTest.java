package org.twtpush.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

/**
 * author： nero
 * email: nerosoft@outlook.com
 * data: 16-9-5
 * time: 下午4:34.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-dao.xml",
        "classpath:spring/spring-service.xml"})
public class IPolicyServiceTest {

    @Autowired
    private IPolicyService policyService;

    @Test
    public void createPolicy() throws Exception {

    }

    @Test
    public void deletePolicy() throws Exception {

    }

    @Test
    public void modifyPolicy() throws Exception {

    }

    @Test
    public void getPolicyList() throws Exception {
        System.out.println(policyService.getPolicyList(37,0,27));
    }

}