package org.twtpush.service.impl;

import org.apache.http.HttpEntity;
import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
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

    public Operate getBrokerStatus(String brokerPath, String broker) {
        CloseableHttpClient httpclient = HttpClients.createDefault();
        try {
            // 创建httpget.
            HttpGet httpget = new HttpGet("https://127.0.0.1:61681/api/json/broker?connections=true");
            System.out.println("executing request " + httpget.getURI());
            // 执行get请求.
            CloseableHttpResponse response = httpclient.execute(httpget);
            try {
                // 获取响应实体
                HttpEntity entity = response.getEntity();
                System.out.println("--------------------------------------");
                // 打印响应状态
                System.out.println(response.getStatusLine());
                if (entity != null) {
                    // 打印响应内容长度
                    System.out.println("Response content length: " + entity.getContentLength());
                    // 打印响应内容
                    System.out.println("Response content: " + EntityUtils.toString(entity));
                }
                System.out.println("------------------------------------");
            } finally {
                response.close();
            }
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 关闭连接,释放资源
            try {
                httpclient.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return null;
    }

}
