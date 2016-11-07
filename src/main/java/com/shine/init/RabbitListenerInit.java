package com.shine.init;

import com.shine.mq.ConnectDataSource;
import com.shine.service.RabbitService;
import org.springframework.beans.factory.annotation.Autowired;


import java.io.IOException;

/**
 * Created by hq on 2016/10/7.
 */
public class RabbitListenerInit {

    @Autowired
    private ConnectDataSource mqConnectDataSource;
    @Autowired
    RabbitService rabbitService;


    public void init() throws IOException {
        for (int i = 0; i < 1; i++) {
            RabbitListener rabbitListener = new RabbitListener(null);
            System.out.println(rabbitService);
            System.out.println(mqConnectDataSource);
/*            RabbitUtil.receive(mqConnectDataSource.getConn(), "ly", rabbitListener);*/
        }
    }
}
