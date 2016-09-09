package org.twtpush.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.twtpush.dto.Operate;
import org.twtpush.exception.NotAppException;
import org.twtpush.exception.TokenAuthFailedException;
import org.twtpush.service.IAppService;
import org.twtpush.service.IDeveloperService;
import org.twtpush.service.IPushService;

import static org.twtpush.util.CONSTANT.PUSH_FAILED;

/**
 * Created by nero on 16-8-20.
 */
@Controller
@RequestMapping("/push")
public class PushController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());


    private IPushService pushService;

    @Autowired
    private IDeveloperService developerService;

    @Autowired
    private IAppService appService;


    @RequestMapping(value = "{developerId}/{developerToken}/auth/{broker}/{appname}/{appkey}/{secretkey}/{topic}/{content}/push",
            method = RequestMethod.POST,
            produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public Operate push(@PathVariable("developerId") long developerId,
                        @PathVariable("developerToken") String developerToken,
                        @PathVariable("broker") String broker,
                        @PathVariable("appname") String appname,
                        @PathVariable("appkey") String appkey,
                        @PathVariable("secretkey") String secretkey,
                        @PathVariable("topic") String topic,
                        @PathVariable("content") String content){
        Operate operate;

        try {
            if(developerService.checkDeveloper(developerId,developerToken)==null){
                throw new TokenAuthFailedException("token auth failed!");
            }
            if(appService.checkApp(appkey,secretkey)==null){
                throw new NotAppException("appkey or secret key incorecct!");
            }
            operate = pushService.push(broker, appname, appkey, secretkey, topic, content);
        }catch (TokenAuthFailedException e1){
            throw e1;
        }catch (NotAppException e2){
            throw e2;
        }catch (Exception e){
            logger.info(PUSH_FAILED.name(),e);
            operate = new Operate(false,e.getMessage(),03001);
        }
        return operate;
    }
}
