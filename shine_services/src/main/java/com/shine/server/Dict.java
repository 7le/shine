package com.shine.server;

import com.shine.dao.model.Dictionary;
import com.shine.service.DictionaryService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import java.util.*;

/**
 * Created by hq on 2017/1/11.
 */
@SuppressWarnings("unchecked")
public class Dict implements ServerModule {

    private static Dict dt = null;

    Log log = LogFactory.getLog(Dict.class);


    private Map sysMap= new HashMap();
    private Map sysMap_list= new HashMap();

    private Dict(){
    }

    public static Dict getInstance(){
        if(dt == null) {
            dt = new Dict();
        }
        return dt;
    }

    public synchronized void start(DictionaryService dictionaryService) {

        List al_zd =  refreshZd(dictionaryService);
        sysMap = (Map) al_zd.get(0);
        sysMap_list = (Map) al_zd.get(1);
    }

    /**
     * 刷新字典
     */
    private List refreshZd(DictionaryService dictionaryService){
        Map retMp = new TreeMap();
        Map retMp_list = new TreeMap();
        List mxlist = dictionaryService.getByAll();
        for(int i=0; i<mxlist.size(); i++) {
            Dictionary dc = (Dictionary) mxlist.get(i);
            String code = String.valueOf(dc.getCode());
            String dictid = String.valueOf(dc.getCategoryId());
            String spec = dc.getDictDesc();
            Map mp = (Map) retMp.get(dictid);
            if(mp == null) {
                mp = new TreeMap();
                retMp.put(dictid, mp);
            }
            mp.put(code, new String[]{code, spec});
        }
        for(int i=0; i<mxlist.size(); i++) {
            Dictionary dc = (Dictionary) mxlist.get(i);
            String code = String.valueOf(dc.getCode());
            String dictid = String.valueOf(dc.getCategoryId());
            String spec = dc.getDictDesc();
            List al = (List) retMp_list.get(dictid);
            if(al == null) {
                al = new ArrayList();
                retMp_list.put(dictid, al);
            }
            DictItem di = new DictItem();
            di.setText(spec);
            di.setValue(code);
            al.add(di);
        }
        ArrayList al = new ArrayList();
        al.add(retMp);
        al.add(retMp_list);
        return al;
    }
    public String getDictMc(String dmfl, String dm) {
        if(dm==null || "".equals(dm)) return "";
        try{
            if(sysMap != null) {
                Map dmMap = (Map) sysMap.get(dmfl);
                if(dmMap != null) {
                    String[] dmAl = (String[])dmMap.get(dm);
                    if(dmAl != null) {
                        return dmAl[1];
                    }
                }
            }
        }catch(Exception e){
            return "";
        }
        return "";
    }

    public List<DictItem> getDict(String dictId){
        if(sysMap_list!=null){
            return (List)sysMap_list.get(dictId);
        }
        return null;
    }

    public void initialize(ApplicationContext ctx) {
        PlatformTransactionManager transactionManager = (PlatformTransactionManager) ctx.getBean("transactionManager");
        DefaultTransactionDefinition def = new DefaultTransactionDefinition();
        // 设置事务的隔离级别，该级别表示一个事务只能读取另一个事务已经提交的数据，该级别可以防止脏读，这也是大多情况下的推荐值
        def.setIsolationLevel(TransactionDefinition.ISOLATION_READ_COMMITTED);
        // 初始化事务,参数定义事务的传播类型，如果当前存在事务，则加入该事务，如果没有事务，则创建一个新的事务
        def.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);
        // 获得事务状态
        TransactionStatus status = transactionManager.getTransaction(def);

        try {
            this.start((DictionaryService) ctx.getBean("dictionaryService"));
            transactionManager.commit(status);

        } catch (Exception e) {
            transactionManager.rollback(status);
            e.printStackTrace();

        }

    }
}
