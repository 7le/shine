package com.shine.service;

import com.shine.bean.ShineMenu;

import java.util.List;

/**
 * Created by hq on 2017/2/23.
 */
public interface AdminPermissionService {

    List<ShineMenu> selectMenuByUserId( Long userId );

}
