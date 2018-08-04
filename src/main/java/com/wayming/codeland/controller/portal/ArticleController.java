package com.wayming.codeland.controller.portal;



import com.wayming.codeland.pojo.eo.*;
import com.wayming.codeland.pojo.vo.ServerResponseVO;
import com.wayming.codeland.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author m969130721@163.com
 * @date 18-6-23 下午11:56
 */

@Controller
@RequestMapping("/article")
public class ArticleController {


    @Autowired
    private ArticleService articleService;

    @Autowired
    private CommentService commentService;

    @Autowired
    private CatalogService catalogService;

    @Autowired
    private ArticleVoteService articleVoteService;

    @Autowired
    private UserService userService;

    /**
     * 查看文章
     * @param articleId
     * @param username
     * @param model
     * @return
     */
    @GetMapping("/{username}/{articleId}")
    public String articlePage(@PathVariable("articleId") Integer articleId,
                              @PathVariable("username") String username,
                              Model model){
        //文章访问量+1 todo  redis优化（先redis increment 后update）
        articleService.incrementReadCount(articleId);
        //用户访问量+1
        userService.incrementVisitCount(username);
        Article article = articleService.getArticleById(articleId);
        model.addAttribute("article",article);
        //评论
        List<Comment> commentList = commentService.listCommentByArticleId(articleId);
        model.addAttribute("commentList",commentList);
        System.out.println(commentList);

        //文章所属的个人目录
        List<Catalog> catalogList = catalogService.listCatalogByArticleId(articleId);
        model.addAttribute("catalogList",catalogList);

        SysUser principal = null;
        if (SecurityContextHolder.getContext().getAuthentication() != null
                && SecurityContextHolder.getContext().getAuthentication().isAuthenticated()
                &&  !SecurityContextHolder.getContext().getAuthentication().getPrincipal().toString().equals("anonymousUser")) {
            principal = (SysUser)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        }
        ArticleVote articleVote = null;
        // 判断操作用户的点赞情况
        if (principal != null){
            articleVote = articleVoteService.getArticleVoteById(articleId, principal.getId());
        }
        model.addAttribute("articleVote",articleVote);


        return "userzone/article";
    }

    /**
     * 显示编辑文章页面
     * @param username
     * @param model
     * @return
     */
    @GetMapping("/{username}/writeArticlePage")
    @PreAuthorize("authentication.name.equals(#username)")//只能操作自己
    public String writeArticlePage(@PathVariable("username")String username,Model model){
        SysUser user = (SysUser)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        //个人分类
        List<Catalog> catalogList = catalogService.listCatalogByUserId(user.getId());
        model.addAttribute("catalogList",catalogList);
        model.addAttribute("article",new Article());
        return "userzone/articleEdit";
    }

    /**
     * 保存文章
     * @param username
     * @param model
     * @param article
     * @param catalogId
     * @return
     */
    @PostMapping("/{username}/saveArticle")
    @PreAuthorize("authentication.name.equals(#username)")//只能操作自己
    @ResponseBody
    public ServerResponseVO saveArticle(@PathVariable("username")String username,
                                        Model model, Article article, Integer catalogId){
        SysUser user = (SysUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        article.setUserId(user.getId());

        if (null != article.getId()){
           return articleService.updateArticle(article,catalogId);
        }

        return articleService.saveArticle(article,catalogId);
    }


    /**
     * 删除文章
     * @param username
     * @param articleId
     * @return
     */
    @DeleteMapping("/{username}/deleteArticle/{articleId}")
    @PreAuthorize("authentication.name.equals(#username)")//只能操作自己
    @ResponseBody
    public ServerResponseVO deleteArticle(@PathVariable("username")String username,
                                          @PathVariable("articleId") Integer articleId){
        return articleService.deleteArticleById(articleId);
    }

    /**
     * 更新文章页面
     * @param username
     * @param articleId
     * @return
     */
    @GetMapping("/{username}/updateArticle/{articleId}")
    @PreAuthorize("authentication.name.equals(#username)")//只能操作自己
    public String updateArticle(@PathVariable("username")String username,
                                        @PathVariable("articleId") Integer articleId,
                                        Model model){
        Article article = articleService.getArticleById(articleId);
        model.addAttribute("article",article);
        SysUser user = (SysUser)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        //个人分类
        List<Catalog> catalogList = catalogService.listCatalogByUserId(user.getId());
        model.addAttribute("catalogList",catalogList);
        return "userzone/articleEdit";
    }






}
