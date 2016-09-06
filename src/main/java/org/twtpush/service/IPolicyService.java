package org.twtpush.service;

import org.springframework.stereotype.Service;
import org.twtpush.dto.Operate;
import org.twtpush.dto.Result;
import org.twtpush.entity.Policy;

import java.util.List;

/**
 * author： nero
 * email: nerosoft@outlook.com
 * data: 16-9-4
 * time: 下午5:10.
 */
public interface IPolicyService {

    /**
     * 创建策略
     * @param policyName
     * @return
     */
    Operate createPolicy(String policyName,long appId);

    /**
     * 删除策略
     * @param id
     * @return
     */
    Operate deletePolicy(long id);

    /**
     * 修改策略信息
     * @param id
     * @param newName
     * @return
     */
    Operate modifyPolicy(long id,String newName);


    /**
     * 获取策略组
     * @param offset
     * @param limit
     * @return
     */
    Result<List<Policy>> getPolicyList(long appId,long offset,long limit);

    /**
     * 查询策略信息
     *
     * @param policyId
     * @return
     */
    Policy findById(long policyId);

}
