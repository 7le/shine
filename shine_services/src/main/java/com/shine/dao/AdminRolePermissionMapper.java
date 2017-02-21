package com.shine.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.shine.dao.model.AdminRolePermission;

import java.util.List;

public interface AdminRolePermissionMapper extends BaseMapper<AdminRolePermission> {
    int deleteByPrimaryKey(Long id);

/*    int insert(AdminRolePermission record);*/

    int insertSelective(AdminRolePermission record);

    AdminRolePermission selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(AdminRolePermission record);

    int updateByPrimaryKey(AdminRolePermission record);

    /**
     * 根据角色ID获取对应的所有关联权限的ID
     * @param id 角色Id
     * @return
     */
    List<Long> selectPermissionIdsByRoleId(Long id);
}