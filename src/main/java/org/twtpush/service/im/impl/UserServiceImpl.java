package org.twtpush.service.im.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.twtpush.dao.im.UserDao;
import org.twtpush.dto.Operate;
import org.twtpush.entity.im.PayLoad;
import org.twtpush.entity.im.User;
import org.twtpush.service.im.IUserService;

import java.util.List;
import org.slf4j.*;

/**
 * author： nero
 * email: nerosoft@outlook.com
 * data: 16-9-18
 * time: 上午8:29.
 *
 */

@Service
public class UserServiceImpl implements IUserService {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @SuppressWarnings("SpringJavaAutowiringInspection")
    @Autowired
    private UserDao userDao;



    public long deleteUserById(long userId) {
        //return 0;
        return userDao.addUser(new User());
    }


    public long addUser(User user) {
        return 0;
    }

    public List<User> getFriendsList(long userId) {

        return userDao.getFriendsList(userId);

    }

    public Operate addFriend(PayLoad payLoad) {
        return null;
    }

    public Operate deleteFriend(long friendId) {
        return null;
    }

    public Operate createGroup(long appId, long userId) {
        return null;
    }

    public Operate addGroup(PayLoad payLoad) {
        return null;
    }

    public Operate exitGroup(long groupId) {
        return null;
    }

    public User findFriend(long userA, long userB) {
        return null;
    }
}
