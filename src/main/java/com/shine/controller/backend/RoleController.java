package com.shine.controller.backend;

import com.shine.constant.Backend;
import com.shine.dao.model.AdminPermission;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * 角色管理相关操作
 * Created by hq on 2017/2/7.
 */
@Controller
public class RoleController extends BackendController{

    /**
     * 获取权限树
     * @return
     */
    @RequestMapping(value = Backend.URL.ROLE.ROLETREE)
    @ResponseBody
    public String tree(){
        //List<AdminPermission> list = adminPermissionMapper.selectList(null);
        return "";
    }
}
