package org.twtpush.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.twtpush.entity.Device;

import javax.annotation.Resource;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by nero on 16-8-18.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/spring-dao.xml")
public class DeviceDaoTest {
    @Resource
    private DeviceDao deviceDao;
    @Test
    public void queryAll() throws Exception {
        int offset = 0;
        int limit =1;
        List<Device> devices  = deviceDao.queryAll(offset,limit);
        for (Device device:devices) {
            System.out.println(device.toString());
        }
    }

    @Test
    public void deleteById() throws Exception {
        long id =1;
        int result = deviceDao.deleteById(id);
        System.out.println(result);
    }

}