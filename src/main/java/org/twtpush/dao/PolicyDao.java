package org.twtpush.dao;

import org.apache.ibatis.annotations.Param;
import org.twtpush.entity.Policy;

import java.util.List;

/**
 * author： nero
 * email: nerosoft@outlook.com
 * data: 16-9-4
 * time: 下午4:06.
 */
public interface PolicyDao {

    /**
     * 添加推送策略
     * @param policyName
     * @return
     */
    int addPolicy(@Param("policyName") String policyName,@Param("appId") long appId);

    /**
     * 删除推送策略
     * @param id
     * @return
     */
    int deletePolicy(long id);


    /**
     * 获取策略组
     * @param offset
     * @param limit
     * @return
     */
    List<Policy> getPolicyList(@Param("appId") long appId,@Param("offset") long offset,@Param("limit") long limit);


    /**
     * 修改策略名
     * @param id
     * @param newPolicyName
     * @return
     */
    int modifyPolicy(@Param("id") long id,@Param("newPolicyName") String newPolicyName);





}
