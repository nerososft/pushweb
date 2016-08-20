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
    App queryByDeveloperId(long appDeveloperId);

    /**
     * find all
     * @param offset
     * @param limit
     * @return
     */
    List<App> findAll(long offset,long limit);

    /**
     * find by id
     * @param id
     * @return
     */
    App findById(long id);

    /**
     * delete app by id
     * @param id
     * @return
     */
    int deleteAppById(long id);
}
