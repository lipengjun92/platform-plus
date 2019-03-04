/*
 * 项目名称:platform-plus
 * 类名称:Query.java
 * 包名称:com.platform.common.utils
 *
 * 修改履历:
 *      日期                修正者      主要内容
 *      2018/11/21 16:04    李鹏军      初版完成
 *
 * Copyright (c) 2019-2019 微同软件
 */
package com.platform.common.utils;

import com.baomidou.mybatisplus.plugins.Page;
import com.platform.common.xss.SqlFilter;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 查询参数
 *
 * @author 李鹏军
 */
public class Query<T> extends LinkedHashMap<String, Object> {
    private static final long serialVersionUID = 1L;
    /**
     * mybatis-plus分页参数
     */
    private Page<T> page;
    /**
     * 当前页码
     */
    private int currPage = 1;
    /**
     * 每页条数
     */
    private int limit = 10;

    public static final String ASC = "asc";

    public Query(Map<String, Object> params) {

        String strPage = "page";
        String strLimit = "limit";
        this.putAll(params);

        //分页参数
        if (params.get(strPage) != null) {
            currPage = Integer.parseInt((String) params.get("page"));
        }
        if (params.get(strLimit) != null) {
            limit = Integer.parseInt((String) params.get("limit"));
        }

        this.put("offset", (currPage - 1) * limit);
        this.put("page", currPage);
        this.put("limit", limit);

        //防止SQL注入（因为sidx是通过拼接SQL实现排序的，会有SQL注入风险）
        String sidx = SqlFilter.sqlInject((String) params.get("sidx"));
        //默认升序
        Boolean asc = true;
        if (!StringUtils.isNullOrEmpty(params.get(ASC))) {
            asc = (Boolean) params.get("asc");
        }
        //mybatis-plus分页
        this.page = new Page<>(currPage, limit);

        //排序
        if (StringUtils.isNotBlank(sidx)) {
            this.page.setOrderByField(sidx);
            this.page.setAsc(asc);
        }

    }

    public Page<T> getPage() {
        return page;
    }

    public int getCurrPage() {
        return currPage;
    }

    public int getLimit() {
        return limit;
    }
}
