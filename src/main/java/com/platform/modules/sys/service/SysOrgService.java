/*
 * 项目名称:platform-plus
 * 类名称:SysOrgService.java
 * 包名称:com.platform.modules.sys.service
 *
 * 修改履历:
 *     日期                       修正者        主要内容
 *     2019-01-21 11:29:22        李鹏军     初版做成
 *
 * Copyright (c) 2018-2019 微同软件
 */
package com.platform.modules.sys.service;

import com.baomidou.mybatisplus.service.IService;
import com.platform.common.utils.PageUtils;
import com.platform.modules.sys.entity.SysOrgEntity;

import java.util.List;
import java.util.Map;

/**
 * 组织机构Service接口
 *
 * @author 李鹏军
 * @date 2019-01-21 11:29:22
 */
public interface SysOrgService extends IService<SysOrgEntity> {

    /**
     * 查询所有列表
     *
     * @param params
     * @return
     */
    List<SysOrgEntity> queryAll(Map<String, Object> params);

    /**
     * 查询分页信息
     *
     * @param params
     * @return
     */
    PageUtils queryPage(Map<String, Object> params);

    /**
     * 保存实体
     *
     * @param sysOrg 实体
     * @return 保存条数
     */
    void save(SysOrgEntity sysOrg);

    /**
     * 根据主键更新实体
     *
     * @param sysOrg 实体
     * @return 更新条数
     */
    void update(SysOrgEntity sysOrg);

    /**
     * 根据主键删除
     *
     * @param orgNo
     * @return 删除条数
     */
    void delete(String orgNo);

    /**
     * 根据主键批量删除
     *
     * @param orgNos
     * @return 删除条数
     */
    void deleteBatch(String[] orgNos);

    /**
     * 根据OrgNo查询子机构
     *
     * @param orgNo
     * @return
     */
    List<SysOrgEntity> queryListByOrgNo(String orgNo);
}
