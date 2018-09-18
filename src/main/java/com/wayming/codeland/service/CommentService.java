package com.wayming.codeland.service;

import com.wayming.codeland.pojo.vo.ServerResponseVO;
import com.wayming.codeland.pojo.eo.Comment;

import java.util.List;

/**
 * @author m969130721@163.com
 * @date 18-6-25 下午5:07
 */
public interface CommentService {

    ServerResponseVO saveComment(Comment comment);

    ServerResponseVO deleteCommentById(Integer articleId, Integer commentId);

    ServerResponseVO updateComment(Comment comment);

    List<Comment> listCommentByArticleId(Integer articleId);

}
