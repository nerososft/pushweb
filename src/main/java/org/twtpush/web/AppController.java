package org.twtpush.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.twtpush.dto.DeveloperInfo;
import org.twtpush.dto.Result;
import org.twtpush.entity.App;
import org.twtpush.exception.*;
import org.twtpush.service.IAppService;
import org.twtpush.service.IDeveloperService;

import java.util.List;

import static org.twtpush.util.CONSTANT.*;

/**
 * Created by nero on 16-8-20.
 */
@Controller
@RequestMapping("/app")
public class AppController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private IAppService appService;

    @Autowired
    private IDeveloperService developerService;

    /**
     * add a new app
     * @param developerId
     * @param developerToken
     * @param appName
     * @return
     */
    @RequestMapping(value = "/{developerId}/{developerToken}/auth/{developerPass}/verify/{appName}/create",
    method = RequestMethod.POST,
    produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public Result<App> addApp(@PathVariable("developerId") long developerId,
                              @PathVariable("developerToken") String developerToken,
                              @PathVariable("developerPass") String developerPass,
                              @PathVariable("appName") String appName){
        Result<App> result;
        try {
            DeveloperInfo developer = developerService.checkDeveloper(developerId, developerToken);
            if (developer==null) {
                throw new TokenAuthFailedException(TOKEN_AUTH_FAILED.name());
            }
            if(appService.findByName(appName)!=null){
                throw new AppRepeatException("app have exists!");
            }
            if(developerService.verify(developer.getDeveloperEmail(),developerPass)==null){
                throw new NotUserException(PASSWORD_INCORRECT.name());
            }
            if(appService.addApp("/opt/apache-apollo-1.7.1/bin/twt/etc/groups.properties","/opt/apache-apollo-1.7.1/bin/twt/etc/users.properties",appName,developer.getDeveloperId()).isState()){
                result = new Result<App>(true,"create app success!");
            }else{
                result = new Result<App>(false,"create app failed!");
            }
        }catch (TokenAuthFailedException e1){
            logger.info(TOKEN_AUTH_FAILED.name(),e1);
            result = new Result<App>(false,e1.getMessage());
        }catch (AppRepeatException e2){
            logger.info(e2.getMessage(),e2);
            result = new Result<App>(false,e2.getMessage());
        }catch(NotUserException e3){
            logger.info(e3.getMessage(),e3);
            result = new Result<App>(false,e3.getMessage());
        }catch (Exception e){
            logger.info(e.getMessage(),e);
            result = new Result<App>(false,e.getMessage());
        }
        return result;
    }

    /**
     * return apps
     * @param developerId
     * @param developerToken
     * @param offset
     * @param limit
     * @return
     */
    @RequestMapping(value = "/{developerId}/{developerToken}/auth/{offset}/{limit}/apps",
                    method = RequestMethod.POST,
                    produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public Result<List<App>> apps(@PathVariable("developerId") long developerId,
                                  @PathVariable("developerToken") String developerToken,
                                  @PathVariable("offset") int offset,
                                  @PathVariable("limit") int limit){
        Result<List<App>> result;
        try {
            if (developerService.checkDeveloper(developerId, developerToken) == null) {
                throw new TokenAuthFailedException("token auth failed!");
            }
            List<App> apps = appService.findByDeveloperId(developerId,offset,limit);
            result=new Result<List<App>>(true,apps);
        }catch (TokenAuthFailedException e1){
            logger.info(e1.getMessage(),e1);
            result = new Result<List<App>>(false,e1.getMessage());
        }catch (Exception e){
            logger.info(e.getMessage(),e);
            result = new Result<List<App>>(false,e.getMessage());
        }
        return result;
    }


    /**
     * just return app jsp page
     * @return
     */
    @RequestMapping(value = "/{appId}",method = RequestMethod.GET)
    public String app(){
        return PAGE_APP.name();
    }

    /**
     * resuful api to get app info by app id ,need token auth
     * @param developerId
     * @param developerToken
     * @param appId
     * @return
     */
    @RequestMapping(value = "/{developerId}/{developerToken}/auth/{appId}/app",
            method = RequestMethod.POST,
            produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public Result<App> appInfo(@PathVariable("developerId") long developerId,
                               @PathVariable("developerToken") String developerToken,
                               @PathVariable("appId") long appId){

        Result<App> result;

        try {
            DeveloperInfo developerInfo = developerService.checkDeveloper(developerId, developerToken);
            if (developerInfo == null) {
                throw new TokenAuthFailedException("token auth failed!");
            }
            App app = appService.findById(appId);
            if (app == null) {
                throw new NotAppException("appkey or secret key incorecct!");
            }
            if (app.getAppDeveloperId() != developerInfo.getDeveloperId()) {
                throw new NotAppException("it not your app!");
            }
            result = new Result<App>(true,app);
        }catch (TokenAuthFailedException e1){
            logger.info(e1.getMessage(),e1);
            result = new Result<App>(false,e1.getMessage());
        }catch (NotAppException e2){
            logger.info(e2.getMessage(),e2);
            result = new Result<App>(false,e2.getMessage());
        }catch (Exception e){
            logger.error(e.getMessage(),e);
            result = new Result<App>(false,e.getMessage());
        }

        return result;
    }


    /**
     * change app name
     * @param developerId
     * @param developerToken
     * @param developerPass
     * @param appId
     * @param newAppName
     * @return
     */
    @RequestMapping(value = "{developerId}/{developerToken}/auth/{developerPass}/verify/{appId}/{newAppName}/changename",
    method = RequestMethod.POST,
    produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public Result<App> changename(@PathVariable("developerId") long developerId,
                                  @PathVariable("developerToken") String developerToken,
                                  @PathVariable("developerPass") String developerPass,
                                  @PathVariable("appId") long appId,
                                  @PathVariable("newAppName") String newAppName){
        Result<App> result;
        try {
            DeveloperInfo developer = developerService.checkDeveloper(developerId, developerToken);
            App app = appService.findById(appId);
            //token auth
            if (developer == null) {
                throw new TokenAuthFailedException(TOKEN_AUTH_FAILED.name());
            }
            //if app exists
            if (app == null) {
                throw new NotAppException(NOT_APP.name());
            }
            //if app owner
            if (app.getAppDeveloperId() != developer.getDeveloperId()) {
                throw new NotAppOwnerException(NOT_APP.name());
            }
            //verify user
            if (developerService.verify(developer.getDeveloperEmail(), developerPass)==null) {
                throw new NotUserException(PASSWORD_INCORRECT.name());
            }

            if (!appService.changeAppName(appId, newAppName).isState()) {
                result = new Result<App>(false, "change app name failed!");
            } else {
                result = new Result<App>(true, appService.findById(appId));
            }
        }catch(TokenAuthFailedException e1){
            throw e1;
        }catch (NotAppException e2){
            throw e2;
        }catch (NotAppOwnerException e3){
            throw e3;
        }catch (NotUserException e4){
            throw e4;
        }catch (Exception e){
            logger.info(APP_FAILED.name(),e);
            result = new Result<App>(false,e.getMessage());
        }

        return result;
    }

    /**
     * resetful api for reset app
     * @param developerId
     * @param developerToken
     * @param developerPass
     * @param appId
     * @return
     */
    @RequestMapping(value = "{developerId}/{developerToken}/auth/{developerPass}/verify/{appId}/reset",
            method = RequestMethod.POST,
            produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public Result<App> refreshKey(@PathVariable("developerId") long developerId,
                                  @PathVariable("developerToken") String developerToken,
                                  @PathVariable("developerPass") String developerPass,
                                  @PathVariable("appId") long appId){
        Result<App> result;
        try {
            DeveloperInfo developer = developerService.checkDeveloper(developerId, developerToken);
            App app = appService.findById(appId);
            //token auth
            if (developer == null) {
                throw new TokenAuthFailedException("Token auth failed!");
            }
            //if app exists
            if (app == null) {
                throw new NotAppException("Not have this app!");
            }
            //if app owner
            if (app.getAppDeveloperId() != developer.getDeveloperId()) {
                throw new NotAppOwnerException("it's not your app!");
            }
            //verify user
            if (developerService.verify(developer.getDeveloperEmail(), developerPass)==null) {
                throw new NotUserException("password incorrect!");
            }

            if (!appService.resetApp(appId,app.getAppName(),"/opt/apache-apollo-1.7.1/bin/twt/etc/groups.properties","/opt/apache-apollo-1.7.1/bin/twt/etc/users.properties").isState()) {
                result = new Result<App>(false, "reset app name failed!");
            } else {
                result = new Result<App>(true, appService.findById(appId));
            }
        }catch(TokenAuthFailedException e1){
            logger.info(TOKEN_AUTH_FAILED.name(),e1);
            result = new Result<App>(false, e1.getMessage());
        }catch (NotAppException e2){
            logger.info(NOT_APP.name(),e2);
            result = new Result<App>(false, e2.getMessage());
        }catch (NotAppOwnerException e3){
            logger.info(NOT_APP.name(),e3);
            result = new Result<App>(false, e3.getMessage());
        }catch (NotUserException e4){
            logger.info(PASSWORD_INCORRECT.name(),e4);
            result = new Result<App>(false, e4.getMessage());
        }catch (Exception e){
            logger.info(APP_FAILED.name(),e);
            result = new Result<App>(false,e.getMessage());
        }

        return result;
    }


    /**
     * delete app
     * @param developerId
     * @param developerToken
     * @param developerPass
     * @param appId
     * @return
     */
    @RequestMapping(value = "{developerId}/{developerToken}/auth/{developerPass}/verify/{appId}/delete",
            method = RequestMethod.POST,
            produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public Result<App> delete(@PathVariable("developerId") long developerId,
                                  @PathVariable("developerToken") String developerToken,
                                  @PathVariable("developerPass") String developerPass,
                                  @PathVariable("appId") long appId){
        Result<App> result;
        try {
            DeveloperInfo developer = developerService.checkDeveloper(developerId, developerToken);
            App app = appService.findById(appId);
            //token auth
            if (developer == null) {
                throw new TokenAuthFailedException("Token auth failed!");
            }
            //if app exists
            if (app == null) {
                throw new NotAppException("Not have this app!");
            }
            //if app owner
            if (app.getAppDeveloperId() != developer.getDeveloperId()) {
                throw new NotAppOwnerException("it's not your app!");
            }
            //verify user
            if (developerService.verify(developer.getDeveloperEmail(),developerPass)==null) {
                throw new NotUserException("password incorrect!");
            }

            if (!appService.deleteApp(appId).isState()) {
                result = new Result<App>(false, "delete app name failed!");
            } else {
                result = new Result<App>(true, appService.findById(appId));
            }
        }catch(TokenAuthFailedException e1){
            logger.info(e1.getMessage(),e1);
            result = new Result<App>(false, e1.getMessage());
        }catch (NotAppException e2){
            logger.info(e2.getMessage(),e2);
            result = new Result<App>(false, e2.getMessage());
        }catch (NotAppOwnerException e3){
            logger.info(e3.getMessage(),e3);
            result = new Result<App>(false, e3.getMessage());
        }catch (NotUserException e4){
            logger.info(e4.getMessage(),e4);
            result = new Result<App>(false, e4.getMessage());
        }catch (Exception e){
            logger.info(e.getMessage(),e);
            result = new Result<App>(false,e.getMessage());
        }

        return result;
    }



}
