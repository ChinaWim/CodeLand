package com.wayming.codeland.service.impl;

import com.wayming.codeland.pojo.vo.ServerResponseVO;
import com.wayming.codeland.dao.ArticleMapper;
import com.wayming.codeland.dao.CommentMapper;
import com.wayming.codeland.pojo.eo.Comment;
import com.wayming.codeland.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author m969130721@163.com
 * @date 18-6-25 下午5:08
 */
@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentMapper commentMapper;

    @Autowired
    private ArticleMapper articleMapper;

    @Transactional(rollbackFor = Exception.class)
    @Override
    public ServerResponseVO saveComment(Comment comment) {
        commentMapper.insertSelective(comment);
        //添加文章评论数
        articleMapper.incrementCommentCount(comment.getArticleId());
        return ServerResponseVO.sendSuccess("添加成功");
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public ServerResponseVO deleteCommentById(Integer articleId, Integer commentId) {
        Comment comment = commentMapper.selectByPrimaryKey(commentId);
        //减少文章评论数
        articleMapper.reduceCommentCount(articleId);
        commentMapper.deleteByPrimaryKey(commentId);
        return ServerResponseVO.sendSuccess("删除成功");
    }

    @Override
    public ServerResponseVO updateComment(Comment comment) {
        commentMapper.updateByPrimaryKey(comment);
        return ServerResponseVO.sendSuccess("更新成功");
    }

    @Override
    public List<Comment> listCommentByArticleId(Integer articleId) {
        return commentMapper.listCommentByArticleId(articleId);
    }
}
