package com.shine.controller.backend;

import com.shine.bean.ResultBean;
import net.shine.mongodb.entity.Account;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author 7le
 * @since 2017/4/13 0013.
 */
@Controller
public class AccountController extends BackendController{

    @RequestMapping(value = "/backend/account/list",method = RequestMethod.GET)
    public ModelAndView getList(){
        return new ModelAndView("/backend/account/accountList");
    }

    @RequestMapping(value = "/backend/account/add",method = RequestMethod.GET)
    public ModelAndView add(){
        return new ModelAndView("/backend/account/accountAdd");
    }

    @RequestMapping(value = "/backend/account/{sid}", method = RequestMethod.GET)
    public ResultBean getAccount(@PathVariable String sid){
        Account account=accountService.getAccount(sid);

        if(account==null){
            return new ResultBean(false,"展示失败",null);
        }else {
            return new ResultBean(true,"展示成功",account);
        }
    }

    @RequestMapping(value = "/backend/account", method = RequestMethod.POST)
    public ResultBean getAccount(@RequestBody Account account){
        Integer flag=accountService.saveAccount(account);

        if(flag!=1){
            return new ResultBean(false,"添加失败",null);
        }else {
            return new ResultBean(true,"添加成功",null);
        }
    }
/*
    @RequestMapping(value = "/backend/account/{id}", method = RequestMethod.PUT)
    public ResultBean getAccount(@PathVariable Integer id,
                                 @RequestBody Account account){

    }

    @RequestMapping(value = "/backend/account/{batch}", method = RequestMethod.DELETE)
    public ResultBean getAccount(){

    }*/

}
