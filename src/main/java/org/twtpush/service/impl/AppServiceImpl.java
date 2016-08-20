package org.twtpush.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;
import org.twtpush.dao.AppDao;
import org.twtpush.dto.Operate;
import org.twtpush.entity.App;
import org.twtpush.exception.CreateAppException;
import org.twtpush.service.IAppService;
import org.twtpush.util.Random.RandomString;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

/**
 * Created by nero on 16-8-19.
 */
@Service
public class AppServiceImpl implements IAppService
{
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @SuppressWarnings("SpringJavaAutowiringInspection")
    @Autowired
    private AppDao appDao;

    private long tokenLength=128;

    private RandomString randomString;

    private String getRandomToken(){
        //md5 encode
        randomString = new RandomString();
        logger.info("token={}",randomString.getRandomString(tokenLength).toString());
        return DigestUtils.md5DigestAsHex(randomString.getRandomString(tokenLength).getBytes());
    }


    public List<App> all(long offset, long limit) {
        return appDao.findAll(offset,limit);
    }

    public List<App> findByDeveloperId(long developerId) {
        return appDao.queryByDeveloperId(developerId);
    }

    public App findById(long appId) {
        return appDao.queryById(appId);
    }

    public App findByName(String appName) {
        return appDao.findByName(appName);
    }

    public Operate addApp(String groupPath,String userPath,String appName, long developerId){
            String appKey=appName+"_"+getRandomToken();
            String secretKey = getRandomToken()+randomString.getRandomString(12)+getRandomToken();
            try {

                if(appDao.add(appName,appKey,secretKey,developerId)<1){
                    return  new Operate(false,"create app failed!",03003);
                }else{
                    FileWriter fileWriter = new FileWriter(groupPath,true);
                    BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
                    //使用缓冲区中的方法将数据写入到缓冲区中。
                    bufferedWriter.newLine();
                    bufferedWriter.write(appKey+"="+secretKey);
                    //使用缓冲区中的方法，将数据刷新到目的地文件中去。
                    bufferedWriter.flush();
                    //关闭缓冲区,同时关闭了fw流对象
                    bufferedWriter.close();

                    FileWriter fileWriter1 = new FileWriter(userPath,true);
                    BufferedWriter bufferedWriter1 = new BufferedWriter(fileWriter1);
                    //使用缓冲区中的方法将数据写入到缓冲区中。
                    bufferedWriter1.newLine();
                    bufferedWriter1.write(appKey+"="+secretKey);
                    //使用缓冲区中的方法，将数据刷新到目的地文件中去。
                    bufferedWriter1.flush();
                    //关闭缓冲区,同时关闭了fw流对象
                    bufferedWriter1.close();
                    return new Operate(true,"create app success!",03002);
                }
            } catch (IOException e) {
                //e.printStackTrace();
                return  new Operate(false,"can not write apollo!",03003);
            }
    }

    public Operate deleteApp(long appId) {
        if(appDao.deleteAppById(appId)<1){
            return new Operate(false,"delete failed!",00101);
        }
        return new Operate(true,"delete success!",00102);
    }

    public Operate resetApp(long appId,String appName) {
        if(appDao.resetAppById(appId,appName+"_"+getRandomToken(),getRandomToken()+randomString.getRandomString(12)+getRandomToken())<1){
            return new Operate(false,"reset app failed!",02001);
        }
        return new Operate(true,"reset app success",02002);
    }

    public Operate changeAppName(long id,String newAppName) {
        if(appDao.changeAppNameById(id,newAppName)<1){
            return new Operate(false,"change name failed!",04001);
        }
        return new Operate(true,"change name success!",04002);
    }

    public App checkApp(String appKey, String secretKey) {
       return appDao.findByKeySecretKey(appKey,secretKey);
    }
}
