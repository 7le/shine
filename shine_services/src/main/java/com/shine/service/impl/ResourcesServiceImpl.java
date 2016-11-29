package com.shine.service.impl;

import com.mongodb.BasicDBObject;
import com.shine.bean.Page2;
import com.shine.service.ResourcesService;
import net.shine.mongodb.BeanHelper;
import net.shine.mongodb.config.DatabaseConfig;
import net.shine.mongodb.entity.InfoBean;
import net.shine.mongodb.mongo.Mongo;
import org.bson.Document;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Service;

import javax.xml.crypto.Data;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by hq on 2016/11/8.
 */
@Service
public class ResourcesServiceImpl extends BaseServiceImpl implements ResourcesService {

    @Override
    public int saveRes(InfoBean infoBean) {
        Document document = BeanHelper.bean2Document(infoBean);

        String collectName = "Resources";

        mongokit.save(collectName, document);
        if (document.get("_id") != null) {
            ObjectId objectId = document.getObjectId("_id");
            infoBean.setSid(objectId);
            if (objectId != null)
                return 1;
        }

        return 0;
    }

    @Override
    public Page2<InfoBean> page(String sid, int pageNum, int pageSize) {

        String collectName = DatabaseConfig.DATABASE.COLLECTION_RES;
        Map<String, Object> filter = new HashMap<>();

        if (sid != null) {
            filter.put("_id", new ObjectId(sid));
        }
        //按发送时间倒序 资源不需要按时间排序
      /*  Map<String, Integer> sort = new HashMap<String, Integer>() {
            {
                put("time", Mongo.DESC);
            }
        };*/
        BasicDBObject conditon = mongokit.buildConditon(filter);
//        Long st = System.currentTimeMillis();
        Long count = mongokit.getCount(collectName, conditon);
//        Long en = System.currentTimeMillis();
//        System.out.println("查询数量耗时=" + (en - st) + "ms");

        if (count > 0) {
            List<Document> records = mongokit.find(collectName, filter, pageNum, pageSize, null);
            Long en1 = System.currentTimeMillis();
//            System.out.println("查询耗时=" + (en1 - en) + "ms");
            if (records != null && !records.isEmpty()) {
                List<InfoBean> infoBeans = BeanHelper.documentToRecords(records, InfoBean.class);
//                Long en2 = System.currentTimeMillis();
//                System.out.println("转化耗时=" + (en2 - en) + "ms");
                Page2<InfoBean> page = new Page2<>(infoBeans, pageNum, new Double(Math.ceil(count.intValue() * 1.0 / pageSize)).intValue(), count.intValue());
                return page;
            }
        }
        return null;
    }

    @Override
    public InfoBean getResOne(String sid) {
        String collectName = DatabaseConfig.DATABASE.COLLECTION_RES;

        BasicDBObject condition = new BasicDBObject();

        condition.put("_id", new ObjectId(sid));

        return  BeanHelper.documentToBean(mongokit.findOne(collectName, condition, null), InfoBean.class);
    }

}
