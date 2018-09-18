package com.wayming.codeland.dao;

import com.wayming.codeland.pojo.eo.SubComment;

public interface SubCommentMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SubComment record);

    int insertSelective(SubComment record);

    SubComment selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SubComment record);

    int updateByPrimaryKey(SubComment record);
}