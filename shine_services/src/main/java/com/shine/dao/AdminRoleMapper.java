package com.shine.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.shine.dao.model.AdminRole;

public interface AdminRoleMapper extends BaseMapper<AdminRole> {
    int deleteByPrimaryKey(Long id);

 /*   int insert(AdminRole record);*/

    int insertSelective(AdminRole record);

    AdminRole selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(AdminRole record);

    int updateByPrimaryKey(AdminRole record);
}