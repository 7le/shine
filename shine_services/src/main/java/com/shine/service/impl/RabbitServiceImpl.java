package com.shine.service.impl;


import com.shine.bean.ResultBean;
import com.shine.mq.ConnectDataSource;
import com.shine.service.RabbitService;
import com.shine.util.RabbitUtil;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.io.IOException;


/**
 * Created by hq on 2016/10/7.
 */
@Service
public class RabbitServiceImpl extends BaseServiceImpl implements RabbitService {

    protected static final Logger rabbitmq = Logger.getLogger("rabbitmq");
    
    @Override
    public ResultBean producer() {
        try {
            //发送到队列
            RabbitUtil.sendOnly(connectDataSource.getConn().createChannel(), "ly", "yoyo");
        } catch (IOException e) {
            rabbitmq.error("发送失败",e);
            return new ResultBean(false,"失败",null);
        }
        return new ResultBean(true,"成功",null);
    }
}
