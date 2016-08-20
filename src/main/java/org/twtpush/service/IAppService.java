package org.twtpush.service;

import org.twtpush.dto.Operate;
import org.twtpush.entity.App;

import java.util.List;

/**
 * Created by nero on 16-8-19.
 */
public interface IAppService {

    /**
     * all apps info from offset to offset+limit
     * @param offset
     * @param limit
     * @return
     */
    List<App> all(long offset, long  limit);

    /**
     * find app info by developerId
     * @param developerId
     * @return
     */
    List<App> findByDeveloperId(long developerId);

    /**
     * find app by appid
     * @param appId
     * @return
     */
    App findById(long  appId);

    /**
     * find App by appname
     * @param appName
     * @return
     */
    App findByName(String appName);
    /**
     * add a new app
     * @param appName
     * @return
     */
    Operate addApp(String appName,long developerId);

    /**
     * delete app
     * @param appId
     * @return
     */
    Operate deleteApp(long appId);

    /**
     * reset app's key & secret key
     * @param appId
     * @return
     */
    Operate resetApp(long appId,String appKey);

    /**
     * change app's name
     * @param appId
     * @param newAppName
     * @return
     */
    Operate changeAppName(long appId,String newAppName);

    /**
     * check  is appkey & secretkey  is a app
     * @param appKey
     * @param secretKey
     * @return
     */
    App  checkApp(String appKey,String secretKey);

}
