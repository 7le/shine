package com.shine.service;

import com.shine.bean.Page2;
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

    /**
     * 分页查询
     * @param sid     sid
     * @param pageNum       页数，从0开始
     * @param pageSize      每页数量
     * @return
     */
    Page2<InfoBean> page(String sid, int pageNum, int pageSize);

    /**
     * 获得单个资源
     * @param sid
     * @return
     */
    InfoBean getResOne(String sid);

}
