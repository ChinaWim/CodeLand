package com.wayming.codeland.controller.portal;

import com.wayming.codeland.pojo.vo.ServerResponseVO;
import com.wayming.codeland.pojo.eo.Catalog;
import com.wayming.codeland.pojo.eo.SysUser;
import com.wayming.codeland.service.CatalogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * @author m969130721@163.com
 * @date 18-6-28 上午1:00
 */
@Controller
@RequestMapping("/catalog")
public class CatalogController {

    @Autowired
    private CatalogService catalogService;

    @PostMapping("/createCatalog")
    @PreAuthorize("hasAnyAuthority('ROLE_ADMIN','ROLE_USER')")  // 指定角色权限才能操作方法
    @ResponseBody
    public ServerResponseVO createCatalog(Catalog catalog){

        if (catalog.getId() != null){ //update
            //todo
        }else{
            SysUser user = (SysUser)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            catalog.setUserId(user.getId());
        }

        return catalogService.saveCatalog(catalog);
    }

    @DeleteMapping("/deleteCatalog/{catalogId}")
    @PreAuthorize("hasAnyAuthority('ROLE_ADMIN','ROLE_USER')")  // 指定角色权限才能操作方法
    @ResponseBody
    public ServerResponseVO createCatalog(@PathVariable("catalogId") Integer catalogId){
        return catalogService.deleteCatalogById(catalogId);
    }

}
