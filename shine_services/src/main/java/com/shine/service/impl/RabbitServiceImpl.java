package com.shine.service.impl;


import com.rabbitmq.client.*;
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
            rabbitmq.error("发送失败", e);
            return new ResultBean(false, "失败", null);
        }
        return new ResultBean(true, "成功", null);
    }

    //rabbitmq的死信队列，换个思路做成延时队列
    //方案1用x-message-ttl设置队列的时间，优点：过期了就会到死信队列，只需要一个延时队列。 缺点：不同的延时时间需要不同的队列。
    //方案2用expiration设置消息的过期时间，优点：消息可以定义自己不同的过期时间。 缺点：如果前面有未过期消息，过期消息不会直接被丢到死信队列中
    @Override
    public ResultBean DLXProducer() {
        try {
            Channel channel = connectDataSource.getConn().createChannel();
            HashMap<String, Object> args = new HashMap<String, Object>();
            args.put("x-dead-letter-exchange", "amq.direct");
            args.put("x-dead-letter-routing-key", "message_ttl_routingKey");
            //args.put("x-expires", 20000); //队列生存时间
            //args.put("x-message-ttl", 60000); //队列中的消息生存时间
            channel.queueDeclare("delay_queue", true, false, false, args);
            // 声明队列
            channel.queueDeclare("main_queue", true, false, false, null);
            // 绑定路由
            channel.queueBind("main_queue", "amq.direct", "message_ttl_routingKey");
            String message = "hello world!" + System.currentTimeMillis();
            // 设置延时属性
            AMQP.BasicProperties.Builder builder = new AMQP.BasicProperties.Builder();
            // 持久性 non-persistent (1) or persistent (2)
            AMQP.BasicProperties properties = builder.expiration("10000").deliveryMode(2).build();
            // routingKey =delay_queue 进行转发
            channel.basicPublish("", "delay_queue", properties, message.getBytes());
            // 关闭频道和连接
            channel.close();
        } catch (IOException e) {
            rabbitmq.error("发送失败", e);
            return new ResultBean(false, "失败", null);
        }
        return new ResultBean(true, "成功", null);
    }

    @Override
    public void consumer() throws Exception {

        Channel channel = connectDataSource.getConn().createChannel();

        HashMap<String, Object> args = new HashMap<String, Object>();
        args.put("x-dead-letter-exchange", "amq.direct");
        args.put("x-dead-letter-routing-key", "message_ttl_routingKey");
        channel.queueDeclare("delay_queue", true, false, false, args);

        // 声明队列
        channel.queueDeclare("main_queue", true, false, false, null);
        // 绑定路由
        channel.queueBind("main_queue", "amq.direct", "message_ttl_routingKey");

        QueueingConsumer consumer = new QueueingConsumer(channel);
        // 指定消费队列
        channel.basicConsume("main_queue", true, consumer);
        while (true) {
            // nextDelivery是一个阻塞方法（内部实现其实是阻塞队列的take方法）
            QueueingConsumer.Delivery delivery = consumer.nextDelivery();
            String message = new String(delivery.getBody());
            System.out.println("received message:" + message + ",date:" + System.currentTimeMillis());
        }
    }
}
