package net.sedion.mongodb.utils;

import net.sedion.mongodb.BeanHelper;
import net.sedion.mongodb.config.DatabaseConfig;
import net.sedion.mongodb.entity.DeliverMsg;
import net.sedion.mongodb.mongo.Mongo;
import net.sedion.mongodb.mongo.Mongokit;
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

    /**
     * 消息流水号查询短信记录
     *
     * @param userName
     * @param sequence_id
     * @return
     */
    public static List<Object> findBySequenceId(Mongokit mongokit, String userName, Integer sequence_id) {

        if (sequence_id == null || sequence_id < 1) {
            return null;
        }

        String collectName = "member_" + userName;
        Map<String, Object> filter = new HashMap<>();

        filter.put("sequence_Id", sequence_id);

        //按发送时间倒序
        Map<String, Integer> sort = new HashMap<String, Integer>() {
            {
                put("time", Mongo.DESC);
            }
        };

        List<Document> documents = mongokit.find(collectName, filter, 0, 0, sort);
        if (documents != null && !documents.isEmpty()) {
            List<Object> records = BeanHelper.documentToRecords(documents,Object.class);

            return records;
        }
        return null;
    }

    /**
     * 查询未更新过状态的短信记录
     *
     * @param mongokit
     * @param userName
     * @param sequence_id
     * @param statusName  值是否为null
     * @return
     */
    public static Object findLastBySequenceIdAndUnRespStatus(Mongokit mongokit, String userName, Integer sequence_id, String statusName) {

        if (sequence_id == null || sequence_id < 1) {
            return null;
        }

        String collectName = "member_" + userName;
        Map<String, Object> filter = new HashMap<>();

        filter.put("sequence_Id", sequence_id);
        filter.put(statusName, null);

        //按发送时间倒序
        Map<String, Integer> sort = new HashMap<String, Integer>() {
            {
                put("time", Mongo.DESC);
            }
        };

        Document document = mongokit.findOne(collectName, filter, sort);
        if (document != null && !document.isEmpty()) {
            Object record = BeanHelper.documentToBean(document, Object.class);

            return record;
        }
        return null;
    }

    /**
     * 短信流水号查询短信记录
     *
     * @param userName
     * @param msgIdStr
     * @return
     */
    public static Object findByMsgIdStr(Mongokit mongokit, String userName, String msgIdStr) {
        if (msgIdStr == null) {
            return null;
        }
        String collectName = "member_" + userName;
        Map<String, Object> filter = new HashMap<>();
        filter.put("msgIdStr", msgIdStr);
        //按发送时间倒序
        Map<String, Integer> sort = new HashMap<String, Integer>() {
            {
                put("time", Mongo.DESC);
            }
        };

        Document document = mongokit.findOne(collectName, filter, sort);
        if (document != null) {
            Object record = BeanHelper.documentToBean(document, Object.class);
            return record;
        }

        return null;
    }

}
