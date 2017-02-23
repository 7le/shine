package com.shine.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.shine.bean.ShineMenu;
import com.shine.dao.model.AdminPermission;
import org.apache.ibatis.annotations.Param;

import java.util.List;

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

    List<ShineMenu> selectMenuByUserId(@Param("userId") Long userId, @Param("pid") Long pid);

    List<AdminPermission> selectAllByUserId(@Param("userId") Long userId);

}