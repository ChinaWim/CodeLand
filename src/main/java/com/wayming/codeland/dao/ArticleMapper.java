package com.wayming.codeland.dao;

import com.wayming.codeland.pojo.eo.Article;
import org.apache.ibatis.annotations.Param;

import javax.websocket.server.PathParam;
import java.util.List;

public interface ArticleMapper {

    int deleteByPrimaryKey(Integer id);

    int insert(Article record);

    int insertSelective(Article record);

    Article selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Article record);

    int updateByPrimaryKey(Article record);

    List<Article> listArticle(@Param("keyword") String keyword, @Param("sort") String sort);

    List<Article> listArticleByUserId(@Param("userId") Integer userId,
                                      @Param("keyword") String keyword, @Param("sort")String sort);

    int incrementReadCount(Integer id);

    int incrementVoteCount(Integer id);

    int reduceVoteCount(Integer id);

    int incrementCommentCount(Integer id);

    int reduceCommentCount(Integer id);

}