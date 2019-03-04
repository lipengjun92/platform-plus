package com.platform.modules.sys.service;

import com.baomidou.mybatisplus.service.IService;
import com.platform.modules.sys.entity.SysRoleOrgEntity;

import java.util.List;


/**
 * 角色与机构对应关系
 *
 * @author lipengjun
 * @date 2017年9月18日 上午9:18:38
 */
public interface SysRoleOrgService extends IService<SysRoleOrgEntity> {

    /**
     * 保存或更新
     *
     * @param roleId
     * @param orgNoList
     */
    void saveOrUpdate(String roleId, List<String> orgNoList);

    /**
     * 根据角色ID，获取机构ID列表
     *
     * @param roleId
     * @return
     */
    List<String> queryOrgNoList(String roleId);

    /**
     * 根据用户ID获取权限机构列表
     *
     * @param userId
     * @return
     */
    String queryOrgNoListByUserId(String userId);

    /**
     * 根据角色ID数组，批量删除
     *
     * @param roleIds
     * @return
     */
    int deleteBatch(String[] roleIds);
}
