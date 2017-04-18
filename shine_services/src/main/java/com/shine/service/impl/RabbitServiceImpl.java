package com.shine.service.impl;


import com.rabbitmq.client.Channel;
import com.shine.bean.ResultBean;
import com.shine.service.RabbitService;
import com.shine.util.RabbitUtil;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;


import java.io.IOException;
import java.util.HashMap;


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

    //rabbitmq的死信队列，换个思路做成定时的发送机制
    @Override
    public ResultBean DLXProducer() {
        try {
            Channel channel=connectDataSource.getConn().createChannel();

            channel.queueDeclare("MAIN_QUEUE", true, false, false, null);
            channel.queueBind("MAIN_QUEUE", "amq.direct", "MAIN_QUEUE");

            HashMap<String, Object> arguments = new HashMap<String, Object>();
            arguments.put("x-dead-letter-exchange", "amq.direct");
            arguments.put("x-dead-letter-routing-key", "MAIN_QUEUE");
            channel.queueDeclare("DELAY_QUEUE", true, false, false, arguments);


        } catch (IOException e) {
            rabbitmq.error("发送失败",e);
            return new ResultBean(false,"失败",null);
        }
        return new ResultBean(true,"成功",null);
    }


}
