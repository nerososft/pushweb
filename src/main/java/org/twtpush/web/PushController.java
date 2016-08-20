package org.twtpush.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.twtpush.dto.Operate;
import org.twtpush.service.IPushService;

import javax.annotation.Resource;

/**
 * Created by nero on 16-8-20.
 */
@Controller
@RequestMapping("/push")
public class PushController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private IPushService pushService;

    @RequestMapping(value = "/{broker}/{appname}/{appkey}/{secretkey}/{topic}/{content}/push",
            method = RequestMethod.GET,
            produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public Operate push(@PathVariable("broker") String broker,
                        @PathVariable("appname") String appname,
                        @PathVariable("appkey") String appkey,
                        @PathVariable("secretkey") String secretkey,
                        @PathVariable("topic") String topic,
                        @PathVariable("content") String content){
        Operate operate;

            operate = pushService.push(broker, appname, appkey, secretkey, topic, content);

        return operate;
    }

    @RequestMapping(value = "/{a}/push",
            method = RequestMethod.GET,
            produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public Operate pu(@PathVariable("a") String a){
        Operate operate = new Operate(true,a,0001);
        return operate;
    }
}
