package com.shine.service;

import net.shine.mongodb.entity.Account;

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
    Integer saveAccount(Account accout);
}
