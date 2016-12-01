package com.shine.service;

import com.shine.bean.ResultBean;

/**
 * Created by hq on 2016/11/15.
 */
public interface SpiderService {

    /**
     * 迅雷铺爬虫开始
     * @return
     */
    ResultBean xlpSpider(Integer begin,Integer end);
}
