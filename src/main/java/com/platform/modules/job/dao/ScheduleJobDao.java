/*
 * 项目名称:platform-plus
 * 类名称:ScheduleJobDao.java
 * 包名称:com.platform.modules.job.dao
 *
 * 修改履历:
 *     日期                       修正者        主要内容
 *     2019-01-22 10:13:48        李鹏军     初版做成
 *
 * Copyright (c) 2018-2019 微同软件
 */
package com.platform.modules.job.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.platform.modules.job.entity.ScheduleJobEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * 定时任务Dao
 *
 * @author 李鹏军
 * @date 2019-01-22 10:13:48
 */
@Mapper
public interface ScheduleJobDao extends BaseMapper<ScheduleJobEntity> {

    /**
     * 批量更新状态
     *
     * @param map
     * @return
     */
    int updateBatch(Map<String, Object> map);

    /**
     * 自定义分页查询
     *
     * @param page
     * @param params
     * @return
     */
    List<ScheduleJobEntity> selectScheduleJobPage(Pagination page, Map<String, Object> params);
}
