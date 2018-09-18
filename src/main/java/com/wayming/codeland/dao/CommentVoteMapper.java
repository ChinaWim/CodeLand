package com.wayming.codeland.dao;

import com.wayming.codeland.pojo.eo.CommentVote;

public interface CommentVoteMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(CommentVote record);

    int insertSelective(CommentVote record);

    CommentVote selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CommentVote record);

    int updateByPrimaryKey(CommentVote record);
}