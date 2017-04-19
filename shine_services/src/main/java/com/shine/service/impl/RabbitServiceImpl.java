package com.shine.service.impl;


import com.rabbitmq.client.*;
import com.shine.bean.ResultBean;
import com.shine.service.RabbitService;
import com.shine.util.RabbitUtil;
import org.apache.commons.lang.SerializationUtils;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;


import java.io.IOException;
import java.util.Date;
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
            rabbitmq.error("发送失败", e);
            return new ResultBean(false, "失败", null);
        }
        return new ResultBean(true, "成功", null);
    }

    //rabbitmq的死信队列，换个思路做成定时的发送机制
    @Override
    public ResultBean DLXProducer() {
        try {
            Channel channel = connectDataSource.getConn().createChannel();
            channel.exchangeDeclare("exchange_delay_begin","direct",true);


            channel.queueDeclare("MAIN_QUEUE", true, false, false, null);
            channel.queueBind("MAIN_QUEUE", "exchange_delay_begin", "MAIN_QUEUE");

            HashMap<String, Object> args = new HashMap<String, Object>();
            args.put("x-dead-letter-exchange", "exchange_delay_begin");
            args.put("x-dead-letter-routing-key", "MAIN_QUEUE");
            //args.put("x-expires", 20000); //队列生存时间
            args.put("x-message-ttl", 60000); //队列生存时间
            channel.queueDeclare("DELAY_QUEUE", true, false, false, args);


            AMQP.BasicProperties.Builder builder = new AMQP.BasicProperties.Builder();
            AMQP.BasicProperties properties = new AMQP.BasicProperties();

            builder.expiration("7000");//设置TTL为7s
            //设置持久化
            //1.exchange的durable属性设成true
            //2.queue的durable属性设成true
            //3.消息的deliveryMode设成2
            //builder.deliveryMode(2);
            String msg = String.valueOf(new Date());
            channel.basicPublish("", "DELAY_QUEUE", properties, ("Time:" + msg).getBytes());
            channel.close();
        } catch (IOException e) {
            rabbitmq.error("发送失败", e);
            return new ResultBean(false, "失败", null);
        }
        return new ResultBean(true, "成功", null);
    }

    @Override
    public ResultBean consumer() {
        try {

            Channel channel = connectDataSource.getConn().createChannel();

            HashMap<String, Object> args = new HashMap<String, Object>();
            args.put("x-dead-letter-exchange", "exchange_delay_begin");
            args.put("x-dead-letter-routing-key", "MAIN_QUEUE");
            //args.put("x-expires", 20000); //队列生存时间
            args.put("x-message-ttl", 60000); //队列生存时间
            channel.queueDeclare("DELAY_QUEUE", true, false, false, args);
            Consumer consumer = new DefaultConsumer(channel) {
                @Override
                public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body)
                        throws IOException {
                    String message = new String(body, "UTF-8");
                    System.out.println(" [x] Received '" + message + "'");
                }
            };
            channel.basicConsume("DELAY_QUEUE", true, consumer);
            channel.close();
        } catch (IOException e) {
            rabbitmq.error("接受失败", e);
            return new ResultBean(false, "失败", null);
        }
        return new ResultBean(true, "成功", null);
    }


}
