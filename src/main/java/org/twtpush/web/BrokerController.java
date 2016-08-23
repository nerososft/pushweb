package org.twtpush.web;


import com.sun.corba.se.pept.broker.Broker;
import com.sun.xml.internal.bind.v2.schemagen.xmlschema.Appinfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.twtpush.dto.BrokerStatus.BrokerStatus;
import org.twtpush.dto.DeveloperInfo;
import org.twtpush.dto.Result;
import org.twtpush.entity.App;
import org.twtpush.exception.NotAppException;
import org.twtpush.exception.TokenAuthFailedException;
import org.twtpush.service.IAppService;
import org.twtpush.service.IBrokerService;
import org.twtpush.service.IDeveloperService;

/**
 * Created by nero on 16-8-23.
 */
@Controller
@RequestMapping("/broker")
public class BrokerController {

    @Autowired
    private IDeveloperService developerService;

    @Autowired
    private  IAppService appService;

    @Autowired
    private IBrokerService brokerService;

    private Logger logger = LoggerFactory.getLogger(this.getClass());


    /**
     * restful api of get broker info
     * @param developerId
     * @param developerToken
     * @param appKey
     * @param appSecretKey
     * @return
     */
    @RequestMapping(value = "{developerId}/{developerToken}/auth/{appKey}/{appSecretKey}/broker",
    method = RequestMethod.POST,
    produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public Result<BrokerStatus> brokerStatus(@PathVariable("developerId") Long developerId,
                                             @PathVariable("developerToken") String developerToken,
                                             @PathVariable("appKey") String appKey,
                                             @PathVariable("appSecretKey") String appSecretKey){
        Result<BrokerStatus> result;
        try{
        DeveloperInfo developerInfo = developerService.checkDeveloper(developerId, java.lang.String.valueOf(developerToken));
        if(developerInfo==null){
            throw new TokenAuthFailedException("token auth failed!");
        }
        App app = appService.checkApp(appKey,appSecretKey);
        if(app==null){
            throw new NotAppException("appkey or secret key incorecct!");
        }
        if(app.getAppDeveloperId()!=developerInfo.getDeveloperId()){
            throw new NotAppException("it not your app!");
        }
            result = brokerService.getBrokerStatus(appKey,appSecretKey);
        }catch (TokenAuthFailedException e1){
            throw e1;
        }catch (NotAppException e2){
            throw e2;
        }catch (Exception e){
            logger.error(e.getMessage(),e);
            result = new Result<BrokerStatus>(false,e.getMessage());
        }

        return result;
    }
}
