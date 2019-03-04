package com.platform.modules.gen.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.platform.modules.gen.entity.ColumnEntity;
import com.platform.modules.gen.entity.ResultMapEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * 代码生成器
 *
 * @author lipengjun
 * @email 939961241@qq.com
 * @date 2016年12月19日 下午3:32:04
 */
@Mapper
public interface SysGeneratorDao extends BaseMapper<ResultMapEntity> {

    /**
     * queryPage
     *
     * @param page
     * @param map
     * @return
     */
    List<ResultMapEntity> queryPage(Page<ResultMapEntity> page, Map<String, Object> map);

    /**
     * queryTable
     *
     * @param map
     * @return
     */
    ResultMapEntity queryTable(Map<String, Object> map);

    /**
     * queryColumns
     *
     * @param map
     * @return
     */
    List<ColumnEntity> queryColumns(Map<String, Object> map);
}
