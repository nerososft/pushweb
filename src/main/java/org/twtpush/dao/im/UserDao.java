package org.twtpush.dao.im;

import org.twtpush.entity.im.User;

import java.util.List;

/**
 * author： nero
 * email: nerosoft@outlook.com
 * data: 16-9-18
 * time: 上午10:36.
 */
public interface UserDao {

    long addUser(User user);

    long delUserById(long id);

    List<User> getFriendsList(long userId);

}
