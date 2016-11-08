package com.shine.service;

import net.shine.mongodb.entity.InfoBean;

/**
 * Created by hq on 2016/11/8.
 */
public interface ResourcesService {

    /**
     * 保存资源
     * @param infoBean
     * @return
     */
    int saveRes(InfoBean infoBean);

}
