/*
 * 项目名称:platform-plus
 * 类名称:SysUserTokenServiceImpl.java
 * 包名称:com.platform.modules.sys.service.impl
 *
 * 修改履历:
 *      日期                修正者      主要内容
 *      2018/11/21 16:04    李鹏军      初版完成
 *
 * Copyright (c) 2019-2019 微同软件
 */
package com.platform.modules.sys.service.impl;

import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.platform.common.utils.PageUtils;
import com.platform.common.utils.Query;
import com.platform.common.utils.RestResponse;
import com.platform.modules.sys.dao.SysUserTokenDao;
import com.platform.modules.sys.entity.SysUserTokenEntity;
import com.platform.modules.sys.oauth2.TokenGenerator;
import com.platform.modules.sys.service.SysUserTokenService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.Date;
import java.util.Map;

/**
 * @author 李鹏军
 */
@Service("sysUserTokenService")
public class SysUserTokenServiceImpl extends ServiceImpl<SysUserTokenDao, SysUserTokenEntity> implements SysUserTokenService {
    /**
     * 6小时后过期
     */
    private final static int EXPIRE = 3600 * 6;


    @Override
    public RestResponse createToken(String userId) {
        /**
         * 生成一个token
         */
        String token = TokenGenerator.generateValue();

        /**
         * 当前时间
         */
        Date now = new Date();
        /**
         * 过期时间
         */
        Date expireTime = new Date(now.getTime() + EXPIRE * 1000);

        /**
         * 判断是否生成过token
         */
        SysUserTokenEntity tokenEntity = this.selectById(userId);
        if (tokenEntity == null) {
            tokenEntity = new SysUserTokenEntity();
            tokenEntity.setUserId(userId);
            tokenEntity.setToken(token);
            tokenEntity.setUpdateTime(now);
            tokenEntity.setExpireTime(expireTime);

            //保存token
            this.insert(tokenEntity);
        } else {
            tokenEntity.setToken(token);
            tokenEntity.setUpdateTime(now);
            tokenEntity.setExpireTime(expireTime);

            //更新token
            this.updateById(tokenEntity);
        }

        RestResponse restResponse = RestResponse.success().put("token", token).put("expire", EXPIRE);

        return restResponse;
    }

    @Override
    public void logout(String userId) {
        //生成一个token
        String token = TokenGenerator.generateValue();

        //修改token
        SysUserTokenEntity tokenEntity = new SysUserTokenEntity();
        tokenEntity.setUserId(userId);
        tokenEntity.setToken(token);
        this.updateById(tokenEntity);
    }

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<SysUserTokenEntity> page = new Query<SysUserTokenEntity>(params).getPage();

        params.put("nowDate", new Date());
        return new PageUtils(page.setRecords(baseMapper.selectSysUserTokenPage(page, params)));
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void delete(String userId) {
        this.deleteById(userId);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void offlineBatch(String[] userIds) {
        this.deleteBatchIds(Arrays.asList(userIds));
    }
}
