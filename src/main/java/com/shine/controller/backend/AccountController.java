package com.shine.controller.backend;

import com.shine.bean.ResultBean;
import net.shine.mongodb.entity.Account;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author 7le
 * @since 2017/4/13 0013.
 */
@Controller
public class AccountController extends BackendController{

/*    @RequestMapping(value = "/account/{id}", method = RequestMethod.GET)
    public ResultBean getAccount(@PathVariable Integer id){

    }*/

    @RequestMapping(value = "/account", method = RequestMethod.POST)
    public ResultBean getAccount(@RequestBody Account account){
        Integer flag=accountService.saveAccount(account);

        if(flag!=1){
            return new ResultBean(false,"添加失败",null);
        }else {
            return new ResultBean(true,"添加成功",null);
        }
    }
/*
    @RequestMapping(value = "/account/{id}", method = RequestMethod.PUT)
    public ResultBean getAccount(@PathVariable Integer id,
                                 @RequestBody Account account){

    }

    @RequestMapping(value = "/account/{batch}", method = RequestMethod.DELETE)
    public ResultBean getAccount(){

    }*/

}
