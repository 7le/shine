package com.shine.service;

import com.shine.bean.ResultBean;

/**
 * Created by hq on 2016/10/7.
 */
public interface RabbitService {

    /**
     * 生产者 生存消息
     * @return
     */
     ResultBean producer();

    /**
     * 死信
     */
    ResultBean DLXProducer();
}
