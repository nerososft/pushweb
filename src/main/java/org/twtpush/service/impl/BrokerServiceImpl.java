package org.twtpush.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.HttpEntity;
import org.apache.http.ParseException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
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
import org.slf4j.*;

import static org.apache.http.ssl.SSLContexts.custom;

/**
 * Created by nero on 16-8-22.
 */
@Service
public class BrokerServiceImpl implements IBrokerService {
    private Logger logger = LoggerFactory.getLogger(this.getClass());


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
                logger.info(e.getMessage(),e);
            } finally {
                try {
                    instream.close();
                } catch (Exception ignore) {
                    logger.error(ignore.getMessage(),ignore);
                }
            }
            // 相信自己的CA和所有自签名的证书
            SSLContext sslcontext = custom().loadTrustMaterial(trustStore, new TrustSelfSignedStrategy()).build();
            // 只允许使用TLSv1协议
            SSLConnectionSocketFactory sslsf = new SSLConnectionSocketFactory(sslcontext, new String[] { "TLSv1" }, null,
                    SSLConnectionSocketFactory.ALLOW_ALL_HOSTNAME_VERIFIER);
            httpclient = HttpClients.custom().setSSLSocketFactory(sslsf).build();
            // 创建http请求(get方式)
            String ip ="https://127.0.0.1:61681/api/json/session/signin?username=";
            HttpGet httpget = new HttpGet(ip+appKey+"&password="+appSecretKey+"&target=%2Fapi%2Fjson%2Fbroker%3Fconnections%3Dtrue");
            logger.info("executing request" + httpget.getRequestLine());
            CloseableHttpResponse response = httpclient.execute(httpget);
            try {
                HttpEntity entity = response.getEntity();
                if (entity != null) {
                    ObjectMapper objectMapper=new ObjectMapper();
                    BrokerStatus brokerStatus=objectMapper.readValue(EntityUtils.toString(entity), BrokerStatus.class);
                    
                    result = new Result<BrokerStatus>(true,brokerStatus);
                    
                    EntityUtils.consume(entity);
                }
            } finally {
                response.close();
            }
        } catch (ParseException e) {
            logger.info(e.getMessage(),e);
        } catch (IOException e) {
            logger.info(e.getMessage(),e);
        } catch (KeyManagementException e) {
            logger.info(e.getMessage(),e);
        } catch (NoSuchAlgorithmException e) {
            logger.info(e.getMessage(),e);
        } catch (KeyStoreException e) {
            logger.info(e.getMessage(),e);
        } finally {
            if (httpclient != null) {
                try {
                    httpclient.close();
                } catch (IOException e) {
                    logger.info(e.getMessage(),e);
                }
            }
        }
        return result;
    }
}



