/*
 * 项目名称:platform-plus
 * 类名称:SysUserTokenDao.java
 * 包名称:com.platform.modules.sys.dao
 *
 * 修改履历:
 *      日期                修正者      主要内容
 *      2018/11/21 16:04    李鹏军      初版完成
 *
 * Copyright (c) 2019-2019 微同软件
 */
package com.platform.modules.sys.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.platform.modules.sys.entity.SysUserTokenEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * 系统用户Token
 *
 * @author 李鹏军
 */
@Mapper
public interface SysUserTokenDao extends BaseMapper<SysUserTokenEntity> {

    /**
     * 根据token获取用户
     *
     * @param token
     * @return
     */
    SysUserTokenEntity queryByToken(String token);

    /**
     * 分页查询
     *
     * @param page
     * @param params
     * @return
     */
    List<SysUserTokenEntity> selectSysUserTokenPage(Pagination page, Map<String, Object> params);
}
