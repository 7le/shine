package com.shine.service.impl;

import com.shine.service.AdminRolePermissonService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by hq on 2017/2/21 0021.
 */
@Service
public class AdminRolePermissonServiceImpl extends BaseServiceImpl implements AdminRolePermissonService {
    @Override
    public boolean existRolePermission(Long permissionId) {
        return false;
    }

    @Override
    public List<Long> selectPermissionIdsByRoleId(Long id) {
        return adminRolePermissionMapper.selectPermissionIdsByRoleId(id);
    }
}
