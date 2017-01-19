package com.shine.dao;

import com.shine.dao.model.AdminSysLog;

public interface AdminSysLogMapper {
    int deleteByPrimaryKey(Long id);

    int insert(AdminSysLog record);

    int insertSelective(AdminSysLog record);

    AdminSysLog selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(AdminSysLog record);

    int updateByPrimaryKey(AdminSysLog record);
}