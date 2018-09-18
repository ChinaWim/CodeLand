package com.wayming.codeland.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wayming.codeland.pojo.vo.ServerResponseVO;
import com.wayming.codeland.constant.DefaultConstant;
import com.wayming.codeland.dao.ArticleCatalogMapper;
import com.wayming.codeland.dao.ArticleMapper;
import com.wayming.codeland.pojo.eo.Article;
import com.wayming.codeland.pojo.eo.ArticleCatalog;
import com.wayming.codeland.pojo.vo.PageVO;
import com.wayming.codeland.service.ArticleService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author m969130721@163.com
 * @date 18-6-25 上午12:21
 */
@Service
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    private ArticleMapper articleMapper;

    @Autowired
    private ArticleCatalogMapper articleCatalogMapper;

    @Transactional(rollbackFor = Exception.class)
    @Override
    public ServerResponseVO saveArticle(Article article, Integer catelogId) {
        //保存文章
        System.out.println(article);
        articleMapper.insertSelective(article);
        //添加文章分类
        ArticleCatalog articleCatalog = new ArticleCatalog();
        articleCatalog.setArticleId(article.getId());
        articleCatalog.setCatalogId(catelogId);
        articleCatalogMapper.insertSelective(articleCatalog);

        return ServerResponseVO.sendSuccess("添加成功");
    }

    @Override
    public ServerResponseVO incrementReadCount(Integer id) {
        articleMapper.incrementReadCount(id);
        return ServerResponseVO.sendSuccess("增加成功");
    }

    @Override
    public ServerResponseVO deleteArticleById(Integer articleId) {
        articleMapper.deleteByPrimaryKey(articleId);
        return ServerResponseVO.sendSuccess("删除成功");
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public ServerResponseVO updateArticle(Article article, Integer catelogId) {
        articleMapper.updateByPrimaryKeySelective(article);

        ArticleCatalog articleCatalog = articleCatalogMapper.getByArticleId(article.getId());
        //更新分类
        if (articleCatalog == null){
            ArticleCatalog ac = new ArticleCatalog();
            ac.setCatalogId(catelogId);
            ac.setArticleId(article.getId());
            articleCatalogMapper.insertSelective(ac);
        }else if (articleCatalog.getCatalogId() == null ||
                !articleCatalog.getCatalogId().equals(catelogId)) {
            articleCatalogMapper.deleteByPrimaryKey(articleCatalog.getId());
            ArticleCatalog ac = new ArticleCatalog();
            ac.setCatalogId(catelogId);
            ac.setArticleId(article.getId());
            articleCatalogMapper.insertSelective(ac);
        }
        return ServerResponseVO.sendSuccess("更新成功");
    }

    @Override
    public Article getArticleById(Integer id) {
        return articleMapper.selectByPrimaryKey(id);
    }

    @Override
    public PageVO<Article> listArticle(Integer pageNo,Integer pageSize,String keyword, String sort) {
        if (pageNo <= 0) {
            pageNo = 1;
        }
        if (pageSize > DefaultConstant.MAX_PAGE_SIZE) {
            pageSize = DefaultConstant.MAX_PAGE_SIZE;
        }
        if (!StringUtils.isBlank(keyword)) {
            keyword = "%"+keyword.trim()+"%";
        }

        PageHelper.startPage(pageNo,pageSize,true);
        List<Article> articles = articleMapper.listArticle(keyword, sort);
        PageInfo<Article> pageInfo = new PageInfo<>(articles);
        PageVO pageVO = new PageVO(pageNo,pageSize,pageInfo.getPages(),pageInfo.getTotal(),articles);
        return pageVO;
    }

    @Override
    public PageVO<Article> listArticleByUserId(Integer pageNo, Integer pageSize, Integer userId, String keyword, String sort) {
        if (pageNo <= 0) {
            pageNo = 1;
        }
        if (pageSize > DefaultConstant.MAX_PAGE_SIZE) {
            pageSize = DefaultConstant.MAX_PAGE_SIZE;
        }
        if (!StringUtils.isBlank(keyword)) {
            keyword = "%"+keyword.trim()+"%";
        }
        PageHelper.startPage(pageNo,pageSize,true);
        List<Article> articles = articleMapper.listArticleByUserId(userId,keyword, sort);
        PageInfo<Article> pageInfo = new PageInfo<>(articles);
        PageVO pageVO = new PageVO(pageNo,pageSize,pageInfo.getPages(),pageInfo.getTotal(),articles);
        return pageVO;
    }

}
