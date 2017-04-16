package com.shine.service;

import com.shine.bean.Page2;
import com.shine.bean.ResultBean;
import com.shine.exception.ServiceHandleException;
import net.shine.mongodb.entity.Account;
import org.bson.types.ObjectId;

import javax.servlet.http.HttpServletRequest;

/**
 * @author 7le
 * @since 2017/4/13 0013.
 */
public interface AccountService {

    /**
     * 新增Account记录
     * @param accout
     * @return
     */
    Integer saveAccount(HttpServletRequest request,Account accout);

    /**
     * 得到Account记录
     * @param sid
     * @return
     */
    Account getAccount(String sid);

    /**
     * 更新Account记录
     * @param accout
     * @return
     */
    Long updateAccount(HttpServletRequest request,Account accout);

    /**
     *  分页查询Account记录
     */
    Page2<Account> page(Integer pageNum, Integer pageSize);

    /**
     * Account记录删除
     */
    void deleteAccount(String sid) throws ServiceHandleException;
}
