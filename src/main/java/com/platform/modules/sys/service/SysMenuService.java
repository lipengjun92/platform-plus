/*
 * 项目名称:platform-plus
 * 类名称:SysMenuService.java
 * 包名称:com.platform.modules.sys.service
 *
 * 修改履历:
 *      日期                修正者      主要内容
 *      2018/11/21 16:04    李鹏军      初版完成
 *
 * Copyright (c) 2019-2019 微同软件
 */
package com.platform.modules.sys.service;

import com.baomidou.mybatisplus.service.IService;
import com.platform.modules.sys.entity.SysMenuEntity;

import java.util.List;

/**
 * 菜单管理
 *
 * @author 李鹏军
 */
public interface SysMenuService extends IService<SysMenuEntity> {

    /**
     * 根据父菜单，查询子菜单
     *
     * @param parentId
     * @param menuIdList
     * @return
     */
    List<SysMenuEntity> queryListParentId(String parentId, List<String> menuIdList);

    /**
     * 根据父菜单，查询子菜单
     *
     * @param parentId
     * @return
     */
    List<SysMenuEntity> queryListParentId(String parentId);

    /**
     * 获取不包含按钮的菜单列表
     *
     * @return
     */
    List<SysMenuEntity> queryNotButtonList();

    /**
     * 获取用户菜单列表
     *
     * @param userId
     * @return
     */
    List<SysMenuEntity> getUserMenuList(String userId);

    /**
     * 删除
     *
     * @param menuId
     */
    void delete(String menuId);

    /**
     * 查询所有菜单
     *
     * @return
     */
    List<SysMenuEntity> queryList();

    /**
     * 新增菜单
     *
     * @param menu
     * @return
     */
    boolean save(SysMenuEntity menu);
}
