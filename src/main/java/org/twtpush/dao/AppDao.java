package org.twtpush.dao;

import org.apache.ibatis.annotations.Param;
import org.twtpush.entity.App;

import java.util.List;

/**
 * Created by nero on 16-8-18.
 */
public interface AppDao {
    /**
     * add app
     * @param appName
     * @param appKey
     * @param appSecretKey
     * @return
     */
    int add(@Param("appName") String appName,@Param("appKey") String appKey,@Param("appSecretKey") String appSecretKey, @Param("appDeveloperId") long appDeveloperId);

    /**
     * query app info by appid
     * @param appId
     * @return
     */
    App queryById(long appId);

    /**
     * query apps by app developer id
     * @param appDeveloperId
     * @return
     */
    List<App> queryByDeveloperId(long appDeveloperId);

    /**
     * find all
     * @param offset
     * @param limit
     * @return
     */
    List<App> findAll(@Param("offset") long offset,@Param("limit") long limit);


    /**
     * delete app by id
     * @param appId
     * @return
     */
    int deleteAppById(long appId);

    /**
     * reset a app's app key & secret key
     * @param appId
     * @param appKey
     * @param secretKey
     * @return
     */
    int resetAppById(@Param("appId") long appId,@Param("appKey") String appKey,@Param("secretKey") String secretKey);

    /**
     * change app 's name
     * @param appId
     * @param newAppName
     * @return
     */
    int changeAppNameById(@Param("appId") long appId,@Param("newAppName") String newAppName);
}
