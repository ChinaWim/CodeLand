package com.wayming.codeland.controller.portal;

import com.wayming.codeland.pojo.vo.ServerResponseVO;
import com.wayming.codeland.pojo.eo.Comment;
import com.wayming.codeland.pojo.eo.SysUser;
import com.wayming.codeland.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * @author m969130721@163.com
 * @date 18-6-29 上午1:29
 */
@Controller
@RequestMapping("/comment")
public class CommentController {

    @Autowired
    private CommentService commentService;

    @PostMapping("/saveComment")
    @PreAuthorize("hasAnyAuthority('ROLE_ADMIN','ROLE_USER')")  // 指定角色权限才能操作方法
    @ResponseBody
    public ServerResponseVO saveComment(Comment comment){
        SysUser user = (SysUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        comment.setUserId(user.getId());
        return commentService.saveComment(comment);
    }

    @DeleteMapping("/deleteComment/{articleId}/{commentId}")
    @PreAuthorize("hasAnyAuthority('ROLE_ADMIN','ROLE_USER')")  // 指定角色权限才能操作方法
    @ResponseBody
    public ServerResponseVO deleteComment(@PathVariable("articleId") Integer articleId,
                                          @PathVariable("commentId") Integer commentId){
        return commentService.deleteCommentById(articleId,commentId);
    }


}
