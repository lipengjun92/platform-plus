/*
 * 项目名称:platform-plus
 * 类名称:SysDictServiceImpl.java
 * 包名称:com.platform.modules.sys.service.impl
 *
 * 修改履历:
 *     日期                       修正者        主要内容
 *     2019-01-15 11:42:20        李鹏军     初版做成
 *
 * Copyright (c) 2018-2019 微同软件
 */
package com.platform.modules.sys.service.impl;

import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.platform.common.annotation.RedisCache;
import com.platform.common.utils.JedisUtil;
import com.platform.common.utils.PageUtils;
import com.platform.common.utils.Query;
import com.platform.modules.sys.dao.SysDictDao;
import com.platform.modules.sys.entity.SysDictEntity;
import com.platform.modules.sys.service.SysDictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * 数据字典Service实现类
 *
 * @author 李鹏军
 * @date 2019-01-15 11:42:20
 */
@Service("sysDictService")
public class SysDictServiceImpl extends ServiceImpl<SysDictDao, SysDictEntity> implements SysDictService {
    @Autowired
    JedisUtil jedisUtil;

    @Override
    @RedisCache
    public List<SysDictEntity> queryAll(Map<String, Object> params) {
        return baseMapper.queryAll(params);
    }

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        //排序
        params.put("sidx", "d.sort");
        Page<SysDictEntity> page = new Query<SysDictEntity>(params).getPage();
        return new PageUtils(page.setRecords(baseMapper.selectDictPage(page, params)));
    }

    @Override
    public void save(SysDictEntity sysDict) {
        this.insert(sysDict);
        jedisUtil.delByClass(this.getClass().getName(), "queryAll");
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void update(SysDictEntity sysDict) {
        this.updateAllColumnById(sysDict);
        jedisUtil.delByClass(this.getClass().getName(), "queryAll");
    }

    @Override
    public void delete(String id) {
        this.deleteById(id);
        jedisUtil.delByClass(this.getClass().getName(), "queryAll");
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void deleteBatch(String[] ids) {
        this.deleteBatchIds(Arrays.asList(ids));
        jedisUtil.delByClass(this.getClass().getName(), "queryAll");
    }

    @Override
    public List<SysDictEntity> queryByCode(Map<String, Object> params) {
        return baseMapper.queryByCode(params);
    }
}
