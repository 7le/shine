package com.shine.init;

import com.shine.util.RabbitUtil;
import org.apache.log4j.Logger;

import java.io.IOException;


/**
 * Created by hq on 2016/10/7.
 */
public class RabbitListener extends RabbitUtil.ReceiveListener {

    protected static final Logger rabbitmq = Logger.getLogger("rabbitmq");


    @Override
    public void receiveMsg(Object msg) {
        try {
            confirmMsg();
            rabbitmq.info(msg);
            rabbitmq.error(msg);
        } catch (IOException e) {
           rabbitmq.error("消费发送错误",e);
        }

    }

    public RabbitListener(Object invokeInterface){
        super(invokeInterface);
    }

    @Override
    public void setBean(Object... list) {

    }

    /**
     * 关闭通道，即关闭队列消费者
     */
    private void closeQueue(){

    }
}
