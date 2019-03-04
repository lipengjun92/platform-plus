/*
 * 项目名称:platform-plus
 * 类名称:SysOrgDao.java
 * 包名称:com.platform.modules.sys.dao
 *
 * 修改履历:
 *     日期                       修正者        主要内容
 *     2019-01-22 11:11:13        李鹏军     初版做成
 *
 * Copyright (c) 2018-2019 微同软件
 */
package com.platform.modules.sys.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.platform.modules.sys.entity.SysOrgEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * 组织机构Dao
 *
 * @author 李鹏军
 * @date 2019-01-22 11:11:13
 */
@Mapper
public interface SysOrgDao extends BaseMapper<SysOrgEntity> {

    /**
     * 查询存在的最大ID
     *
     * @param orgNo
     * @return
     */
    String queryMaxIdByParentNo(String orgNo);

    /**
     * 自定义分页查询
     *
     * @param page
     * @param params
     * @return
     */
    List<SysOrgEntity> selectSysOrgPage(Pagination page, Map<String, Object> params);

    /**
     * 查询所有列表
     *
     * @param params
     * @return
     */
    List<SysOrgEntity> queryAll(Map<String, Object> params);

    /**
     * 根据orgNo查询所有下级列表
     *
     * @param orgNo
     * @return
     */
    List<SysOrgEntity> selectChildrensByOrgNo(String orgNo);
}
