package org.twtpush.service;

import org.twtpush.dto.Operate;

/**
 * Created by nero on 16-8-18.
 */
public interface IPushService {

    /**
     * push msg  to device
     * @param topic
     * @param content
     * @return
     */
    Operate push(String broker,String appname,String appkey,String secretkey,String topic, String content);


    /**
     * get broker status
     * @param brokerPath
     * @param broker
     * @return
     */
    Operate getBrokerStatus(String  brokerPath,String broker);
}
