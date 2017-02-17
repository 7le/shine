package com.shine.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.shine.dao.model.AdminPermission;
/**
 *
 * Permission 表数据服务层接口
 *
 */

public interface AdminPermissionMapper extends BaseMapper<AdminPermission> {
    int deleteByPrimaryKey(Long id);

/*    int insert(AdminPermission record);*/

    int insertSelective(AdminPermission record);

    AdminPermission selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(AdminPermission record);

    int updateByPrimaryKey(AdminPermission record);

}