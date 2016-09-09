package org.twtpush.service.impl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.DigestUtils;
import org.twtpush.dao.DeveloperDao;
import org.twtpush.dto.*;
import org.twtpush.entity.Developer;
import org.twtpush.exception.NotUserException;
import org.twtpush.exception.TokenAuthFailedException;
import org.twtpush.service.IDeveloperService;
import org.twtpush.util.Random.RandomString;

import java.util.List;

/**
 * Created by nero on 16-8-19.
 */
@Service
public class DeveloperServiceImpl implements IDeveloperService {

    private Logger logger  = LoggerFactory.getLogger(this.getClass());

    private long tokenLength=128;

    @SuppressWarnings("SpringJavaAutowiringInspection")
    @Autowired
    private DeveloperDao developerDao;


    public List<Developer> getDeveloperList(int offset,int limit) {
        return developerDao.queryAll(offset,limit);
    }

    public Developer getDeveloperById(long developerId) {
        return developerDao.queryById(developerId);
    }

    private String getRandomToken(long length){
        //md5 encode
        RandomString randomString;
        randomString = new RandomString();
        logger.info("token={}",randomString.getRandomString(tokenLength));
        return DigestUtils.md5DigestAsHex(randomString.getRandomString(tokenLength).getBytes());
    }
    /**
     * 使用注解控制事务
     */
    //@Transactional
    public Login login(String developerEmail, String developerPassword){

        try {
            Developer developer = developerDao.queryByEmailAndPassword(developerEmail, developerPassword);
            if (developer == null) {
                throw new NotUserException("username or password incorrect!");
            } else {
                String newToken = getRandomToken(tokenLength);
                int updateToken = developerDao.updateTokenByEmail(developer.getDeveloperEmail(), newToken);
                if (updateToken < 1) {
                    return new Login(false, "server error!", 10002);
                } else {
                    developer.setDeveloperToken(newToken);
                    return new Login(true, "login success!", 10003, new DeveloperInfo(developer.getDeveloperName(),developer.getDeveloperEmail(),developer.getDeveloperToken(),developer.getDeveloperId()));
                }
            }
        }catch(NotUserException e1){
            logger.info(e1.getMessage(),e1);
            return new Login(false,"username or password incorrect!",10001);
        } catch (Exception e) {//look as runtime exception
            logger.error(e.getMessage(),e);
            return new Login(false,"login failed!",10000);
        }
    }

    //auth developer id & token is correct?
    private AuthDeveloper authDeveloper(long developerId, String developerToken){
        Developer developer = developerDao.queryByIdAndToken(developerId,developerToken);
        if(developer==null){
            return new AuthDeveloper(false,null);
        }
        return new AuthDeveloper(true,developer);
    }

    @Transactional
    public Logout logout(long developerId, String developerToken){
        try {
            if(!authDeveloper(developerId,developerToken).isDeveloper()){
                throw  new TokenAuthFailedException("username or password incorrect");
            }
            int result = developerDao.updateTokenById(developerId,getRandomToken(tokenLength));
            if(result<1){
                return new Logout(false,"logout error!",0004);
            }else {
                return new Logout(true, "logout success!", 0005);
            }
        }catch (TokenAuthFailedException e1){
            logger.info(e1.getMessage(),e1);
            return new Logout(false, "token auth failed",01001);
        } catch (Exception e) {
            logger.error(e.getMessage(),e);
            return new Logout(false,"logout error!",0000);
        }
    }

    public Operate changePassword(long developerId, String developerToken, String oldPassword, String newPassword) {
        try {
            AuthDeveloper authDeveloper = authDeveloper(developerId, developerToken);
            if (!authDeveloper.isDeveloper()) {
                throw new TokenAuthFailedException("token auth failed!");
            }
            if(!oldPassword.equals(authDeveloper.getDeveloper().getDeveloperPassword())){
                throw new NotUserException("old password incorrect");
            }
            int result = developerDao.updatePassword(authDeveloper.getDeveloper().getDeveloperEmail(),newPassword);
            if(result<1){
                return new Operate(false,"change password failed!",01002);
            }
            return new Operate(true,"change password success!",01003);
        }catch (NotUserException e2){
            logger.info(e2.getMessage(),e2);
            return new Operate(false,"old password incorrect!",01005);
        }catch (TokenAuthFailedException e1){
            logger.info(e1.getMessage(),e1);
            return new Operate(false,"token auth failed",01001);
        }catch (Exception e){
            logger.error(e.getMessage(),e);
            return new Operate(false,"change password failed",01000);
        }
    }


    public Operate register(String developerEmail, String developerPassword, String developerName) {

        return null;
    }

    public DeveloperInfo checkDeveloper(long id, String developerToken){
        Developer developer = developerDao.queryByIdAndToken(id,developerToken);
        DeveloperInfo developerInfo;
        developerInfo = new DeveloperInfo(developer.getDeveloperName(),developer.getDeveloperEmail(),developer.getDeveloperToken(),developer.getDeveloperId());
        return developerInfo;
    }

    public Developer verify(String developerEmail, String developerPassword) {
        return developerDao.queryByEmailAndPassword(developerEmail,developerPassword);
    }

}
