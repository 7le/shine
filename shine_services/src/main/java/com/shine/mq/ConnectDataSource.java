package com.shine.mq;

import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import org.apache.log4j.Logger;

import java.io.IOException;

/**
 * 链接池
 * @author hq 2016/11/04
 */
public class ConnectDataSource {

    private String IP;
    private int port;
    private String username;
    private String password;
    private int maxConnNum;//最大连接数
    private Connection[] list;//连接list
    private Integer pointer = 0;//指针
    private ConnectionFactory connFac;//连接工厂

//    private Map<String,Object> paraMap;//参数

    protected static final Logger normalLogger = Logger.getLogger("normal");

    public ConnectDataSource(String IP, int port, String username, String password, int maxConnNum) {
        this.IP = IP;
        this.port = port;
        this.username = username;
        this.password = password;


        if(maxConnNum > 800)
            maxConnNum = 800;
        this.maxConnNum = maxConnNum;


        /**
         * 限制数量
         */
        list = new Connection[maxConnNum];

        /**
         * 联立连接工厂
         */
        connFac = new ConnectionFactory();
        connFac.setHost(IP);
        connFac.setPort(port);
        connFac.setUsername(username);
        connFac.setPassword(password);

        for (int i = 0 ; i < maxConnNum ; i ++){
            try {
                list[pointer] = connFac.newConnection();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public Connection getConn() throws IOException {
        synchronized (pointer) {
            /**
             * 判断链接是否存在
             */
            if (list[pointer] == null || !list[pointer].isOpen())
                list[pointer] = connFac.newConnection();

            /**
             * 判断是否可用
             */
            if (!list[pointer].isOpen()) {
                list[pointer] = connFac.newConnection();
            }
            /**
             * 取出链接
             */
            Connection connection = list[pointer];

            /**
             * 移动指针
             */
            pointer++;
            /**
             * 判断指针最大值
             */
            if (pointer >= maxConnNum)
                pointer = 0;
            return connection;
        }
    }

    public void closeAll() throws IOException {
        normalLogger.info("正在关闭全部rabbitmq的连接");
        for(int i = 0 ; i < list.length ; i ++){
            if(list[i] != null && list[i].isOpen()){
                list[i].close();
                normalLogger.info("关闭rabbitmq连接" + list[i]);
            }
        }
    }
    // get set

    public String getIP() {
        return IP;
    }

    public void setIP(String IP) {
        this.IP = IP;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getMaxConnNum() {
        return maxConnNum;
    }

    public void setMaxConnNum(int maxConnNum) {
        this.maxConnNum = maxConnNum;
    }

    public ConnectionFactory getConnFac() {
        return connFac;
    }

    public void setConnFac(ConnectionFactory connFac) {
        this.connFac = connFac;
    }

}
