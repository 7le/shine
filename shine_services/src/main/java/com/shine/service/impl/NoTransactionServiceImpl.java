package com.shine.service.impl;

import com.shine.service.NoTransactionService;
import org.springframework.stereotype.Service;

/**
 * spring事务PROPAGATION_REQUIRES_NEW
 * Created by hq on 2016/8/15 0015.
 */
@Service
public class NoTransactionServiceImpl extends BaseServiceImpl implements NoTransactionService{
/*    @Override
    public void notDeleteSend(TimeSend timeSend){
        //删除数据库已发送记录
        int result1=timeSendMapper.deleteByPrimaryKey(timeSend.getTimeSendId());
        if(result1==0){
            webLogger.error("定时发送——删除定时记录数据失败");
        }
    }*/
}
