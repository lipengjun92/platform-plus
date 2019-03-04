package com.platform.modules.gen.service;

import com.baomidou.mybatisplus.service.IService;
import com.platform.common.utils.PageUtils;
import com.platform.modules.gen.entity.ColumnEntity;
import com.platform.modules.gen.entity.ResultMapEntity;

import java.util.List;
import java.util.Map;

/**
 * 代码生成器
 *
 * @author lipengjun
 * @email 939961241@qq.com
 * @date 2016年12月19日 下午3:33:38
 */
public interface SysGeneratorService extends IService<ResultMapEntity> {
    /**
     * 查询分页信息
     *
     * @param params
     * @return
     */
    PageUtils queryPage(Map<String, Object> params);

    /**
     * queryTable
     *
     * @param tableName
     * @return
     */
    ResultMapEntity queryTable(String tableName);

    /**
     * queryColumns
     *
     * @param tableName
     * @return
     */
    List<ColumnEntity> queryColumns(String tableName);

    /**
     * 生成代码
     *
     * @param tableNames
     * @param projectName
     * @param packageName
     * @param author
     * @return
     */
    byte[] generatorCode(String[] tableNames, String projectName, String packageName, String author);
}
