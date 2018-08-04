package com.wayming.codeland.service.impl;

import com.wayming.codeland.pojo.vo.ServerResponseVO;
import com.wayming.codeland.dao.FriendMapper;
import com.wayming.codeland.pojo.eo.Friend;
import com.wayming.codeland.service.FriendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author m969130721@163.com
 * @date 18-6-26 下午10:20
 */
@Service
public class FriendServiceImpl implements FriendService {

    @Autowired
    private FriendMapper friendMapper;


    @Override
    public List<Friend> listFriendByUserId(Integer userId) {
        return friendMapper.listFriendByUserId(userId);
    }

    @Override
    public List<Friend> listNewFriendByUserId(Integer userId) {
        return friendMapper.listNewFriendByUserId(userId);
    }

    @Override
    public ServerResponseVO applyFriend(Integer myId, Integer friendId) {
        Friend userAndFriend = new Friend();
        userAndFriend.setUserId(myId);
        userAndFriend.setFriendId(friendId);
        friendMapper.insertSelective(userAndFriend);
        return ServerResponseVO.sendSuccess("已发出申请");
    }

    @Override
    public ServerResponseVO deleteFriendById(Integer myId, Integer friendId) {
        friendMapper.deleteFriendById(myId,friendId);
       return ServerResponseVO.sendSuccess("删除成功!");
    }

    @Override
    public ServerResponseVO acceptFriend(Integer myId, Integer friendId) {
        friendMapper.acceptFriend(myId,friendId);
        return ServerResponseVO.sendSuccess("已接受");
    }
}
