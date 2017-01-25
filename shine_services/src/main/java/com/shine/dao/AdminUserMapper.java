package com.shine.dao;

import com.shine.dao.model.AdminUser;

public interface AdminUserMapper {
    int deleteByPrimaryKey(Long id);

    int insert(AdminUser record);

    int insertSelective(AdminUser record);

    AdminUser selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(AdminUser record);

    int updateByPrimaryKey(AdminUser record);

    /**
     * 根据用户名查找管理员
     */
    AdminUser selectByLoginName(String loginName);
}