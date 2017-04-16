package com.shine.service.impl;

import com.mongodb.BasicDBObject;
import com.mongodb.QueryOperators;
import com.shine.bean.Page2;
import com.shine.bean.ResultBean;
import com.shine.dao.model.AdminUser;
import com.shine.exception.ServiceHandleException;
import com.shine.service.AccountService;
import com.shine.util.TimeUtil;
import net.shine.mongodb.BeanHelper;
import net.shine.mongodb.config.DatabaseConfig;
import net.shine.mongodb.entity.Account;
import net.shine.mongodb.mongo.Mongo;
import org.bson.Document;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 7le
 * @since 2017/4/13 0013.
 */
@Service
public class AccountServiceImpl extends BaseServiceImpl implements AccountService {

    @Override
    public Integer saveAccount(HttpServletRequest request, Account accout) {

        //取出管理员信息
        AdminUser adminUser=loginAdminCache.getLoginAdmin(request);

        accout.setCreatePerson(adminUser.getId());
        accout.setCreateDate(TimeUtil.getNowTimeDate());

        Document document = BeanHelper.bean2Document(accout);

        mongokit.save(DatabaseConfig.DATABASE.COLLECTION_ACCOUNT, document);

        if (document.get("_id") != null) {
            ObjectId objectId = document.getObjectId("_id");
            if (objectId != null) {
                return 1;
            }
        }
        return 0;
    }

    @Override
    public Account getAccount(String sid) {
        //获取该用户集合
        String collectName = DatabaseConfig.DATABASE.COLLECTION_ACCOUNT;
        //筛选参数
        BasicDBObject condition = new BasicDBObject();
        //以objectId为查找条件
        condition.put("_id", new ObjectId(sid));

        Document document = mongokit.findOne(collectName, condition, null);

        return BeanHelper.documentToBean(document, Account.class);
    }

    @Override
    public Long updateAccount(HttpServletRequest request, Account accout) {

        Document document = BeanHelper.bean2Document(accout);

        Long count = mongokit.update(DatabaseConfig.DATABASE.COLLECTION_ACCOUNT, accout.getSid(), document);

        if (count != null && count > 0) {
            return count;
        }
        return 0L;
    }

    @Override
    public Page2<Account> page(Integer pageNum, Integer pageSize) {
        //获取该用户集合
        String collectName = DatabaseConfig.DATABASE.COLLECTION_ACCOUNT;

        //筛选参数
        Map<String, Object> findCondition = new HashMap<>();

        //按发送时间倒序
        Map<String, Integer> sort = new HashMap<String, Integer>() {
            {
                put("createDate", Mongo.DESC);
            }
        };
        BasicDBObject condition = mongokit.buildConditon(findCondition);
        //System.out.println(condition);
        //得到总数量
        Long count = mongokit.getCount(collectName, condition);
        if (count > 0) {
            List<Document> records = mongokit.find(collectName, findCondition, pageNum, pageSize, sort);
//            Long en1 = System.currentTimeMillis();
//            System.out.println("查询耗时=" + (en1 - en) + "ms");
            if (records != null && !records.isEmpty()) {
                List<Account> Account = BeanHelper.documentToRecords(records, Account.class);
                //               System.out.println(MMSMaterials);
//                Long en2 = System.currentTimeMillis();
//                System.out.println("转化耗时=" + (en2 - en) + "ms");
                Page2<Account> page = new Page2<>(Account, pageNum+1, (int)Math.ceil(count.intValue() * 1.0 / pageSize), count.intValue());
                return page;
            }
        }
        return null;
    }

    @Override
    public void deleteAccount(String sid) throws ServiceHandleException{
        //获取该用户集合
        String collectName = DatabaseConfig.DATABASE.COLLECTION_ACCOUNT;
        //筛选参数
        BasicDBObject condition = new BasicDBObject();
//        condition.put("memberId",memberId);
//        condition.put("materialId",materialId);

        condition.put("_id", new ObjectId(sid));

        mongokit.deleteOne(DatabaseConfig.DATABASE.COLLECTION_ACCOUNT, collectName, condition);
    }
}
