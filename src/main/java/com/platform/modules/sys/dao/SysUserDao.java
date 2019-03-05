/*
 * 项目名称:platform-plus
 * 类名称:SysUserDao.java
 * 包名称:com.platform.modules.sys.dao
 *
 * 修改履历:
 *      日期                修正者      主要内容
 *      2018/11/21 16:04    李鹏军      初版完成
 *
 * Copyright (c) 2019-2019 微同软件
 */
package com.platform.modules.sys.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.platform.modules.sys.entity.SysUserEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * 系统用户
 *
 * @author 李鹏军
 */
@Mapper
public interface SysUserDao extends BaseMapper<SysUserEntity> {

    /**
     * 查询用户的所有权限
     *
     * @param userId
     * @return
     */
    List<String> queryAllPerms(String userId);

    /**
     * 查询用户的所有菜单ID
     *
     * @param userId
     * @return
     */
    List<String> queryAllMenuId(String userId);

    /**
     * 根据用户名，查询系统用户
     *
     * @param userName
     * @return
     */
    SysUserEntity queryByUserName(String userName);

    /**
     * 分页查询
     *
     * @param page
     * @param params
     * @return
     */
    List<SysUserEntity> selectListPage(Page<SysUserEntity> page, @Param("params") Map<String, Object> params);

    /**
     * 查询所有
     *
     * @param params
     * @return
     */
    List<SysUserEntity> selectListPage(@Param("params") Map<String, Object> params);

    /**
     * 根据userId连表查询一个
     *
     * @param userId
     * @return
     */
    SysUserEntity selectEntityById(String userId);
}
