/*
 * 项目名称:platform-plus
 * 类名称:SysSmsLogController.java
 * 包名称:com.platform.modules.sys.controller
 *
 * 修改履历:
 *     日期                       修正者        主要内容
 *     2019-02-12 09:51:15        李鹏军     初版做成
 *
 * Copyright (c) 2018-2019 微同软件
 */
package com.platform.modules.sys.controller;

import com.alibaba.fastjson.JSON;
import com.platform.common.annotation.SysLog;
import com.platform.common.utils.Constant;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.platform.common.utils.RestResponse;
import com.platform.modules.sys.entity.SmsConfig;
import com.platform.modules.sys.entity.SysSmsLogEntity;
import com.platform.modules.sys.service.SysConfigService;
import com.platform.modules.sys.service.SysSmsLogService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * 短信发送日志Controller
 *
 * @author 李鹏军
 * @date 2019-02-12 09:51:15
 */
@RestController
@RequestMapping("sys/smslog")
public class SysSmsLogController extends AbstractController {
    @Autowired
    private SysSmsLogService sysSmsLogService;
    @Autowired
    private SysConfigService sysConfigService;

    /**
     * 查看所有列表
     */
    @RequestMapping("/queryAll")
    @RequiresPermissions("sys:smslog:list")
    public RestResponse queryAll(@RequestParam Map<String, Object> params) {
        List<SysSmsLogEntity> list = sysSmsLogService.queryAll(params);

        return RestResponse.success().put("list", list);
    }

    /**
     * 分页查询
     */
    @GetMapping("/list")
    @RequiresPermissions("sys:smslog:list")
    public RestResponse list(@RequestParam Map<String, Object> params) {
        Page page = sysSmsLogService.queryPage(params);

        return RestResponse.success().put("page", page);
    }

    /**
     * 查看信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("sys:smslog:info")
    public RestResponse info(@PathVariable("id") String id) {
        SysSmsLogEntity sysSmsLog = sysSmsLogService.getById(id);

        return RestResponse.success().put("smslog", sysSmsLog);
    }

    /**
     * 保存
     */
    @SysLog("保存短信发送记录")
    @RequestMapping("/save")
    @RequiresPermissions("sys:smslog:save")
    public RestResponse save(@RequestBody SysSmsLogEntity sysSmsLog) {

        sysSmsLogService.add(sysSmsLog);

        return RestResponse.success();
    }

    /**
     * 修改
     */
    @SysLog("修改短信发送记录")
    @RequestMapping("/update")
    @RequiresPermissions("sys:smslog:update")
    public RestResponse update(@RequestBody SysSmsLogEntity sysSmsLog) {

        sysSmsLogService.update(sysSmsLog);

        return RestResponse.success();
    }

    /**
     * 删除
     */
    @SysLog("删除短信发送记录")
    @RequestMapping("/delete")
    @RequiresPermissions("sys:smslog:delete")
    public RestResponse delete(@RequestBody String[] ids) {
        sysSmsLogService.deleteBatch(ids);

        return RestResponse.success();
    }

    /**
     * 短信配置信息
     */
    @RequestMapping("/config")
    @RequiresPermissions("sys:smslog:config")
    public RestResponse config() {
        SmsConfig config = sysConfigService.getConfigObject(Constant.SMS_CONFIG_KEY, SmsConfig.class);

        return RestResponse.success().put("config", config);
    }

    /**
     * 保存短信配置信息
     */
    @SysLog("保存短信配置信息")
    @RequiresPermissions("sys:smslog:config")
    @RequestMapping("/saveConfig")
    public RestResponse saveConfig(@RequestBody SmsConfig config) {
        sysConfigService.updateValueByKey(Constant.SMS_CONFIG_KEY, JSON.toJSONString(config));
        return RestResponse.success();
    }

    /**
     * 发送短信
     */
    @SysLog("系统调用发送短信")
    @RequiresPermissions("sys:smslog:send")
    @RequestMapping("/sendSms")
    @ResponseBody
    public RestResponse sendSms(@RequestBody SysSmsLogEntity smsLog) {
        SysSmsLogEntity sysSmsLogEntity = sysSmsLogService.sendSms(smsLog);
        return RestResponse.success().put("result", sysSmsLogEntity);
    }
}
