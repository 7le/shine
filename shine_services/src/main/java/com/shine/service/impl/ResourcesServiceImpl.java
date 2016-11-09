package com.shine.service.impl;

import com.shine.service.ResourcesService;
import net.shine.mongodb.BeanHelper;
import net.shine.mongodb.entity.InfoBean;
import org.bson.Document;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Service;

/**
 * Created by hq on 2016/11/8.
 */
@Service
public class ResourcesServiceImpl extends BaseServiceImpl implements ResourcesService {

    @Override
    public int saveRes(InfoBean infoBean) {
        Document document = BeanHelper.bean2Document(infoBean);

        String collectName = "Resources1";

        mongokit.save(collectName, document);
        if (document.get("_id") != null) {
            ObjectId objectId = document.getObjectId("_id");
            infoBean.setSid(objectId);
            if (objectId != null)
                return 1;
        }

        return 0;
    }

}
