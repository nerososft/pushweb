package org.twtpush.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StopWatch;
import org.twtpush.dao.PolicyDao;
import org.twtpush.dto.Operate;
import org.twtpush.dto.Result;
import org.twtpush.entity.Policy;
import org.twtpush.exception.CreatePolicyException;
import org.twtpush.service.IPolicyService;

import java.util.List;

/**
 * author： nero
 * email: nerosoft@outlook.com
 * data: 16-9-4
 * time: 下午5:54.
 */
@Service
public class PolicyServiceImpl implements IPolicyService {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @SuppressWarnings("SpringJavaAutowiringInspection")
    @Autowired

    private PolicyDao policyDao;

    public Operate createPolicy(String policyName, long appId) throws CreatePolicyException {
        long result = policyDao.addPolicy(policyName, appId);
        if(result<1){
            throw new CreatePolicyException("cretae policy failed!");
        }else{
            return new Operate(true,"add success!",02001);
        }
    }

    public Operate deletePolicy(long id) {
        long result = policyDao.deletePolicy(id);
        if(result<1){
            return new Operate(false,"delete policy failed!",01001);
        }else{
            return new Operate(true,"delete policy success!",02001);
        }
    }

    public Operate modifyPolicy(long id, String newName) {
        long result = policyDao.modifyPolicy(id,newName);
        if(result<1){
            return new Operate(false,"modify policy failed!",01001);
        }else{
            return new Operate(true,"modify policy success!",02001);
        }
    }

    public Result<List<Policy>> getPolicyList(long appId,long offset, long limit) {
        return new Result<List<Policy>>(true,policyDao.getPolicyList(appId,offset,limit));
    }

    public Policy findById(long policyId) {
        return policyDao.findPolicyById(policyId);
    }
}
