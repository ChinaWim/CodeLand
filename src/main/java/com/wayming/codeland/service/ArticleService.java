package com.wayming.codeland.service;

import com.wayming.codeland.pojo.eo.Article;
import com.wayming.codeland.pojo.vo.PageVO;
import com.wayming.codeland.pojo.vo.ServerResponseVO;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author m969130721@163.com
 * @date 18-6-25 上午12:21
 */
public interface ArticleService {

    ServerResponseVO saveArticle(Article article, Integer cateLogId);

    ServerResponseVO deleteArticleById(Integer articleId);

    ServerResponseVO incrementReadCount(Integer articleId);


    @Transactional(rollbackFor = Exception.class)
    ServerResponseVO updateArticle(Article article, Integer catelogId);

    Article getArticleById(Integer articleId);

    /**
     *
     * @param pageNo
     * @param pageSize
     * @param keyword 搜索关键字　标签,标题,摘要，内容
     * @param sort  排序，最新，最热　
     * @return
     */
    PageVO<Article> listArticle(Integer pageNo, Integer pageSize, String keyword, String sort);

    /**
     *
     * @param pageNo
     * @param pageSize
     * @param userId 文章用户id
     * @param keyword 搜索关键字　标签，标题，摘要，内容
     * @param sort 排序，最新，最热　
     * @return
     */
    PageVO<Article> listArticleByUserId(Integer pageNo,Integer pageSize,Integer userId,String keyword,String sort);

}
