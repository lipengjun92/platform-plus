/*
 * 项目名称:platform-plus
 * 类名称:ScheduleJobController.java
 * 包名称:com.platform.modules.job.controller
 *
 * 修改履历:
 *      日期                修正者      主要内容
 *      2018/11/21 16:04    李鹏军      初版完成
 *
 * Copyright (c) 2019-2019 微同软件
 */
package com.platform.modules.job.controller;

import com.platform.common.annotation.SysLog;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.platform.common.utils.RestResponse;
import com.platform.common.validator.ValidatorUtils;
import com.platform.modules.job.entity.ScheduleJobEntity;
import com.platform.modules.job.service.ScheduleJobService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * 定时任务
 *
 * @author 李鹏军
 */
@RestController
@RequestMapping("/sys/schedule")
public class ScheduleJobController {
    @Autowired
    private ScheduleJobService scheduleJobService;

    /**
     * 定时任务列表
     */
    @GetMapping("/list")
    @RequiresPermissions("sys:schedule:list")
    public RestResponse list(@RequestParam Map<String, Object> params) {
        Page page = scheduleJobService.queryPage(params);

        return RestResponse.success().put("page", page);
    }

    /**
     * 定时任务信息
     */
    @GetMapping("/info/{jobId}")
    @RequiresPermissions("sys:schedule:info")
    public RestResponse info(@PathVariable("jobId") String jobId) {
        ScheduleJobEntity schedule = scheduleJobService.getById(jobId);

        return RestResponse.success().put("schedule", schedule);
    }

    /**
     * 保存定时任务
     */
    @SysLog("保存定时任务")
    @PostMapping("/save")
    @RequiresPermissions("sys:schedule:save")
    public RestResponse save(@RequestBody ScheduleJobEntity scheduleJob) {
        ValidatorUtils.validateEntity(scheduleJob);

        scheduleJobService.save(scheduleJob);

        return RestResponse.success();
    }

    /**
     * 修改定时任务
     */
    @SysLog("修改定时任务")
    @PostMapping("/update")
    @RequiresPermissions("sys:schedule:update")
    public RestResponse update(@RequestBody ScheduleJobEntity scheduleJob) {
        ValidatorUtils.validateEntity(scheduleJob);

        scheduleJobService.update(scheduleJob);

        return RestResponse.success();
    }

    /**
     * 删除定时任务
     */
    @SysLog("删除定时任务")
    @PostMapping("/delete")
    @RequiresPermissions("sys:schedule:delete")
    public RestResponse delete(@RequestBody String[] jobIds) {
        scheduleJobService.deleteBatch(jobIds);

        return RestResponse.success();
    }

    /**
     * 立即执行任务
     */
    @SysLog("立即执行任务")
    @PostMapping("/run")
    @RequiresPermissions("sys:schedule:run")
    public RestResponse run(@RequestBody String[] jobIds) {
        scheduleJobService.run(jobIds);

        return RestResponse.success();
    }

    /**
     * 暂停定时任务
     */
    @SysLog("暂停定时任务")
    @PostMapping("/pause")
    @RequiresPermissions("sys:schedule:pause")
    public RestResponse pause(@RequestBody String[] jobIds) {
        scheduleJobService.pause(jobIds);

        return RestResponse.success();
    }

    /**
     * 恢复定时任务
     */
    @SysLog("恢复定时任务")
    @PostMapping("/resume")
    @RequiresPermissions("sys:schedule:resume")
    public RestResponse resume(@RequestBody String[] jobIds) {
        scheduleJobService.resume(jobIds);

        return RestResponse.success();
    }

}
