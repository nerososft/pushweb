package org.twtpush.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.twtpush.dto.Operate;
import org.twtpush.dto.Result;
import org.twtpush.service.IPolicyService;

import javax.annotation.Resource;

/**
 * author： nero
 * email: nerosoft@outlook.com
 * data: 16-9-4
 * time: 下午7:54.
 */
@Controller
@RequestMapping("/policy")
public class PolicyController {

    private Logger logger  = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private IPolicyService policyService;

    @RequestMapping("/developerId/developerToken/auth/appId/policyName/create")
    public Operate createPolicy(@PathVariable("developerId")long developerId,
                                @PathVariable("developerToken") String developerToken,
                                @PathVariable("policyName") String policyName,
                                @PathVariable("appId") long appId){
        return null;
    }





}
