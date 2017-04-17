package com.shine.template;


/**
 * @author 7le
 * @since 2017/4/17
 * 添加freemarker宏调用测试
 */
public class freemarkerService {

    //测试下freemarker宏 能否直接传拼接的html
    public String findDataTemplate(Integer websiteId, Integer channelId) {


        return "<h1>" + websiteId + "测试" + channelId + "<h1>";

    }
}
