package net.shine.mongodb.utils;

import net.shine.mongodb.BeanHelper;
import net.shine.mongodb.mongo.Mongo;
import net.shine.mongodb.mongo.Mongokit;
import org.bson.Document;
import org.bson.types.ObjectId;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class MongoUtil {

    /**
     * 根据mongo 主键获取 记录
     *
     * @param userName
     * @param sid
     * @return
     */
    public static Object findBySid(Mongokit mongokit, String userName, String sid) {

        if (sid == null ) {
            return null;
        }

        String collectName = "member_" + userName;
        Map<String, Object> filter = new HashMap<>();

        filter.put("_id", new ObjectId(sid));

//        //按发送时间倒序
//        Map<String, Integer> sort = new HashMap<String, Integer>() {
//            {
//                put("time", Mongo.DESC);
//            }
//        };

        Document documents = mongokit.findOne(collectName, filter, null);
        if (documents != null && !documents.isEmpty()) {

            return BeanHelper.documentToBean(documents, Object.class);
        }
        return null;
    }


    /**
     * 根据mongo 主键更新 记录
     *
     * @param userName
     * @param objectId
     * @param smsRecord
     * @return
     */
    public static Long updateSms(Mongokit mongokit, String userName, ObjectId objectId, Object smsRecord) {

        Document document = BeanHelper.bean2Document(smsRecord);

        String collectName = "member_" + userName;

        Long count = mongokit.update(collectName, objectId.toString(), document);
        if (count != null && count > 0) {
            return count;
        }
        return null;
    }
}
