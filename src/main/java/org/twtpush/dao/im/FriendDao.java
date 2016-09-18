package org.twtpush.dao.im;

import org.twtpush.entity.im.Friends;
import org.twtpush.entity.im.User;

/**
 * author： nero
 * email: nerosoft@outlook.com
 * data: 16-9-18
 * time: 上午10:36.
 */
public interface FriendDao {

    long addFriend(Friends friends);

    long delFriendById(long userA,long userB);

    long friendPass(long userA,long userB);//param1 pass



    User findFriend(long userA,long userB);

}
