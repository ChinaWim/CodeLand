package com.wayming.codeland.service;

import com.wayming.codeland.pojo.vo.ServerResponseVO;
import com.wayming.codeland.pojo.eo.Catalog;

import java.util.List;

/**
 * @author m969130721@163.com
 * @date 18-6-24 下午11:35
 */
public interface CatalogService {

    List<Catalog>  listCatalogByUserId(Integer userId);

    List<Catalog>  listCatalogByArticleId(Integer articleId);

    ServerResponseVO deleteCatalogById(Integer id);

    ServerResponseVO saveCatalog(Catalog catalog);

    Catalog getById(Integer catalogId);



}
