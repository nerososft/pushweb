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
import org.twtpush.dto.Operate;
import org.twtpush.dto.Result;
import org.twtpush.entity.App;
import org.twtpush.entity.Policy;
import org.twtpush.exception.NotAppException;
import org.twtpush.exception.NotPolicyException;
import org.twtpush.exception.NotUserException;
import org.twtpush.exception.TokenAuthFailedException;
import org.twtpush.service.IAppService;
import org.twtpush.service.IDeveloperService;
import org.twtpush.service.IPolicyService;

import java.util.List;

import static org.twtpush.util.CONSTANT.*;

/**
 * author： nero
 * email: nerosoft@outlook.com
 * data: 16-9-4
 * time: 下午7:54.
 */
@Controller
@RequestMapping("/policy")
public class PolicyController {

    @Autowired
    private IPolicyService policyService;
    @Autowired
    private IDeveloperService developerService;
    @Autowired
    private IAppService appService;

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    /**
     * 创建新策略
     *
     * @param developerId
     * @param developerToken
     * @param policyName
     * @param appId
     * @return Operate
     */
    @RequestMapping(value = "/{developerId}/{developerToken}/auth/{developerPass}/verify/{appId}/{policyName}/create",
            method = RequestMethod.POST,
            produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public Operate createPolicy(@PathVariable("developerId") long developerId,
                                @PathVariable("developerToken") String developerToken,
                                @PathVariable("developerPass") String developerPass,
                                @PathVariable("policyName") String policyName,
                                @PathVariable("appId") long appId) {
        Operate result;
        DeveloperInfo developer;
        App app;

        try {
            developer = developerService.checkDeveloper(developerId, developerToken);
            if (developer == null) {
                throw new TokenAuthFailedException(TOKEN_AUTH_FAILED.name);
            }
            if (developerService.verify(developer.getDeveloperEmail(), developerPass) == null) {
                throw new NotUserException(PASSWORD_INCORRECT.name);
            }
            app = appService.findById(appId);

            if (app.getAppDeveloperId() != developer.getDeveloperId()) {
                throw new NotAppException(NOT_APP.name);
            }
            if (policyService.createPolicy(policyName, appId).isState()) {
                result = new Operate(true, "create success!", 1002);
            } else {
                result = new Operate(false, "create failed!", 1003);
            }
        } catch (TokenAuthFailedException e1) {
            logger.error(TOKEN_AUTH_FAILED.name, e1);
            result = new Operate(false, e1.getMessage(), 1001);
        } catch (NotUserException e4) {
            logger.error(PASSWORD_INCORRECT.name, e4);
            result = new Operate(false, e4.getMessage(), 1001);
        } catch (Exception e) {
            logger.error(POLICY_FAILED.name, e);
            result = new Operate(false, e.getMessage(), 1001);
        }
        return result;
    }

    /**
     * 获取策略组
     *
     * @param developerId
     * @param developerToken
     * @param appId
     * @param offset
     * @param limit
     * @return
     */
    @RequestMapping(value = "/{developerId}/{developerToken}/auth/{appId}/list/{offset}/{limit}",
            method = RequestMethod.POST,
            produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public Result<List<Policy>> getAllPolicy(@PathVariable("developerId") long developerId,
                                             @PathVariable("developerToken") String developerToken,
                                             @PathVariable("appId") long appId,
                                             @PathVariable("offset") long offset,
                                             @PathVariable("limit") long limit) {
        Result<List<Policy>> result;
        App app = appService.findById(appId);
        try {
            DeveloperInfo developer = developerService.checkDeveloper(developerId, developerToken);
            if (developer == null) {
                throw new TokenAuthFailedException(TOKEN_AUTH_FAILED.name);
            }

            if (app.getAppDeveloperId() != developer.getDeveloperId()) {
                throw new NotAppException(NOT_APP.name);
            }
            result = policyService.getPolicyList(appId, offset, limit);
        } catch (TokenAuthFailedException e1) {
            logger.info(TOKEN_AUTH_FAILED.name, e1);
            result = new Result<List<Policy>>(false, e1.getMessage());
        } catch (NotAppException e2) {
            logger.info(NOT_APP.name, e2);
            result = new Result<List<Policy>>(false, e2.getMessage());
        } catch (Exception e) {
            logger.info(POLICY_FAILED.name, e);
            result = new Result<List<Policy>>(false, e.getMessage());
        }
        return result;
    }


    /**
     * 删除策略
     *
     * @param developerId
     * @param developerToken
     * @param policyId
     * @return Operate
     */
    @RequestMapping(value = "/{developerId}/{developerToken}/auth/{developerPass}/verify/{policyId}/delete",
            method = RequestMethod.POST,
            produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public Operate deletePolicy(@PathVariable("developerId") long developerId,
                                @PathVariable("developerToken") String developerToken,
                                @PathVariable("developerPass") String developerPass,
                                @PathVariable("policyId") long policyId) {

        Operate result;
        Policy policy;
        DeveloperInfo developer;
        App app;

        try {
            developer = developerService.checkDeveloper(developerId, developerToken);
            if (developer == null) {
                throw new TokenAuthFailedException("token auth failed!");
            }
            if (developerService.verify(developer.getDeveloperEmail(), developerPass) == null) {
                throw new NotUserException("password incorrect!");
            }
            policy = policyService.findById(policyId);
            if (policy == null) {
                throw new NotPolicyException("not policy");
            }
            app = appService.findById(policy.getAppId());

            if (app.getAppDeveloperId() != developer.getDeveloperId()) {
                throw new NotAppException("it not your app!");
            }
            if (policyService.deletePolicy(policyId).isState()) {
                result = new Operate(true, "delete success!", 1002);
            } else {
                result = new Operate(false, "delete failed!", 1003);
            }
        } catch (NotPolicyException e3) {
            logger.info(NOT_POLICY.name, e3);
            result = new Operate(false, e3.getMessage(), 1001);
        } catch (TokenAuthFailedException e1) {
            logger.info(TOKEN_AUTH_FAILED.name, e1);
            result = new Operate(false, e1.getMessage(), 1001);
        } catch (NotAppException e2) {
            logger.info(NOT_APP.name, e2);
            result = new Operate(false, e2.getMessage(), 1001);
        } catch (NotUserException e5) {
            logger.info(PASSWORD_INCORRECT.name, e5);
            result = new Operate(false, e5.getMessage(), 1001);
        } catch (Exception e) {
            logger.info(POLICY_FAILED.name, e);
            result = new Operate(false, e.getMessage(), 1001);
        }
        return result;
    }

    /**
     * 修改策略名
     *
     * @param developerId
     * @param developerToken
     * @param policyId
     * @param policyName
     * @return Operate
     */
    @RequestMapping(value = "/{developerId}/{developerToken}/auth/{developerPass}/verify/{policyId}/{policyName}/modify",
            method = RequestMethod.POST,
            produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public Operate modifyPolicy(@PathVariable("developerId") long developerId,
                                @PathVariable("developerToken") String developerToken,
                                @PathVariable("developerPass") String developerPass,
                                @PathVariable("policyId") long policyId,
                                @PathVariable("policyName") String policyName) {

        Operate result;
        Policy policy;
        DeveloperInfo developer;
        App app;

        try {
            developer = developerService.checkDeveloper(developerId, developerToken);
            policy = policyService.findById(policyId);
            if (developer == null) {
                throw new TokenAuthFailedException("token auth failed!");
            } else if (developerService.verify(developer.getDeveloperEmail(), developerPass) == null) {
                throw new NotUserException("password incorrect!");
            } else if (policy == null) {
                throw new NotPolicyException("not policy");
            } else {
                app = appService.findById(policy.getAppId());
                if (app.getAppDeveloperId() != developer.getDeveloperId()) {
                    throw new NotAppException("it not your app!");
                }
                if (policyService.modifyPolicy(policyId, policyName).isState()) {
                    result = new Operate(true, "modify success!", 1002);
                } else {
                    result = new Operate(false, "modify failed!", 1003);
                }
            }
        } catch (NotPolicyException e3) {
            logger.info(NOT_POLICY.name, e3);
            result = new Operate(false, e3.getMessage(), 1001);
        } catch (TokenAuthFailedException e1) {
            logger.info(TOKEN_AUTH_FAILED.name, e1);
            result = new Operate(false, e1.getMessage(), 1001);
        } catch (NotAppException e2) {
            logger.info(NOT_APP.name, e2);
            result = new Operate(false, e2.getMessage(), 1001);
        } catch (NotUserException e5) {
            logger.info(PASSWORD_INCORRECT.name, e5);
            result = new Operate(false, e5.getMessage(), 1001);
        } catch (Exception e) {
            logger.info(POLICY_FAILED.name, e);
            result = new Operate(false, e.getMessage(), 1001);
        }
        return result;

    }


}
