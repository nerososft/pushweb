package org.twtpush.util.Mqtt;

import org.eclipse.paho.client.mqttv3.*;
import org.eclipse.paho.client.mqttv3.logging.LoggerFactory;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;
import org.slf4j.*;

/**
 * Created by nero on 16-7-4.
 */
public class TwtMqtt {
    private String broker;
    private String userName;
    private String password;
    private String topic;
    private String msg;
    private Integer qos;
    private String clientId;
    private String content;
    private boolean isConnected = false;


    private MemoryPersistence persistence;//
    private MqttClient mqttClient;
    private MqttConnectOptions mqttConnectOptions;
    private MqttMessage message;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getBroker() {
        return broker;
    }

    public void setBroker(String broker) {
        this.broker = broker;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Integer getQos() {
        return qos;
    }

    public void setQos(Integer qos) {
        this.qos = qos;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isConnected() {
        return isConnected;
    }

    public void setConnected(boolean connected) {
        isConnected = connected;
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public void init() {
        persistence = new MemoryPersistence();
        mqttConnectOptions = new MqttConnectOptions();
        mqttConnectOptions.setCleanSession(false);
        mqttConnectOptions.setKeepAliveInterval(18330);
        mqttConnectOptions.setUserName(userName);
        mqttConnectOptions.setPassword(password.toCharArray());
        mqttConnectOptions.setCleanSession(true);
        try {
            mqttClient = new MqttClient(broker, clientId, persistence);
            mqttClient.setCallback(new MqttCallback() {

                public void connectionLost(Throwable throwable) {
                    System.out.println("lost connecion");
                }


                public void messageArrived(String s, MqttMessage mqttMessage) throws Exception {
                    System.out.println("message arrived:"+mqttMessage.toString());
                }


                public void deliveryComplete(IMqttDeliveryToken iMqttDeliveryToken) {
                    System.out.println(iMqttDeliveryToken.toString());
                }
            });
            if(!mqttClient.isConnected()){
                mqttClient.connect(mqttConnectOptions);
                System.out.println("connect to broker"+broker);
            }
            isConnected = true;
        } catch (MqttException me) {
            System.out.println("reason " + me.getReasonCode());
            System.out.println("msg " + me.getMessage());
            System.out.println("loc " + me.getLocalizedMessage());
            System.out.println("cause " + me.getCause());
            System.out.println("excep " + me);
            me.printStackTrace();
        }
    }


    void listen(){

        try {
            mqttClient.subscribe(topic);
        } catch (MqttException me) {
            System.out.println("reason " + me.getReasonCode());
            System.out.println("msg " + me.getMessage());
            System.out.println("loc " + me.getLocalizedMessage());
            System.out.println("cause " + me.getCause());
            System.out.println("excep " + me);
            me.printStackTrace();
        }
    }
    public void send(){
        message = new MqttMessage(content.getBytes());
        message.setQos(qos);
        try {
            mqttClient.publish(topic, message);
        } catch (MqttException me) {
            System.out.println("reason " + me.getReasonCode());
            System.out.println("msg " + me.getMessage());
            System.out.println("loc " + me.getLocalizedMessage());
            System.out.println("cause " + me.getCause());
            System.out.println("excep " + me);
            me.printStackTrace();
        }
    }
}