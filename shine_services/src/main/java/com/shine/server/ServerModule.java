package com.shine.server;

import org.springframework.context.ApplicationContext;

/**
 * Created by hq on 2017/1/11.
 */
public interface ServerModule {

    public void initialize(ApplicationContext ctx);
}
