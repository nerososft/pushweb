package org.twtpush.service.impl;

import org.apache.http.HttpEntity;
import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.twtpush.dto.Operate;
import org.twtpush.service.IPushService;
import org.twtpush.util.Mqtt.TwtMqtt;

import java.io.IOException;

/**
 * Created by nero on 16-8-20.
 */
@Service
public class PushServiceImpl implements IPushService{

    private Logger logger = LoggerFactory.getLogger(this.getClass());


    public Operate push(String broker,String appName,String appKey,String secretKey,String topic, String content) {
        TwtMqtt twtMqtt;
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
            return new Operate(false,e.getMessage(),10001);
        }

    }

    public Operate getBrokerStatus(String brokerPath, String broker) {
        CloseableHttpClient httpclient = HttpClients.createDefault();
        try {
            // 创建httpget.
            HttpGet httpget = new HttpGet("https://127.0.0.1:61681/api/json/broker?connections=true");

            // 执行get请求.
            CloseableHttpResponse response = httpclient.execute(httpget);
            try {
                // 获取响应实体
                HttpEntity entity = response.getEntity();

            } finally {
                response.close();
            }
        } catch (ClientProtocolException e) {
            logger.info(e.getMessage(),e);
        } catch (ParseException e) {
            logger.info(e.getMessage(),e);
        } catch (IOException e) {
            logger.info(e.getMessage(),e);
        } finally {
            // 关闭连接,释放资源
            try {
                httpclient.close();
            } catch (IOException e) {
                logger.info(e.getMessage(),e);
            }
        }

        return null;
    }

}
