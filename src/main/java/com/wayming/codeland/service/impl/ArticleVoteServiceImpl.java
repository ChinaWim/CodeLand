package com.wayming.codeland.service.impl;

import com.wayming.codeland.pojo.vo.ServerResponseVO;
import com.wayming.codeland.dao.ArticleMapper;
import com.wayming.codeland.dao.ArticleVoteMapper;
import com.wayming.codeland.pojo.eo.ArticleVote;
import com.wayming.codeland.pojo.eo.SysUser;
import com.wayming.codeland.service.ArticleVoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author m969130721@163.com
 * @date 18-6-27 下午7:30
 */
@Service
public class ArticleVoteServiceImpl implements ArticleVoteService {

    @Autowired
    private ArticleVoteMapper articleVoteMapper;

    @Autowired
    private ArticleMapper articleMapper;

    @Transactional(rollbackFor = Exception.class)
    @Override
    public ServerResponseVO saveArticleVote(ArticleVote articleVote) {
        SysUser user = (SysUser)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        articleVote.setUserId(user.getId());
        articleVoteMapper.insertSelective(articleVote);
        //添加文章点赞
        articleMapper.incrementVoteCount(articleVote.getArticleId());
        return ServerResponseVO.sendSuccess("点赞成功");
    }

    @Override
    public ArticleVote getArticleVoteById(Integer articleId,Integer userId) {
        return articleVoteMapper.getByArticleIdAndUserId(articleId,userId);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public ServerResponseVO deleteArticleVoteById(Integer articleId, Integer userId) {
        //删除记录
        int i = articleVoteMapper.deleteByArticleIdAndUserId(articleId, userId);
        //取消文章点赞
        articleMapper.reduceVoteCount(articleId);
        return ServerResponseVO.sendSuccess("取消点赞成功");
    }

    @Override
    public List<ArticleVote> listArticleVoteByArticleId(Integer articleId) {
        List<ArticleVote> articleVotes = articleVoteMapper.listArticleVoteByArticleId(articleId);
        return articleVotes;
    }
}
