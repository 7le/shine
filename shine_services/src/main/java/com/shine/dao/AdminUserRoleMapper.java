package com.shine.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.shine.dao.model.AdminUserRole;

public interface AdminUserRoleMapper extends BaseMapper<AdminUserRole> {
    int deleteByPrimaryKey(Long id);

/*    int insert(AdminUserRole record);*/

    int insertSelective(AdminUserRole record);

    AdminUserRole selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(AdminUserRole record);

    int updateByPrimaryKey(AdminUserRole record);
}