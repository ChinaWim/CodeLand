package com.wayming.codeland.service;

import com.wayming.codeland.pojo.vo.ServerResponseVO;
import com.wayming.codeland.pojo.eo.Friend;

import java.util.List;

/**
 * @author m969130721@163.com
 * @date 18-6-26 下午10:20
 */
public interface FriendService {

    List<Friend> listFriendByUserId(Integer userId);

    List<Friend> listNewFriendByUserId(Integer userId);

    ServerResponseVO applyFriend(Integer myId, Integer friendId);

    ServerResponseVO deleteFriendById(Integer myId, Integer friendId);

    ServerResponseVO acceptFriend(Integer myId, Integer friendId);


}
