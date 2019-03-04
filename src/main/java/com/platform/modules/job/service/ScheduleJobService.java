/*
 * 项目名称:platform-plus
 * 类名称:ScheduleJobService.java
 * 包名称:com.platform.modules.job.service
 *
 * 修改履历:
 *      日期                修正者      主要内容
 *      2018/11/21 16:04    李鹏军      初版完成
 *
 * Copyright (c) 2019-2019 微同软件
 */
package com.platform.modules.job.service;

import com.baomidou.mybatisplus.service.IService;
import com.platform.common.utils.PageUtils;
import com.platform.modules.job.entity.ScheduleJobEntity;

import java.util.Map;

/**
 * 定时任务
 *
 * @author 李鹏军
 */
public interface ScheduleJobService extends IService<ScheduleJobEntity> {

    /**
     * 获取分页数据
     *
     * @param params
     * @return
     */
    PageUtils queryPage(Map<String, Object> params);

    /**
     * 保存定时任务
     *
     * @param scheduleJob
     */
    void save(ScheduleJobEntity scheduleJob);

    /**
     * 更新定时任务
     *
     * @param scheduleJob
     */
    void update(ScheduleJobEntity scheduleJob);

    /**
     * 批量删除定时任务
     *
     * @param jobIds
     */
    void deleteBatch(String[] jobIds);

    /**
     * 批量更新定时任务状态
     *
     * @param jobIds
     * @param status
     * @return
     */
    int updateBatch(String[] jobIds, int status);

    /**
     * 立即执行
     *
     * @param jobIds
     */
    void run(String[] jobIds);

    /**
     * 暂停运行
     *
     * @param jobIds
     */
    void pause(String[] jobIds);

    /**
     * 恢复运行
     *
     * @param jobIds
     */
    void resume(String[] jobIds);
}
