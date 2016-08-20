package org.twtpush.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.twtpush.dto.Login;
import org.twtpush.dto.Result;
import org.twtpush.entity.Developer;
import org.twtpush.service.IDeveloperService;

import java.util.List;

/**
 * Created by nero on 16-8-19.
 */
@Controller
@RequestMapping("/developer")//url:/model/resource/{id}
public class DeveloperController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private IDeveloperService developerService;

    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public String list(Model model){
        //get all developer info
        List<Developer> developerList = developerService.getDeveloperList(0,10);

        model.addAttribute("developerList",developerList);
        return "developerList";//WEB-INF/jsp/developerList.jsp

    }

    @RequestMapping(value = "/{developerId}/detail",method = RequestMethod.GET)
    public String detail(@PathVariable("developerId") Long developerId,Model model){

        if(developerId == null){
            return "redirect:/developer/list";
        }
        Developer developer = developerService.getDeveloperById(developerId);

        if(developer==null){
            return "forward:/developer/list";
        }

        model.addAttribute("developer",developer);
        return "developer";
    }

    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public String showlogin(){
        return "login";
    }

    @RequestMapping(value = "/{developerEmail}/{developerPassword}/login",
            method = RequestMethod.POST,
            produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public Result<Login> login(@PathVariable("developerEmail") String developerEmail,
                               @PathVariable("developerPassword") String developerPassword){
        Result<Login> loginResult;
        try{
            Login login = developerService.login(developerEmail,developerPassword);
            loginResult = new Result<Login>(true,login);
        }catch (Exception e){
            logger.error(e.getMessage(),e);
            loginResult = new Result<Login>(false,e.getMessage());
        }
        return  loginResult;
    }



}
