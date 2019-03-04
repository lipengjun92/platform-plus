/*
 * 项目名称:platform-plus
 * 类名称:SysUserService.java
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
import com.platform.modules.sys.entity.SysUserEntity;

import java.util.List;
import java.util.Map;

/**
 * 系统用户
 *
 * @author 李鹏军
 */
public interface SysUserService extends IService<SysUserEntity> {

    /**
     * 查询所有
     *
     * @param params
     * @return
     */
    List<SysUserEntity> queryAll(Map<String, Object> params);

    /**
     * queryPage
     *
     * @param params
     * @return
     */
    PageUtils queryPage(Map<String, Object> params);

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
     * 保存用户
     *
     * @param user
     * @param params
     */
    void save(SysUserEntity user, Map<String, Object> params);

    /**
     * 修改用户
     *
     * @param user
     * @param params
     */
    void update(SysUserEntity user, Map<String, Object> params);

    /**
     * 删除用户
     *
     * @param userIds
     */
    void deleteBatch(String[] userIds);

    /**
     * 修改密码
     *
     * @param userId
     * @param password
     * @param newPassword
     * @return
     */
    boolean updatePassword(String userId, String password, String newPassword);

    /**
     * 重置密码
     *
     * @param userIds
     * @return
     */
    boolean resetPw(String[] userIds);

    /**
     * 根据userId查询一个
     *
     * @param userId
     * @return
     */
    SysUserEntity selectEntityById(String userId);
}
