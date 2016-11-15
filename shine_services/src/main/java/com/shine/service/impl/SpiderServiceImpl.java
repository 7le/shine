package com.shine.service.impl;

import com.shine.bean.ResultBean;
import com.shine.service.SpiderService;
import com.shine.spider.XlpuSpider;
import net.shine.mongodb.entity.InfoBean;
import org.springframework.stereotype.Service;

/**
 * Created by hq on 2016/11/15.
 */
@Service
public class SpiderServiceImpl extends BaseServiceImpl implements SpiderService {


    @Override
    public ResultBean xlpspider() {

        for (int i = 1; i <= 44467; i++) {
            try {
                InfoBean infoBean = XlpuSpider.getData(i);

                resourcesService.saveRes(infoBean);

                spiderLogger.info(i + ": " + infoBean.getSid());
            } catch (Exception e) {
                spiderLogger.info(e.getStackTrace());
                continue;
            }
        }
        return new ResultBean(true,"爬数据完毕");
    }

}
