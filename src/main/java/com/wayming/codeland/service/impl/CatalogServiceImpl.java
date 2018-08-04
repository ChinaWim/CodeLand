package com.wayming.codeland.service.impl;

import com.wayming.codeland.pojo.vo.ServerResponseVO;
import com.wayming.codeland.dao.CatalogMapper;
import com.wayming.codeland.pojo.eo.Catalog;
import com.wayming.codeland.service.CatalogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author m969130721@163.com
 * @date 18-6-24 下午11:35
 */

@Service
public class CatalogServiceImpl implements CatalogService {

    @Autowired
    private CatalogMapper catalogMapper;


    @Override
    public List<Catalog> listCatalogByUserId(Integer userId) {
      return catalogMapper.listCatalogByUserId(userId);
    }

    @Override
    public List<Catalog> listCatalogByArticleId(Integer articleId) {
       return catalogMapper.listCatalogByArticleId(articleId);
    }

    @Override
    public ServerResponseVO deleteCatalogById(Integer id) {
        catalogMapper.deleteByPrimaryKey(id);
        return ServerResponseVO.sendSuccess("删除成功");
    }

    @Override
    public ServerResponseVO saveCatalog(Catalog catalog) {
        catalogMapper.insertSelective(catalog);
        return ServerResponseVO.sendSuccess("添加成功");
    }

    @Override
    public Catalog getById(Integer catalogId) {
        return catalogMapper.selectByPrimaryKey(catalogId);
    }


}
