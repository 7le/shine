package com.shine.controller.backend;

import com.shine.bean.Page2;
import com.shine.bean.ResultBean;
import com.shine.exception.ServiceHandleException;
import net.shine.mongodb.entity.Account;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author 7le
 * @since 2017/4/13 0013.
 */
@Controller
public class AccountController extends BackendController {

    @RequestMapping(value = "/backend/account/list", method = RequestMethod.GET)
    public ModelAndView listView() {
        return new ModelAndView("/backend/account/accountList");
    }

    @RequestMapping(value = "/backend/account/add", method = RequestMethod.GET)
    public ModelAndView addView() {
        return new ModelAndView("/backend/account/accountAdd");
    }

    @RequestMapping(value = "/backend/account/update", method = RequestMethod.GET)
    public ModelAndView updateView() {
        return new ModelAndView("/backend/account/accountUpdate");
    }

    @RequestMapping(value = "/backend/account/{sid}", method = RequestMethod.GET)
    @ResponseBody
    public ResultBean getAccount(@PathVariable String sid) {
        Account account = accountService.getAccount(sid);

        if (account == null) {
            return new ResultBean(false, "展示失败", null);
        } else {
            return new ResultBean(true, "展示成功", account);
        }
    }

    @RequestMapping(value = "/backend/account", method = RequestMethod.GET)
    @ResponseBody
    public Page2 getAllAccount(@RequestParam(defaultValue = "1", value = "page") Integer pageNum,
                               @RequestParam(defaultValue = "10", value = "rows") Integer pageSize) {

        Page2 page2 = accountService.page(pageNum - 1, pageSize);

        if (page2 == null) {
            page2 = new Page2(null, 0, 0, 0);
        }

        return page2;
    }

    @RequestMapping(value = "/backend/account", method = RequestMethod.POST)
    @ResponseBody
    public ResultBean addAccount(HttpServletRequest request, Account account) {
        Integer flag = accountService.saveAccount(request, account);

        if (flag != 1) {
            return new ResultBean(false, "添加失败", null);
        } else {
            return new ResultBean(true, "添加成功", null);
        }
    }

    @RequestMapping(value = "/backend/account", method = RequestMethod.PUT)
    @ResponseBody
    public ResultBean updateAccount(HttpServletRequest request,Account account){
        Long flag = accountService.updateAccount(request, account);

        if (flag != 1) {
            return new ResultBean(false, "更新失败", null);
        } else {
            return new ResultBean(true, "更新成功", null);
        }
    }

    @RequestMapping(value = "/backend/account/{batch}", method = RequestMethod.DELETE)
    @ResponseBody
    public ResultBean getAccount(@PathVariable String[] batch){
        //mongo 没有事务，如果中间出现错误，这里还需要增加逻辑
        if(batch!=null&&batch.length>0){
            try {
                for (int i = 0; i <batch.length ; i++) {
                    accountService.deleteAccount(batch[i]);
                }
                return new ResultBean(true,"删除成功",null);
            } catch (ServiceHandleException e) {
                return new ResultBean(false,"删除失败",null);
            }
        }else {
            return new ResultBean(false,"请选择要删除的记录",null);
        }

    }

}
