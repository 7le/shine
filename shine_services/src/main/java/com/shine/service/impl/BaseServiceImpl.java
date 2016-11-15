package com.shine.service.impl;


import com.shine.bean.rmi.SystemServiceFactory;

import com.shine.j2cache.LoginAdminCache;
import com.shine.j2cache.LoginAgentCache;
import com.shine.j2cache.LoginMemberCache;
import com.shine.j2cache.VerifyCodePhoneCache;
import com.shine.mq.ConnectDataSource;
import com.shine.service.ResourcesService;
import net.shine.mongodb.mongo.Mongokit;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.Resource;

/**
 * Created by hq on 2016/10/19
 */
public class BaseServiceImpl {

    protected static final Logger webLogger = Logger.getLogger("web");
    //
    protected static final Logger memberLogger = Logger.getLogger("member");

    protected static final Logger spiderLogger = Logger.getLogger("spider");
    /**
     * 缓存器
     */
    @Autowired
    protected VerifyCodePhoneCache verifyCodePhoneCache;
    @Autowired
    protected LoginMemberCache loginMemberCache;
    @Autowired
    protected LoginAdminCache loginAdminCache;
    @Autowired
    protected LoginAgentCache loginAgentCache;
    @Autowired
    protected ConnectDataSource connectDataSource;
    /**
     * mybatis dao接口
     */

/*
    @Autowired
    protected SystemServiceFactory systemServiceFactory;
*/
    @Autowired
    ResourcesService resourcesService;

    @Resource(name = "resMongoKit")
    protected Mongokit mongokit  ;


    /**
     * 记录管理员操作
     *
     * @return
     */
/*    protected int recordAdminOperation(String operation, Object admin) {
        AdminOperationRecord aor = new AdminOperationRecord();
        aor.setAdminId(admin.getAdminId());
        aor.setRecordDescribe(operation);
        aor.setRecordTime(System.currentTimeMillis());
        return adminOperationRecordMapper.insert(aor);
    }*/

    /**
     * 记录代理商操作
     * @param operation  操作详情
     * @param agent_type 代理商类型
     * @param agent 代理商
     * @return
     */
/*    protected int recordAgentOperation(String operation,String agent_type, Object agent) {
        AgentOperationRecord aor = new AgentOperationRecord();
        aor.setAgentId(agent.getAgentId());
        aor.setRecordDescribe(operation);
        aor.setOperationType(agent_type);
        aor.setRecordTime(System.currentTimeMillis());
        return agentOperationRecordMapper.insert(aor);
    }*/
}
