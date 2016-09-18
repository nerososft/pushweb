package org.twtpush.service.im;

import org.twtpush.dto.Operate;
import org.twtpush.entity.im.PayLoad;
import org.twtpush.entity.im.User;

import java.util.List;

/**
 * author： nero
 * email: nerosoft@outlook.com
 * data: 16-9-18
 * time: 上午8:28.
 */
public interface IUserService {


    /**
     * 删除用户
     * @param userId
     * @return
     */
    long deleteUserById(long userId);


    /**
     * 添加用户
     * @param user
     * @return
     */
    long addUser(User user);


    /**
     * 获取好友列表
     * @param userId
     * @return
     */
    List<User> getFriendsList(long userId);


    /**
     * 添加好友
     * @param payLoad
     * @return Operate
     */
    Operate addFriend(PayLoad payLoad);

    /**
     * 解除好友关系
     * @param friendId
     * @return
     */
    Operate deleteFriend(long friendId);


    /**
     * 建群
     * @return
     */
    Operate createGroup(long appId,long userId);
    /**
     * 加群
     * @param payLoad
     * @return
     */
    Operate addGroup(PayLoad payLoad);

    /**
     * 退群
     * @param groupId
     * @return
     */
    Operate exitGroup(long groupId);


    /**
     * 查询是否是好友
     * @param userA
     * @param userB
     * @return
     */
    User findFriend(long userA,long userB);





}
