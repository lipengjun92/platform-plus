/*
 * 项目名称:platform-plus
 * 类名称:ShiroService.java
 * 包名称:com.platform.modules.sys.service
 *
 * 修改履历:
 *      日期                修正者      主要内容
 *      2018/11/21 16:04    李鹏军      初版完成
 *
 * Copyright (c) 2019-2019 微同软件
 */
package com.platform.modules.sys.service;

import com.platform.modules.sys.entity.SysUserEntity;
import com.platform.modules.sys.entity.SysUserTokenEntity;

import java.util.Set;

/**
 * shiro相关接口
 *
 * @author 李鹏军
 */
public interface ShiroService {
    /**
     * 获取用户权限列表
     *
     * @param userId
     * @return
     */
    Set<String> getUserPermissions(String userId);

    /**
     * 根据token获取用户
     *
     * @param token
     * @return
     */
    SysUserTokenEntity queryByToken(String token);

    /**
     * 根据用户ID，查询用户
     *
     * @param userId
     * @return
     */
    SysUserEntity queryUser(String userId);
}
