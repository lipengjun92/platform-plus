/*
 * 项目名称:platform-plus
 * 类名称:SysUserTokenService.java
 * 包名称:com.platform.modules.sys.service
 *
 * 修改履历:
 *      日期                修正者      主要内容
 *      2018/11/21 16:04    李鹏军      初版完成
 *
 * Copyright (c) 2019-2019 微同软件
 */
package com.platform.modules.sys.service;

import com.baomidou.mybatisplus.service.IService;
import com.platform.common.utils.PageUtils;
import com.platform.common.utils.RestResponse;
import com.platform.modules.sys.entity.SysUserTokenEntity;

import java.util.Map;

/**
 * 用户Token
 *
 * @author 李鹏军
 */
public interface SysUserTokenService extends IService<SysUserTokenEntity> {

    /**
     * 生成token
     *
     * @param userId
     * @return
     */
    RestResponse createToken(String userId);

    /**
     * 退出，修改token值
     *
     * @param userId
     */
    void logout(String userId);

    /**
     * 分页查询
     *
     * @param params
     * @return
     */
    PageUtils queryPage(Map<String, Object> params);

    /**
     * 根据主键删除
     *
     * @param userId
     * @return 删除条数
     */
    void delete(String userId);

    /**
     * 批量下线用户(删除用户token记录)
     *
     * @param userIds
     * @return 删除条数
     */
    void offlineBatch(String[] userIds);
}
