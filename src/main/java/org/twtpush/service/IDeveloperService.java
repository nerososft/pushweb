package org.twtpush.service;

import org.twtpush.dto.DeveloperInfo;
import org.twtpush.dto.Login;
import org.twtpush.dto.Logout;
import org.twtpush.dto.Operate;
import org.twtpush.entity.Developer;
import org.twtpush.exception.HaveLoggedOutException;
import org.twtpush.exception.NotUserException;

import java.util.List;

/**
 * work interface
 * Created by nero on 16-8-18.
 */
public interface IDeveloperService {
    /**
     * get all developer's info  from offset to offset+limit
     * @param offset
     * @pa  ram limit
     * @return
     */
    List<Developer> getDeveloperList(int offset,int limit);

    /**
     * get developer info by developer id
     * @param developerId
     * @return
     */
    Developer getDeveloperById(long developerId);

    /**
     * user login
     * @param developerEmail
     * @param developerPassword
     * @return
     */
    Login login(String developerEmail, String developerPassword);

    /**
     * user logout
     * @param developerId
     * @param developerToken
     * @return
     * @throws NotUserException
     * @throws HaveLoggedOutException
     */
    Logout logout(long developerId, String developerToken);
    /**
     * change developer's password
     * @param developerId
     * @param developerToken
     * @param oldPassword
     * @param newPassword
     * @return
     */
    Operate changePassword(long developerId, String developerToken, String oldPassword, String newPassword);

    /**
     * register a new developer
     * @param developerEmail
     * @param developerPassword
     * @param developerName
     * @return
     */
    Operate register(String developerEmail,String developerPassword,String developerName);

    /**
     * check is developer
     * @param id
     * @param developerToken
     * @return
     */
    DeveloperInfo checkDeveloper(long id, String developerToken);

    /**
     * verify user
     * @param developerEmail
     * @param developerPassword
     * @return
     */
    Developer verify(String developerEmail, String developerPassword);
}
