package com.wayming.codeland.dao;

import com.wayming.codeland.pojo.eo.Friend;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface FriendMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Friend record);

    int insertSelective(Friend record);

    Friend selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Friend record);

    int updateByPrimaryKey(Friend record);

    List<Friend> listFriendByUserId(Integer userId);

    List<Friend> listNewFriendByUserId(Integer userId);

    int deleteFriendById(Integer myId, Integer friendId);

    int acceptFriend(@Param("myId") Integer myId, @Param("myId")Integer friendId);
}