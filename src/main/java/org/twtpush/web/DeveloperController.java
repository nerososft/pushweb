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
import org.twtpush.dto.DeveloperInfo;
import org.twtpush.dto.Login;
import org.twtpush.dto.Result;
import org.twtpush.entity.Developer;
import org.twtpush.exception.TokenAuthFailedException;
import org.twtpush.service.IDeveloperService;

import java.util.List;

import static org.twtpush.util.CONSTANT.DEVELOPER_FAILED;
import static org.twtpush.util.CONSTANT.PAGE_LOGIN;

/**
 * Created by nero on 16-8-19.
 */
@Controller

@RequestMapping("/developer")
public class DeveloperController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private IDeveloperService developerService;

    /**
     * list
     * @param model
     * @return
     */
    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public String list(Model model){
        //get all developer info
        List<Developer> developerList = developerService.getDeveloperList(0,10);

        model.addAttribute("developerList",developerList);
        return "developerList";//WEB-INF/jsp/developerList.jsp

    }

    /**
     * developer
     * @param developerId
     * @param model
     * @return
     */
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

    /**
     * page login
     * @return
     */
    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public String showlogin(){
        return PAGE_LOGIN.name;
    }

    /**
     * login
     * @param developerEmail
     * @param developerPassword
     * @return
     */
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


    /**
     * auth
     * @param developerId
     * @param developerToken
     * @return
     */
    @RequestMapping(value = "/{developerId}/{developerToken}/auth",
            method = RequestMethod.POST,
            produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public Result<DeveloperInfo> developerAuth(@PathVariable("developerId") long developerId,
                                               @PathVariable("developerToken") String developerToken){

        Result<DeveloperInfo> result;
        try {
            DeveloperInfo developerInfo = developerService.checkDeveloper(developerId, developerToken);
            if(developerInfo==null){
                throw new TokenAuthFailedException("token auth failed!");
            }
            result = new Result<DeveloperInfo>(true,developerInfo);
        }catch (TokenAuthFailedException e1){
            throw e1;
        }catch (Exception e){
            logger.info(DEVELOPER_FAILED.name,e);
            result = new Result<DeveloperInfo>(false,e.getMessage());
        }
        return result;

    }


}
