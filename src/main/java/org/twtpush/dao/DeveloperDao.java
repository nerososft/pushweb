package org.twtpush.dao;

import org.apache.ibatis.annotations.Param;
import org.twtpush.entity.Developer;

import java.util.List;

/**
 * Created by nero on 16-8-18.
 */
public interface DeveloperDao {
    /**
     * add developer
     * @param developerName
     * @param developerEmail
     * @param developerPassword
     * @return
     */
    int add(@Param("developerName") String developerName,@Param("developerEmail") String developerEmail,@Param("developerPassword") String developerPassword);

    /**
     * query developer info by email
     * @param developerEmail
     * @return
     */
    Developer queryByEmail(String developerEmail);

    /**
     * query developer info by id
     * @param developerId
     * @return
     */
    Developer queryById(long developerId);

    /**
     * query developer info by email & password (for login)
     * @param developerEmail
     * @param developerPassword
     * @return
     */
    Developer queryByEmailAndPassword(@Param("developerEmail") String developerEmail,@Param("developerPassword") String developerPassword);

    /**
     * query developer by id & token
     * @param developerId
     * @param developerToken
     * @return
     */
    Developer queryByIdAndToken(@Param("developerId") long developerId,@Param("developerToken") String developerToken);

    /**
     * query all developer from offset to offset+limit
     * @param offset
     * @param limit
     * @return
     */
    List<Developer> queryAll(@Param("offset") int offset,@Param("limit") int limit);

    /**
     * update developer's token (for login or logout )[restful]
     * @param developerEmail
     * @param newToken
     * @return
     */
    int updateTokenByEmail(@Param("developerEmail") String developerEmail,@Param("newToken") String newToken);


    /**
     * update developer token by developer id
     * @param developerId
     * @param newToken
     * @return
     */
    int updateTokenById(@Param("developerId") long developerId,@Param("newToken") String newToken);

    /**
     * uopdate developer's password
     * @param developerEmail
     * @param developerPassword
     * @return
     */
    int updatePassword(@Param("developerEmail") String developerEmail,@Param("developerPassword") String developerPassword);
}
