package com.shine.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.shine.dao.model.AdminUser;
import org.apache.ibatis.annotations.Param;

public interface AdminUserMapper extends BaseMapper<AdminUser> {
    int deleteByPrimaryKey(Long id);

/*    int insert(AdminUser record);*/

    int insertSelective(AdminUser record);

    AdminUser selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(AdminUser record);

    int updateByPrimaryKey(AdminUser record);

    /**
     * 根据用户名查找管理员
     */
    AdminUser selectByLoginName(@Param("loginName")String loginName);

    /**
     * 根据用户名密码查找管理员
     */
    AdminUser selectByLoginNameAndPassword(@Param("loginName")String loginName,@Param("password")String password);
}