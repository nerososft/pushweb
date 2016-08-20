package org.twtpush.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.twtpush.dto.Operate;
import org.twtpush.service.IPushService;
import org.twtpush.util.Mqtt.TwtMqtt;

/**
 * Created by nero on 16-8-20.
 */
@Service
public class PushServiceImpl implements IPushService{

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    private TwtMqtt twtMqtt;

    public Operate push(String broker,String appName,String appKey,String secretKey,String topic, String content) {
        try {
            twtMqtt = new TwtMqtt();
            twtMqtt.setBroker("tcp://"+broker);
            twtMqtt.setTopic(appName+"/"+topic);
            twtMqtt.setUserName(appKey);
            twtMqtt.setPassword(secretKey);
            twtMqtt.setQos(1);
            twtMqtt.setClientId(appName);
            twtMqtt.setContent(content);


            twtMqtt.init();
            twtMqtt.send();
            return new Operate(true,"push success!",10002);
        }catch (Exception e){
            logger.error(e.getMessage(),e);
            return new Operate(false,e.getMessage().toString(),10001);
        }

    }

}
