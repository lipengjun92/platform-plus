/*
 * 项目名称:platform-plus
 * 类名称:SysRoleService.java
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
import com.platform.common.utils.PageUtils;
import com.platform.modules.sys.entity.SysRoleEntity;

import java.util.List;
import java.util.Map;

/**
 * 角色
 *
 * @author 李鹏军
 */
public interface SysRoleService extends IService<SysRoleEntity> {

    /**
     * queryPage
     *
     * @param params
     * @return
     */
    PageUtils queryPage(Map<String, Object> params);

    /**
     * 保存
     *
     * @param role
     */
    void save(SysRoleEntity role);

    /**
     * 更新
     *
     * @param role
     */
    void update(SysRoleEntity role);

    /**
     * 删除
     *
     * @param roleIds
     */
    void deleteBatch(String[] roleIds);

    /**
     * 查询用户权限下的角色ID列表
     *
     * @param params
     * @return
     */
    List<String> queryRoleIdList(Map<String, Object> params);

    /**
     * selectListByMap
     *
     * @param params
     * @return
     */
    List<SysRoleEntity> selectListByMap(Map<String, Object> params);
}
