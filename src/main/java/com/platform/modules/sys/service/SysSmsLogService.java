/*
 * 项目名称:platform-plus
 * 类名称:SysSmsLogService.java
 * 包名称:com.platform.modules.sys.service
 *
 * 修改履历:
 *     日期                       修正者        主要内容
 *     2019-02-12 09:51:15        李鹏军     初版做成
 *
 * Copyright (c) 2018-2019 微同软件
 */
package com.platform.modules.sys.service;

import com.baomidou.mybatisplus.service.IService;
import com.platform.common.utils.PageUtils;
import com.platform.modules.sys.entity.SysSmsLogEntity;

import java.util.List;
import java.util.Map;

/**
 * 短信发送日志Service接口
 *
 * @author 李鹏军
 * @date 2019-02-12 09:51:15
 */
public interface SysSmsLogService extends IService<SysSmsLogEntity> {

    /**
     * 查询所有列表
     *
     * @param params
     * @return
     */
    List<SysSmsLogEntity> queryAll(Map<String, Object> params);

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
     * @param sysSmsLog 实体
     * @return 保存条数
     */
    void save(SysSmsLogEntity sysSmsLog);

    /**
     * 根据主键更新实体
     *
     * @param sysSmsLog 实体
     * @return 更新条数
     */
    void update(SysSmsLogEntity sysSmsLog);

    /**
     * 根据主键删除
     *
     * @param id
     * @return 删除条数
     */
    void delete(String id);

    /**
     * 根据主键批量删除
     *
     * @param ids
     * @return 删除条数
     */
    void deleteBatch(String[] ids);

    /**
     * 发送短信
     *
     * @param smsLog
     * @return
     */
    SysSmsLogEntity sendSms(SysSmsLogEntity smsLog);
}
