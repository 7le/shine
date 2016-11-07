package com.shine.bean.rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * 给别的系统提供服务
 */
public interface SystemService extends Remote {
    /**
     * 用于测试链接是否正常
     * @throws RemoteException
     */
    Object test()throws RemoteException;



    /**
     * 重新里面的链接，队列的监听
     * @return
     */
    Object reset()throws RemoteException;

    /****************** consumer *************************/

    /**
     * 添加消费者
     * @param className 消费者类名
     * @param interfaceSpringId 接口ID
     * @param consumerSpringId 消费者ID
     * @param queueName 监听队列名
     * @return
     */
    Object addConsumer(String className,String interfaceSpringId,String consumerSpringId,String queueName,Integer sleepTime)throws RemoteException;

    /**
     * 停止消费者
     * @param consumerSpringId
     * @return
     * @throws RemoteException
     */
    Object stopConsumer(String consumerSpringId)throws RemoteException;

    /**
     * 启动消费者
     * @param consumerSpringId
     * @return
     * @throws RemoteException
     */
    Object startConsumer(String consumerSpringId,String systemInterfaceSpringId)throws RemoteException;

    /**
     * 获得消费者状态
     * @throws RemoteException
     */
    Object getConsumerStatus(String consumerSpringId)throws RemoteException;

    /****************** interface *************************/

    /**
     * 添加接口
     * @param interfaceType 类型
     * @param springId springID
     * @param para 初始化参数
     */
    Object addInterface(String interfaceType,String springId,Integer extraNum,String... para)throws RemoteException;

    /**
     * 启动接口
     * @return
     * @throws RemoteException
     */
    Object startInterface(String interfaceType,String springId)throws RemoteException;

    /**
     * 关闭接口
     * @return
     * @throws RemoteException
     */
    Object stopInterface(String interfaceType,String springId)throws RemoteException;

    /**
     * 获得接口状态
     */
    Object getInterfaceStatus(String interfaceType, String springId)throws RemoteException;

}