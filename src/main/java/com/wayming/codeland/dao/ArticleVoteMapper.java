package com.wayming.codeland.dao;

import com.wayming.codeland.pojo.eo.ArticleVote;
import com.wayming.codeland.pojo.eo.SysUser;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ArticleVoteMapper {

    int deleteByPrimaryKey(Integer id);

    int insert(ArticleVote record);

    int insertSelective(ArticleVote record);

    ArticleVote selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ArticleVote record);

    int updateByPrimaryKey(ArticleVote record);


    List<ArticleVote> listArticleVoteByArticleId (Integer articleId);

    int deleteByArticleIdAndUserId(@Param("articleId") Integer articleId,@Param("userId") Integer userId);

    ArticleVote getByArticleIdAndUserId(@Param("articleId") Integer articleId,@Param("userId") Integer userId);
}