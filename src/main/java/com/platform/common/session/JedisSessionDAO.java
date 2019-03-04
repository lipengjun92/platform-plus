/*
 * 项目名称:platform-plus
 * 类名称:JedisSessionDAO.java
 * 包名称:com.platform.common.session
 *
 * 修改履历:
 *      日期                修正者      主要内容
 *      2019/1/22 13:13    李鹏军      初版做成
 *
 * Copyright (c) 2019-2019 微同软件
 */
package com.platform.common.session;

import com.platform.common.utils.Constant;
import com.platform.common.utils.JedisUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.session.Session;
import org.apache.shiro.session.mgt.eis.EnterpriseCacheSessionDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;

/**
 * 自定义授权会话管理类
 *
 * @author 李鹏军
 */
@Slf4j
@Service
public class JedisSessionDAO extends EnterpriseCacheSessionDAO {

    @Autowired
    private JedisUtil jedisUtil;

    public JedisSessionDAO() {
        super();
    }

    /**
     * 创建session，保存到redis
     *
     * @param session
     * @return
     */
    @Override
    protected Serializable doCreate(Session session) {
        Serializable sessionId = super.doCreate(session);
        log.debug("创建session:{}", sessionId);

        jedisUtil.setObject(Constant.SESSION + session.getId().toString(), session);
        return sessionId;
    }

    /**
     * 获取session
     *
     * @param sessionId
     * @return
     */
    @Override
    protected Session doReadSession(Serializable sessionId) {
        log.debug("获取session:{}", sessionId);
        // 先从缓存中获取session，如果没有再去redis中获取
        Session session = super.doReadSession(sessionId);
        if (null == session) {
            session = (Session) jedisUtil.getObject(Constant.SESSION + sessionId.toString());
        }
        return session;
    }

    /**
     * 更新session的最后一次访问时间
     *
     * @param session
     */
    @Override
    protected void doUpdate(Session session) {
        log.debug("更新session:{}", session.getId());
        super.doUpdate(session);
        String key = Constant.SESSION + session.getId().toString();

        if (null == jedisUtil.getObject(key)) {
            return;
        }
        jedisUtil.setObject(key, session);
    }

    /**
     * 删除session
     *
     * @param session
     */
    @Override
    protected void doDelete(Session session) {
        log.debug("删除session:{}", session.getId());
        if (session == null || session.getId() == null) {
            return;
        }
        super.doDelete(session);
        jedisUtil.del(Constant.SESSION + session.getId().toString());
    }
}
