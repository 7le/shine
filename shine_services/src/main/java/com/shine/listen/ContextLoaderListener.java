package com.shine.listen;

import net.oschina.j2cache.J2Cache;

import javax.servlet.ServletContextEvent;


public class ContextLoaderListener extends org.springframework.web.context.ContextLoaderListener {

    @Override
    public void contextDestroyed(ServletContextEvent event) {

        super.contextDestroyed(event);
        J2Cache.getChannel().close();

        //
    }
}
