package com.wayming.codeland.controller.portal;

import com.wayming.codeland.pojo.vo.ServerResponseVO;
import com.wayming.codeland.pojo.eo.ArticleVote;
import com.wayming.codeland.pojo.eo.SysUser;
import com.wayming.codeland.service.ArticleVoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * @author m969130721@163.com
 * @date 18-6-27 下午10:46
 */
@Controller
@RequestMapping("/articleVote")
public class ArticleVoteController {

    @Autowired
    private ArticleVoteService articleVoteService;

    /**
     * 文章点赞
     * @param articleId
     * @return
     */
    @PostMapping("/{articleId}/addArticleVote")
    @PreAuthorize("hasAnyAuthority('ROLE_ADMIN','ROLE_USER')")  // 指定角色权限才能操作方法
    @ResponseBody
    public ServerResponseVO addArticleVote(@PathVariable("articleId")Integer articleId){
        ArticleVote articleVote = new ArticleVote();
        articleVote.setArticleId(articleId);
        return articleVoteService.saveArticleVote(articleVote);
    }

    /**
     * 取消点赞
     * @param articleId
     * @return
     */
    @DeleteMapping("/{articleId}/deleteArticleVote")
    @PreAuthorize("hasAnyAuthority('ROLE_ADMIN','ROLE_USER')")  // 指定角色权限才能操作方法
    @ResponseBody
    public ServerResponseVO deleteArticleVote(@PathVariable("articleId")Integer articleId){
        ArticleVote articleVote = new ArticleVote();
        articleVote.setArticleId(articleId);
        SysUser user = (SysUser)SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        return articleVoteService.deleteArticleVoteById(articleId,user.getId());
    }


}
