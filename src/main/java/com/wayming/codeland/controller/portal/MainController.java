package com.wayming.codeland.controller.portal;

import com.wayming.codeland.pojo.eo.Article;
import com.wayming.codeland.pojo.eo.SysUser;
import com.wayming.codeland.pojo.vo.PageVO;
import com.wayming.codeland.service.ArticleService;
import com.wayming.codeland.service.CatalogService;
import com.wayming.codeland.service.UserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.websocket.server.PathParam;
import java.io.IOException;
import java.io.PrintWriter;

/**首页Controller
 * @author m969130721@163.com
 * @date 18-6-22 下午5:10
 */
@Controller
public class MainController {

    @Autowired
    private ArticleService articleService;

    @Autowired
    private UserService userService;

    @Autowired
    private CatalogService catalogService;

    /**
     * 登录失败
     * @param model
     * @return
     */
    @GetMapping("/login-error")
    public String loginError(Model model) {
        model.addAttribute("loginError", true);
        model.addAttribute("errorMsg", "登录失败，账号或者密码错误！");
        return "login";
    }


    @GetMapping("/index")
    public String index(@RequestParam(value="pageNo",defaultValue = "1") Integer pageNo,
                        @RequestParam(value="pageSize",defaultValue = "5")Integer pageSize,
                        String keyword,String sort,
                        Model model){
        model.addAttribute("keyword",keyword);
        model.addAttribute("sort",sort);
        //文章列表
        PageVO<Article> articlePageVO = articleService.listArticle(pageNo, pageSize, keyword, sort);
        model.addAttribute("page",articlePageVO);
        PageVO<Article> hotArticlePageVO = articleService.listArticle(1, 5, null, "hot");
        model.addAttribute("hotPage",hotArticlePageVO);
        //最新文章
        PageVO<Article> newArticlePageVO = articleService.listArticle(1, 5, null, "new");
        model.addAttribute("newPage",newArticlePageVO);

        //热门用户
        PageVO<SysUser> hotUser = userService.listUserByHot(1, 10);
        model.addAttribute("hotUserPage",hotUser);
        //热门标签


        return "index";

    }






}
