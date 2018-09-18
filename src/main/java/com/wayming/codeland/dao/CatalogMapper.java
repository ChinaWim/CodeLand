package com.wayming.codeland.dao;

import com.wayming.codeland.pojo.eo.Catalog;

import java.util.List;

public interface CatalogMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Catalog record);

    int insertSelective(Catalog record);

    Catalog selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Catalog record);

    int updateByPrimaryKey(Catalog record);

    List<Catalog> listCatalogByUserId(Integer userId);

    List<Catalog> listCatalogByArticleId(Integer articleId);

}