package com.shine.util;

import com.rabbitmq.client.*;
import org.apache.log4j.Logger;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/**
 * rabbitmq 工具类
 */
public class RabbitUtil {

    protected static final Logger rabbitmqLogger = Logger.getLogger("rabbitmq");

    static {
        //初始化优先级
        AMQP.BasicProperties[] pris = new AMQP.BasicProperties[10];
        for(int i = 0 ; i < 10 ; i ++){
            pris [i] =   new AMQP.BasicProperties("text/plain",
                    null,
                    null,
                    2,
                    i, null, null, null,
                    null, null, null, null,
                    null, null);

        }
        RabbitUtil.pris = pris;
    }

    /**
     * 按照10个优先结排序
     */
    private static AMQP.BasicProperties[] pris ;

    /**
     * 发送
     * @param connection 连接
     * @param queueName 队列名
     * @param msg 优先级
     * @throws IOException
     */
    public static void sendOnlyByPir(Connection connection,String queueName,Object msg,int pri) throws IOException {
        Channel channel = null;
        if(pri < 0){
            pri = 0 ;
        }

        AMQP.BasicProperties basicProperties = null;//属性
        if(pri < 10){
            basicProperties = pris[pri];
        }

        try{

            /**
             * 如果属性空载设置
             */
            if(basicProperties == null)
                basicProperties = new AMQP.BasicProperties("text/plain",
                        null,
                        null,
                        2,
                        pri, null, null, null,
                        null, null, null, null,
                        null, null);

            channel = connection.createChannel();
            channel.basicPublish("", queueName, basicProperties, toByteArray(msg));
        }finally {
            if(channel != null)
                channel.close();
        }
    }

    /**
     * 发送消息 速度最快 但是没有如果没有相应的队列就会出错
     */
    public static void sendOnly(Channel channel,String queueName,Object msg) throws IOException {
        try{
            channel.basicPublish("", queueName, MessageProperties.PERSISTENT_TEXT_PLAIN, toByteArray(msg));
        }finally {
            if(channel != null && channel.isOpen())
                channel.close();
        }
    }

    /**
     * 发送消息 速度最快 但是没有如果没有相应的队列就会出错
     */
    public static void sendOnly(Connection connection,String queueName,Object msg) throws IOException {
        Channel channel = connection.createChannel();
        try{
            channel.basicPublish("", queueName, MessageProperties.PERSISTENT_TEXT_PLAIN, toByteArray(msg));
        }finally {
            if(channel != null)
                channel.close();
        }
    }

    /**
     * 发送
     * @param connection
     * @param queueName
     * @param msg
     * @throws IOException
     */
    public static void send(Connection connection,String queueName,Object msg) throws IOException {
        Channel channel = null;
        try{
            channel = connection.createChannel();
            send(channel, queueName, msg);
        }finally {
            if(channel != null && channel.isOpen())
                channel.close();
        }
    }
    /**
     * 发送消息
     */
    public static void send(Channel channel,String queueName,Object msg) throws IOException {
        try{
            bind(channel,queueName);
            channel.basicPublish("", queueName, MessageProperties.PERSISTENT_TEXT_PLAIN, toByteArray(msg));
        }finally {
            if(channel != null && channel.isOpen())
                channel.close();
        }
    }

    /**
     * 队列绑定（设置）
     * @param channel 通道
     * @param queue_name 队列名
     * @param pri 优先级数量
     * @throws IOException
     */
    public static void bind(Channel channel,String queue_name,int pri) throws IOException {
        channel.basicQos(1);
        boolean durable = true;//这样设置之后，服务器收到消息后就会立刻将消息写入到硬盘
        Map<String, Object> arguments = new HashMap<>();
        arguments.put("x-max-priority", pri);
        channel.queueDeclare(queue_name, durable, false, false, arguments) ;
    }


    /**
     * 将 channel 和队列绑定
     * @throws IOException
     */
    public static void bind(Channel channel,String queue_name) throws IOException {
        channel.basicQos(1);
        boolean durable = true;//这样设置之后，服务器收到消息后就会立刻将消息写入到硬盘
        channel.queueDeclare(queue_name, durable, false, false, null) ;
    }


    /**
     * 接受消息
     * @param conn
     * @param queueName
     * @return
     * @throws IOException
     */
    public static Channel receive(Connection conn, final String queueName,final ReceiveListener receiveListener) throws IOException {
        final Channel channel = conn.createChannel() ;
        channel.basicQos(1);//1条消息还没处理结束不接受别的消息
        //配置好获取消息的方式
        final QueueingConsumer consumer = new QueueingConsumer(channel) ;

        //取消 autoAck 取消自动提交
        boolean autoAck = false ;
        channel.basicConsume(queueName, autoAck, consumer) ;
        receiveListener.setIsOpen(true);//设置状态
        receiveListener.setChannel(channel);
        new Thread(){
            @Override
            public void run() {
                try {
                    while(true){
                        //获取消息，如果没有消息，这一步将会一直阻塞
                        QueueingConsumer.Delivery delivery = consumer.nextDelivery();
                        Object msg = toObject(delivery.getBody());
                        receiveListener.setDelivery(delivery);
                        receiveListener.receiveMsg(msg);
                    }
                }catch (ShutdownSignalException ex){
                    System.out.println("channel["+channel+"] stop");
                    receiveListener.setIsOpen(false);
                }catch (InterruptedException e) {
                    e.printStackTrace();
                    receiveListener.setIsOpen(false);
                }catch (Exception e){
                    e.printStackTrace();
                    receiveListener.setIsOpen(false);
                }
            }
        }.start();
        return channel;
    }

    /**
     * 接受消息 并绑定优先级为10
     * @param conn
     * @param queueName
     * @return
     * @throws IOException
     */
    public static Channel receive10pri(Connection conn, final String queueName,final ReceiveListener receiveListener) throws IOException {
        final Channel channel = conn.createChannel() ;
        channel.basicQos(1);//1条消息还没处理结束不接受别的消息
        boolean durable = true;//这样设置之后，服务器收到消息后就会立刻将消息写入到硬盘
        Map<String,Object> args = new HashMap<>();
        args.put("x-max-priority",10);
        channel.queueDeclare(queueName, durable, false, false, args) ;
        //配置好获取消息的方式
        final QueueingConsumer consumer = new QueueingConsumer(channel) ;

        //取消 autoAck 取消自动提交
        boolean autoAck = false ;
        channel.basicConsume(queueName, autoAck, consumer) ;
        receiveListener.setChannel(channel);
        receiveListener.setIsOpen(true);//设置状态
        new Thread(){
            @Override
            public void run() {
                try {
                    while(true){
                        //获取消息，如果没有消息，这一步将会一直阻塞
                        QueueingConsumer.Delivery delivery = consumer.nextDelivery();
                        Object msg = toObject(delivery.getBody());
//                        receiveListener.setChannel(channel);
                        receiveListener.setDelivery(delivery);
                        receiveListener.receiveMsg(msg);
                    }
                }catch (ShutdownSignalException ex){
                    System.out.println("channel["+channel+"] stop");
                    receiveListener.setIsOpen(false);
                }catch (InterruptedException e) {
                    e.printStackTrace();
                    receiveListener.setIsOpen(false);
                }catch (Exception e){
                    e.printStackTrace();
                    receiveListener.setIsOpen(false);
                }
            }
        }.start();
        return channel;
    }

    /**
     * 接收消息监听器
     */
    public static abstract class ReceiveListener{
        public ReceiveListener(){}
        public ReceiveListener(Object invokeInterface) {
            this.invokeInterface = invokeInterface;
        }

        /**
         * 实现的接口
         * @param msg
         */
        public abstract void receiveMsg(Object msg);

        /**
         * 提交信息
         * @throws IOException
         */
        public void confirmMsg() throws IOException {
            RabbitUtil.confirmMsg(channel, delivery);
        }

        /**
         * 关闭Channel
         * @throws IOException
         */
        public void closeChannel() throws IOException {
            if(channel.isOpen())
                channel.close();
        }

        public abstract void setBean(Object... list);//设置需要的对象
        private Channel channel;
        private QueueingConsumer.Delivery delivery;
        private Object invokeInterface;//调用接口
        private boolean isOpen = false;
        private String queueName;

        public boolean isOpen(){
            if(channel == null || !channel.isOpen() || invokeInterface == null || !isOpen)
                return false;
            else
                return true;
        }

        //get set
        public void setIsOpen(boolean isOpen) {
            this.isOpen = isOpen;
        }

        public Object getInvokeInterface() {
            return invokeInterface;
        }

        public void setInvokeInterface(Object invokeInterface) {
            this.invokeInterface = invokeInterface;
        }

        public Channel getChannel() {
            return channel;
        }

        public void setChannel(Channel channel) {
            this.channel = channel;
        }

        public QueueingConsumer.Delivery getDelivery() {
            return delivery;
        }

        public void setDelivery(QueueingConsumer.Delivery delivery) {
            this.delivery = delivery;
        }

        public String getQueueName() {
            return queueName;
        }

        public void setQueueName(String queueName) {
            this.queueName = queueName;
        }
    }


    /**
     * 数组转对象
     * @param bytes
     * @return
     */
    public static Object toObject (byte[] bytes) {
        Object obj = null;
        ByteArrayInputStream bis = null;
        ObjectInputStream ois = null;
        try {
            bis = new ByteArrayInputStream(bytes);
            ois = new ObjectInputStream(bis);
            obj = ois.readObject();
        } catch (ClassNotFoundException | IOException e) {
            e.printStackTrace();
        }finally {
            if(ois != null)
                try {
                    ois.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            if(bis != null)
                try {
                    bis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
        }
        return obj;
    }


    /**
     * 对象转数组
     * @param obj
     * @return
     */
    public static byte[] toByteArray (Object obj) {
        byte[] bytes = null;
        ByteArrayOutputStream bos = null;
        ObjectOutputStream oos = null;
        try {
            bos = new ByteArrayOutputStream();
            oos = new ObjectOutputStream(bos);
            oos.writeObject(obj);
            oos.flush();
            bytes = bos.toByteArray ();
            oos.close();
            bos.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }finally {
            if(bos != null)
                try {
                    bos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            if(oos != null)
                try {
                    oos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
        }
        return bytes;
    }
    /**
     * 确认消息，已经收到
     */
    public static void confirmMsg(Channel channel,QueueingConsumer.Delivery delivery) throws IOException {
        channel.basicAck(delivery.getEnvelope().getDeliveryTag(), false);
    }

}
