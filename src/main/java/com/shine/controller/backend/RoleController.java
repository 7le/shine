package com.shine.controller.backend;

import com.alibaba.fastjson.JSONObject;
import com.shine.constant.Backend;
import com.shine.dao.model.AdminPermission;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    public String tree(
            @RequestParam(value="roleId",required = true)  Long roleId){
        List<AdminPermission> list = adminPermissionMapper.selectList(null);
        List<Long> roleRightList = adminRolePermissonService.selectPermissionIdsByRoleId(roleId);
        List<Map<String,String>> rightList = new ArrayList<Map<String,String>>();
        for(AdminPermission bean : list){
            Map<String,String> map = new HashMap<String,String>();
            map.put("id", bean.getId().toString());
            map.put("pId", bean.getPid().toString());
            map.put("name", bean.getTitle());
            //默认展开树
            map.put( "open", "true");
            //如果角色已有该权限，则默认选中
            if(roleRightList.contains(bean.getId())){
                map.put( "checked", "true");
            }
            rightList.add(map);
        }
        return JSONObject.toJSONString(rightList);
    }
}
