package com.wayming.codeland.dao;

import com.wayming.codeland.pojo.eo.ArticleCatalog;

public interface ArticleCatalogMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ArticleCatalog record);

    int insertSelective(ArticleCatalog record);

    ArticleCatalog selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ArticleCatalog record);

    int updateByPrimaryKey(ArticleCatalog record);

    ArticleCatalog getByArticleId(Integer articleId);

    ArticleCatalog getByCatalogId(Integer catalogId);
}