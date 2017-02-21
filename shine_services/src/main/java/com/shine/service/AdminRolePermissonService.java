package com.shine.service;

import java.util.List;

/**
 * Created by hq on 2017/2/21 0021.
 */
public interface AdminRolePermissonService {
    /**
     * <p>
     * 判断是否存在角色对应的权限
     * </p>
     *
     * @param permissionId
     *            权限ID
     * @return
     */
    boolean existRolePermission(Long permissionId);

    /**
     * 根据角色ID获取对应的所有关联权限的ID
     * @param id
     * @return
     */
    List<Long> selectPermissionIdsByRoleId(Long id);
}
