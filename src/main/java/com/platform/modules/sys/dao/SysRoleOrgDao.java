/*
 * 项目名称:platform-plus
 * 类名称:SysRoleOrgDao.java
 * 包名称:com.platform.modules.sys.dao
 *
 * 修改履历:
 *     日期                       修正者        主要内容
 *     2019-01-21 17:20:07        李鹏军     初版做成
 *
 * Copyright (c) 2018-2019 微同软件
 */
package com.platform.modules.sys.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.platform.modules.sys.entity.SysRoleOrgEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 角色与机构对应关系Dao
 *
 * @author 李鹏军
 * @date 2019-01-21 17:20:07
 */
@Mapper
public interface SysRoleOrgDao extends BaseMapper<SysRoleOrgEntity> {

    /**
     * 删除根据角色Id
     *
     * @param roleId
     * @return
     */
    int deleteByRoleId(String roleId);

    /**
     * 根据角色ID，获取机构ID列表
     *
     * @param roleId
     * @return
     */
    List<String> queryOrgNoList(String roleId);

    /**
     * 根据用户ID获取权限机构列表
     *
     * @param userId
     * @return
     */
    List<String> queryOrgNoListByUserId(String userId);

    /**
     * offlineBatch
     *
     * @param roleIds
     * @return
     */
    int deleteBatch(String[] roleIds);
}
