package com.shine.service.impl;

import com.shine.bean.ResultBean;
import com.shine.service.ResourcesService;
import com.shine.service.SpiderService;
import com.shine.spider.XlpuSpider;
import net.shine.mongodb.entity.InfoBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by hq on 2016/11/15.
 */
@Service
public class SpiderServiceImpl extends BaseServiceImpl implements SpiderService {

    @Autowired
    private ResourcesService resourcesService;

    @Override
    public ResultBean xlpSpider(Integer begin,Integer end) {

        for (int i = begin; i <= end; i++) {
            try {
                InfoBean infoBean = XlpuSpider.getData(i);

                resourcesService.saveRes(infoBean);

                spiderLogger.info(i + ": " + infoBean.getSid());
            } catch (Exception e) {
                spiderLogger.info(e.getMessage());
                continue;
            }
        }
        return new ResultBean(true,"爬数据完毕",null);
    }

}
