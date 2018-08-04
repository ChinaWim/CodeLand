package com.wayming.codeland.service;

import com.wayming.codeland.pojo.vo.ServerResponseVO;
import com.wayming.codeland.pojo.eo.ArticleVote;

import java.util.List;

/**
 * @author m969130721@163.com
 * @date 18-6-27 下午7:30
 */
public interface ArticleVoteService {

    ServerResponseVO saveArticleVote(ArticleVote articleVote);

    ArticleVote getArticleVoteById(Integer articleId,Integer userId);

    ServerResponseVO deleteArticleVoteById(Integer articleId, Integer userId);

    List<ArticleVote> listArticleVoteByArticleId(Integer articleId);
}
