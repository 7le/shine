package com.shine.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.shine.dao.model.AdminRolePermission;

public interface AdminRolePermissionMapper extends BaseMapper<AdminRolePermission> {
    int deleteByPrimaryKey(Long id);

/*    int insert(AdminRolePermission record);*/

    int insertSelective(AdminRolePermission record);

    AdminRolePermission selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(AdminRolePermission record);

    int updateByPrimaryKey(AdminRolePermission record);
}