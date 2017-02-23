package com.shine.service.impl;

import com.shine.bean.ShineMenu;
import com.shine.service.AdminPermissionService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hq on 2017/2/23.
 */
@Service
public class AdminPermissionServiceImpl extends BaseServiceImpl implements AdminPermissionService{

    @Override
    public List<ShineMenu> selectMenuByUserId(Long userId) {
        List<ShineMenu> perList = adminPermissionMapper.selectMenuByUserId(userId, 0L);
        if (perList == null || perList.isEmpty()) {
            return null;
        }
        List<ShineMenu> shineMenus = new ArrayList<ShineMenu>();
        for (ShineMenu mv : perList) {
            mv.setShineMenus(adminPermissionMapper.selectMenuByUserId(userId, mv.getId()));
            shineMenus.add(mv);
        }
        return shineMenus;
    }
}
