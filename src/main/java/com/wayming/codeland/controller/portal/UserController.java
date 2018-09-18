package com.wayming.codeland.controller.portal;

import com.wayming.codeland.pojo.vo.ServerResponseVO;
import com.wayming.codeland.constant.RestStatusConstant;
import com.wayming.codeland.util.FileUtil;
import com.wayming.codeland.pojo.eo.Article;
import com.wayming.codeland.pojo.eo.Catalog;
import com.wayming.codeland.pojo.eo.Friend;
import com.wayming.codeland.pojo.eo.SysUser;
import com.wayming.codeland.pojo.vo.PageVO;
import com.wayming.codeland.service.ArticleService;
import com.wayming.codeland.service.CatalogService;
import com.wayming.codeland.service.FriendService;
import com.wayming.codeland.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author m969130721@163.com
 * @date 18-6-21 下午4:17
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private CatalogService catalogService;

    @Autowired
    private ArticleService articleService;

    @Autowired
    private FriendService friendService;


    /**
     * 注册用户
     *
     * @param sysUser
     * @return
     */
    @PostMapping("/register")
    public String register(SysUser sysUser) {
        userService.registerUser(sysUser);
        return "gotoEmail";
    }

    /**
     * 激活账号
     *
     * @param activeCode
     * @param request
     * @return
     */
    @GetMapping("/activeAccount")
    public String activeAccount(String activeCode, HttpServletRequest request) {
        ServerResponseVO response = userService.activeAccount(activeCode);
        if (response.isSuccess()) {
            return "login";
        }
        request.setAttribute("error", response);
        return "500";
    }

    /**
     * 验证账号是否重复
     *
     * @param username
     * @return
     */
    @PostMapping("/checkUsername")
    @ResponseBody
    public ServerResponseVO checkUsername(String username) {
        SysUser user = userService.getUserByUsername(username);
        if (null != user) {
            return ServerResponseVO.sendFail(RestStatusConstant.EXISTED_USERNAME, "账号已存在");
        }
        return ServerResponseVO.sendSuccess("验证通过");
    }

    /**
     * 个人信息页面
     *
     * @param username
     * @param model
     * @return
     */
    @GetMapping("/{username}/profilePage")
    @PreAuthorize("authentication.name.equals(#username)")
    public String profilePage(@PathVariable("username") String username, Model model) {
        SysUser user = userService.getUserByUsername(username);
        model.addAttribute("user", user);
        return "userzone/profile";
    }

    /**
     * 密码修改页面
     *
     * @param username
     * @param model
     * @return
     */
    @GetMapping("/{username}/rePasswordPage")
    @PreAuthorize("authentication.name.equals(#username)")
    public String rePasswordPage(@PathVariable("username") String username, Model model) {
        SysUser user = userService.getUserByUsername(username);
        model.addAttribute("user", user);
        return "userzone/rePassword";
    }

    /**
     * 更新用户信息
     *
     * @param username
     * @param user
     * @return
     */
    @PostMapping("/{username}/updateProfile")
    @ResponseBody
    @PreAuthorize("authentication.name.equals(#username)")
    public ServerResponseVO updateProfile(@PathVariable("username") String username, SysUser user) {
        System.out.println(user);
        return userService.updateUser(user);
    }

    /**
     * 修改密码
     *
     * @param username
     * @param newPassword
     * @param oldPassword
     * @return
     */
    @PostMapping("/{username}/rePassword")
    @ResponseBody
    @PreAuthorize("authentication.name.equals(#username)")
    public ServerResponseVO updateProfile(@PathVariable("username") String username, String newPassword, String oldPassword) {
        return userService.rePassword(username, newPassword, oldPassword);
    }

    /**
     * 保存头像
     * 从Nginx取出图片
     *
     * @return
     */
    @PostMapping("/saveAvatar")
    @PreAuthorize("hasAnyAuthority('ROLE_ADMIN','ROLE_USER')")  // 指定角色权限才能操作方法
    @ResponseBody
    public ServerResponseVO saveAvatar(MultipartFile file) {
        SysUser user = (SysUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return userService.uploadAvatar(user.getId(),file);
    }

    /**
     * 用户主页
     *
     * @param username
     * @param pageNo
     * @param pageSize
     * @param keyword
     * @param sort
     * @param model
     * @return
     */
    @GetMapping("/{username}/mainPage")
    public String zone(@PathVariable("username") String username,
                       @RequestParam(value = "pageNo", defaultValue = "1") Integer pageNo,
                       @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
                       String keyword, String sort,
                       Model model) {
        model.addAttribute("userKeyword", keyword);
        model.addAttribute("userSort", sort);

        SysUser user = userService.getUserByUsername(username);
        model.addAttribute("user", user);
        //个人分类列表
        List<Catalog> catalogs = catalogService.listCatalogByUserId(user.getId());
        model.addAttribute("catalogList", catalogs);
        //文章列表
        PageVO<Article> articlePageVO = articleService.listArticleByUserId(pageNo, pageSize, user.getId(), keyword, sort);
        model.addAttribute("page", articlePageVO);
        //判断是否主用户登录
        SysUser principal = null;
        if (SecurityContextHolder.getContext().getAuthentication() != null
                && SecurityContextHolder.getContext().getAuthentication().isAuthenticated()
                && !SecurityContextHolder.getContext().getAuthentication().getPrincipal().toString().equals("anonymousUser")) {
            principal = (SysUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        }
        if (principal != null && principal.getUsername().equals(user.getUsername())) {
            model.addAttribute("isCatalogsOwner", true);
        }

        return "userzone/main";
    }

    /**
     * 关注博主
     *
     * @param friendId
     * @return
     */
    @PostMapping("/applyFriend")
    @ResponseBody
    @PreAuthorize("hasAnyAuthority('ROLE_ADMIN','ROLE_USER')")  // 指定角色权限才能操作方法
    public ServerResponseVO applyFriend(Integer friendId) {
        SysUser user = (SysUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return friendService.applyFriend(user.getId(), friendId);
    }

    /**
     * 好友页面
     *
     * @param username
     * @param model
     * @return
     */
    @GetMapping("/{username}/friendPage")
    @PreAuthorize("authentication.name.equals(#username)")
    public String friendPage(@PathVariable("username") String username, Model model) {
        SysUser user = (SysUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        List<Friend> friends = friendService.listFriendByUserId(user.getId());
        model.addAttribute("friendList", friends);
        List<Friend> newFriendList = friendService.listNewFriendByUserId(user.getId());
        model.addAttribute("newFriendList", newFriendList);
        return "userzone/friend";
    }

}
