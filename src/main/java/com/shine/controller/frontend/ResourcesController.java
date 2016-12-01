package com.shine.controller.frontend;

import com.shine.controller.BaseController;
import net.shine.mongodb.entity.InfoBean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by hq on 2016/11/29.
 * 资源接口 rest
 */

@Controller
@RequestMapping(value = "/res")
public class ResourcesController extends BaseController{

    @RequestMapping(value="/listView",method=RequestMethod.GET)
    public ModelAndView getListView(HttpServletRequest request,
                                    @RequestParam(defaultValue = "0",value = "page")Integer pageNum,
                                    @RequestParam(defaultValue = "10",value = "rows") Integer pageSize) throws Exception {
        ModelAndView modelAndView = new ModelAndView("list.jsp");

        return modelAndView;

    }

    @RequestMapping(value="/list",method=RequestMethod.GET)
    public ModelAndView getProducts(HttpServletRequest request,
                                    @RequestParam(defaultValue = "0",value = "page")Integer pageNum,
                                    @RequestParam(defaultValue = "10",value = "rows") Integer pageSize) throws Exception {
        ModelAndView modelAndView = new ModelAndView("list.jsp");

        modelAndView.addObject("res",resourcesService.page(null,pageNum,pageSize));
        return modelAndView;

    }

    @RequestMapping(value="/info/{sid}",method= RequestMethod.GET)
    @ResponseBody
    public InfoBean getProducts(@PathVariable String sid,HttpServletRequest request,HttpServletResponse response) throws Exception {
        InfoBean infoBean=resourcesService.getResOne(sid);
        return infoBean;
    }
/*

    @RequestMapping(value="/info",method=RequestMethod.POST)
    public ModelAndView insertProduct(Product pro, HttpServletRequest request,HttpServletResponse response) throws Exception {
        ModelAndView modelAndView = new ModelAndView("list.jsp");
        request.setAttribute("name", pro.getPid()+"___"+pro.getPname());
        return modelAndView;
    }
*/

}
