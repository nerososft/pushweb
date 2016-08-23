package org.twtpush.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.HttpEntity;
import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLContexts;
import org.apache.http.conn.ssl.TrustSelfSignedStrategy;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.stereotype.Service;
import org.twtpush.dto.BrokerStatus.BrokerStatus;
import org.twtpush.dto.Result;
import org.twtpush.service.IBrokerService;

import javax.net.ssl.SSLContext;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;

/**
 * Created by nero on 16-8-22.
 */
@Service
public class BrokerServiceImpl implements IBrokerService {
    public Result<BrokerStatus> getBrokerStatus(String appKey,String appSecretKey) {

        Result<BrokerStatus> result = null;

        CloseableHttpClient httpclient = null;
        try {
            KeyStore trustStore = KeyStore.getInstance(KeyStore.getDefaultType());
            FileInputStream instream = new FileInputStream(new File("/usr/lib/jvm/java-7-oracle/jre/lib/security/jssecacerts"));
            try {
                // 加载keyStore d:\\tomcat.keystore
                trustStore.load(instream, "changeit".toCharArray());
            } catch (CertificateException e) {
                e.printStackTrace();
            } finally {
                try {
                    instream.close();
                } catch (Exception ignore) {
                }
            }
            // 相信自己的CA和所有自签名的证书
            SSLContext sslcontext = SSLContexts.custom().loadTrustMaterial(trustStore, new TrustSelfSignedStrategy()).build();
            // 只允许使用TLSv1协议
            SSLConnectionSocketFactory sslsf = new SSLConnectionSocketFactory(sslcontext, new String[] { "TLSv1" }, null,
                    SSLConnectionSocketFactory.ALLOW_ALL_HOSTNAME_VERIFIER);
            httpclient = HttpClients.custom().setSSLSocketFactory(sslsf).build();
            // 创建http请求(get方式)
            HttpGet httpget = new HttpGet("https://127.0.0.1:61681/api/json/session/signin?username="+appKey+"&password="+appSecretKey+"&target=%2Fapi%2Fjson%2Fbroker%3Fconnections%3Dtrue");
            System.out.println("executing request" + httpget.getRequestLine());
            CloseableHttpResponse response = httpclient.execute(httpget);
            try {
                HttpEntity entity = response.getEntity();
                //System.out.println("----------------------------------------");
                //System.out.println(response.getStatusLine());
                if (entity != null) {
                    //System.out.println("Response content length: " + entity.getContentLength());

                    //esult = new Result<BrokerStatus>(true,entity);
                    //System.out.println(EntityUtils.);
                    //System.out.println("Entity:"+EntityUtils.toString(entity));

                    ObjectMapper objectMapper=new ObjectMapper();
                    BrokerStatus brokerStatus=objectMapper.readValue(EntityUtils.toString(entity), BrokerStatus.class);
                    
                    result = new Result<BrokerStatus>(true,brokerStatus);
                    
                    EntityUtils.consume(entity);
                }
            } finally {
                response.close();
            }
        } catch (ParseException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (KeyManagementException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (KeyStoreException e) {
            e.printStackTrace();
        } finally {
            if (httpclient != null) {
                try {
                    httpclient.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return result;
    }

}
