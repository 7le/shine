package com.shine.controller.backend;

import com.shine.bean.Page2;
import com.shine.bean.ResultBean;
import com.shine.exception.ServiceHandleException;
import net.shine.mongodb.entity.Account;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * @author 7le
 * @since 2017/4/13 0013.
 */
@Controller
public class AccountController extends BackendController {

    @RequestMapping(value = "/backend/account/list", method = RequestMethod.GET)
    public ModelAndView listView(@RequestParam(defaultValue = "1", value = "page") Integer pageNum,
                                 @RequestParam(defaultValue = "10", value = "rows") Integer pageSize) {
        ModelAndView model=new ModelAndView("/backend/account/accountList");
        Page2 page2 = accountService.page(pageNum - 1, pageSize);
        if (page2 == null) {
            page2 = new Page2(null, 0, 0, 0);
        }
        model.addObject("accountList",page2);
        return model;
    }

    @RequestMapping(value = "/backend/account/add", method = RequestMethod.GET)
    public ModelAndView addView() {
        return new ModelAndView("/backend/account/accountAdd");
    }

    @RequestMapping(value = "/backend/account/{sid}", method = RequestMethod.GET)
    @ResponseBody
    public ModelAndView getAccount(@PathVariable String sid) {
        ModelAndView model=new ModelAndView("/backend/account/accountEdit");
        Account account = accountService.getAccount(sid);
        model.addObject("account",account);
        return model;
    }

    @RequestMapping(value = "/backend/account", method = RequestMethod.GET)
    @ResponseBody
    public Page2 getAllAccount(@RequestParam(defaultValue = "1", value = "offset") Integer offset,
                               @RequestParam(defaultValue = "10", value = "pageSize") Integer pageSize) {

        Page2 page2 = accountService.page(offset/pageSize, pageSize);

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
            return ResultBean.error("不小心,失败了~");
        } else {
            return ResultBean.success("哦耶,成功啦~");
        }
    }

    @RequestMapping(value = "/backend/account", method = RequestMethod.PUT)
    @ResponseBody
    public ResultBean updateAccount(HttpServletRequest request,@RequestBody Account account){
        Long flag = accountService.updateAccount(request, account);

        if (flag != 1) {
            return ResultBean.error("不小心,失败了~");
        } else {
            return ResultBean.success("哦耶,成功啦~");
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
                return ResultBean.success("哦耶,成功啦~");
            } catch (ServiceHandleException e) {
                return ResultBean.error("不小心,失败了~");
            }
        }else {
            return ResultBean.error("请选择要删除的记录");
        }
    }

}
