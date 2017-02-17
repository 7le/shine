package com.shine.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.shine.dao.model.AdminSysLog;

public interface AdminSysLogMapper extends BaseMapper<AdminSysLog> {
    int deleteByPrimaryKey(Long id);

/*    int insert(AdminSysLog record);*/

    int insertSelective(AdminSysLog record);

    AdminSysLog selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(AdminSysLog record);

    int updateByPrimaryKey(AdminSysLog record);
}