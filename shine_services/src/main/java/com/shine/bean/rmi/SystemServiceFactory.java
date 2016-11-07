package com.shine.bean.rmi;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by hq on 2016/11/4
 */
public class SystemServiceFactory {

//    /**
//     * service对象
//     */
//    private SystemService systemService = null;

    public List<SystemService> getService() {
        List<SystemService> list =new ArrayList<>();
        for (String serviceUrl:serviceUrls){
            try {
                list.add((SystemService) Naming.lookup(serviceUrl));
            } catch (NotBoundException | MalformedURLException | RemoteException e) {
                e.printStackTrace();
            }
        }
        return list;
    }


    /**
     * 服务地址
     */
    private List<String> serviceUrls;

    public List<String> getServiceUrls() {
        return serviceUrls;
    }

    public void setServiceUrls(List<String> serviceUrls) {
        this.serviceUrls = serviceUrls;
    }

    public static void main(String[] args) throws RemoteException {
//        SystemServiceFactory systemServiceFactory = new SystemServiceFactory();
//        ArrayList list = new ArrayList();
//        list.add("rmi://121.43.61.206:7893/SystemService");
//        systemServiceFactory.setServiceUrls(list);
//        SystemService systemService = systemServiceFactory.getService().get(0);
//        systemService.addInterface("chinaMobile","test_interface","585581","Zj5581","106904585581","911337","211.140.12.45","7890","60000");
//        systemService.addConsumer("com.xidian.neptune.smsplatform.sendsms.listener.send.CMPPListener","test_interface","consumerSpringId","test_queue");

    }
}
