package org.twtpush.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.twtpush.dto.Result;
import org.twtpush.entity.App;
import org.twtpush.entity.Developer;
import org.twtpush.exception.TokenAuthFailedException;
import org.twtpush.service.IAppService;
import org.twtpush.service.IDeveloperService;

/**
 * Created by nero on 16-8-20.
 */
@Controller
@RequestMapping("/app")
public class AppController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private IAppService appService;
    private IDeveloperService developerService;

    @RequestMapping(value = "/{developerId}/{developerToken}/auth/{appName}/create",
    method = RequestMethod.GET,
    produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public Result<App> addApp(@PathVariable("developerId") long developerId,
                              @PathVariable("developerToken") String developerToken,
                              @PathVariable("appName") String appName){
        Result<App> result;
        try {
            Developer developer = developerService.checkDeveloper(developerId, developerToken);
            if (developer==null) {
                throw new TokenAuthFailedException("token auth failed!");
            }else{
                if(appService.addApp(appName,developer.getDeveloperId()).isState()){
                    result = new Result<App>(true,"create app success!");
                }else{
                    result = new Result<App>(false,"create app failed!");
                }
            }

        }catch (TokenAuthFailedException e1){
            logger.error(e1.getMessage(),e1);
            result = new Result<App>(false,"token auth failed!");
        }
        return result;
    }


}
