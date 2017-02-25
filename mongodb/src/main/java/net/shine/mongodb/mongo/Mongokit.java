package net.shine.mongodb.mongo;

import com.mongodb.*;

import com.mongodb.client.*;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.IndexOptions;
import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.UpdateResult;
import net.shine.mongodb.config.DatabaseConfig;
import net.shine.mongodb.entity.StatisticMsg;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.bson.types.ObjectId;

import java.util.*;

/**
 * Created by hq
 */
public class Mongokit {

    /**
     * 统计专用
     */
    com.mongodb.Mongo mongo;
    DB myMongo;

    /**
     * 获取统计数据
     * 临时用
     */
    public List<StatisticMsg> getMsgStatistic(String collectionName,BasicDBObject query){
        //获取集合
        DBCollection userCollection = myMongo.getCollection(collectionName);
        String map = " function(){emit(this.signature,this.msgNum)}";
        String reduce = " function(key,values){return Array.sum(values)}";


        MapReduceCommand command = new MapReduceCommand(userCollection,map,reduce,null, MapReduceCommand.OutputType.INLINE, query);
        MapReduceOutput out = userCollection.mapReduce(command);


        List<StatisticMsg> list = new ArrayList<>();
        try {
            for (DBObject o : out.results()) {
                StatisticMsg statisticMsg = new StatisticMsg();
                statisticMsg.setSignature( o.get("_id").toString());
                statisticMsg.setCount(((Double) o.get("value")).intValue());
                list.add(statisticMsg);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    /**
     * 默认主机为本地
     */
    private static final String DEFAULT_HOST = "127.0.0.1";

    /**
     * 默认端口
     */
    private static final int DEFAULT_PORT = 27017;
    /**
     * 默认数据库
     */
    private static final String DEFAULT_DATABASE = "shine";

    private static final String DEFAULT_User = "hq_readwrite";

    private static final String DEFAULT_PSW = "5894";

    private MongoClient client;
    private MongoDatabase defaultDb;

//    private static Mongokit instance;

    private String host = DEFAULT_HOST;
    private Integer port = DEFAULT_PORT;

    private String user=DEFAULT_User;
    private String psw=DEFAULT_PSW;
    private String databaseName = DEFAULT_DATABASE;

    public Mongokit() {
        try {
//            Properties properties = PropertiesUtil.loadPropertyFile("mongodb.properties");
//            String host = properties.getProperty("host", DEFAULT_HOST);
//            String database = properties.getProperty("database", DatabaseConfig.DATABASE_SMS);
//            String portString = properties.getProperty("port", "");
//            int port = StringUtil.isNotEmpty(portString) ? Integer.valueOf(portString.trim()) : DEFAULT_PORT;
//            init(host, port, database);

//            ServerAddress serverAddress = new ServerAddress(host, port);
//            this.client = new MongoClient(serverAddress);
//            defaultDb = this.client.getDatabase(databaseName);
//            try {
//                //用于统计查询
//                mongo = new com.mongodb.Mongo(host,port);
//                myMongo = mongo.getDB(databaseName);
//            }catch (Exception e){
//                System.out.println("我报异常了哈哈哈");
//                e.printStackTrace();
//            }

        } catch (IllegalArgumentException e1) {
            if (e1.getMessage().indexOf("Properties file not found") != -1) {
                init(DEFAULT_HOST, DEFAULT_PORT, DatabaseConfig.DATABASE_SHINE);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

//    public static Mongokit getInstance() {
//        if (instance == null) {
//            instance = new Mongokit();
//            instance.init();
//        }
//        return instance;
//    }

    /**
     * 判断是否初始化
     *
     * @return
     */
    public boolean isInit() {
        return client != null;
    }


    /**
     * 初始化
     *
     * @param host
     * @param defaultDatabase
     */
    public void init(String host, String defaultDatabase) {
        this.init(host, DEFAULT_PORT, defaultDatabase);
    }

    /**
     * 初始化
     *
     */
    public void init(String host, int port, String defaultDatabase) {
        ServerAddress serverAddress = new ServerAddress(host, port);
        this.client = new MongoClient(serverAddress);
        defaultDb = this.client.getDatabase(defaultDatabase);
        try {
            //用于统计查询
            mongo = new com.mongodb.Mongo(host,port);
            myMongo = mongo.getDB(DatabaseConfig.DATABASE_SHINE);
        }catch (Exception e){
            System.out.println("我报异常了哈哈哈");
            e.printStackTrace();
        }
    }

    /**
     * 初始化
     *
     */
    public void init() {
        ServerAddress serverAddress = new ServerAddress(host, port);
        List<MongoCredential> credentialsList = new ArrayList<MongoCredential>();
        MongoCredential credentials = MongoCredential.createScramSha1Credential(user, "admin", psw.toCharArray());
        credentialsList.add(credentials);
        try {
            this.client = new MongoClient(serverAddress,credentialsList,new MongoClientOptions.Builder()
                    .socketKeepAlive(true) // 是否保持长链接
                    .connectionsPerHost(200) // 最大连接数
                    .minConnectionsPerHost(20)// 最小连接数
                    .build());
            defaultDb = this.client.getDatabase(databaseName);
            //用于统计查询
            mongo = new com.mongodb.Mongo(serverAddress);
            myMongo = mongo.getDB(databaseName);
        }catch (Exception e){
            System.out.println("我报异常了哈哈哈");
            e.printStackTrace();
        }
    }

    /**
     * 获得集合
     *
     * @param collectionName
     * @return
     */
    public MongoCollection<Document> getCollection(String collectionName) {
        return getCollection(defaultDb.getName(), collectionName);
    }

    private Map<String,MongoCollection<Document>> cache = new HashMap<>();

    /**
     * 获得集合
     *
     * @param datebase
     * @param collectionName
     * @return
     */
    public MongoCollection<Document> getCollection(String datebase, String collectionName) {
        MongoCollection<Document> collection;
        collection = cache.get(datebase + "_" + collectionName);
        if(collection != null){
            return collection;
        }
        if (client == null) {
            throw new MongoException("MongoClient Not Initialized");
        }

        if (datebase.equals(defaultDb.getName())) {
            collection = defaultDb.getCollection(collectionName);
        } else {
            collection = client.getDatabase(datebase).getCollection(collectionName);
        }
        if (datebase.equals(defaultDb.getName())) {
            switch (datebase){

                case DatabaseConfig.DATABASE_SHINE:


                    //检查有无建立时间索引，如果没有，则创建
                    ListIndexesIterable indexesIterable = collection.listIndexes();
                    MongoCursor indexCursor = indexesIterable.iterator();
                    boolean isCreateIndex = false;
                    while (indexCursor.hasNext()) {
                        Document indexDoc = (Document) indexCursor.next();
                        if (indexDoc.getString("name").equals("timeIndex")) {
                            isCreateIndex = true;
                            break;
                        }
                    }
                    if (!isCreateIndex) {
                        Document timeIndex = new Document().append("time", Mongo.DESC);
                        IndexOptions options = new IndexOptions();
                        options.background(true);
                        options.name("timeIndex");
                        collection.createIndex(timeIndex, options);
                    }

                    break;

                default:
                    break;
            }
        }
        cache.put(datebase + "_" + collectionName,collection);
        return collection;
    }

    /**
     * 查询数量
     *
     * @param collectionName
     * @param conditons
     * @return
     */
    public Long getCount(String collectionName, Map<String, Object> conditons) {
        return getCount(defaultDb.getName(), collectionName, conditons);
    }

    /**
     * 查询数量
     *
     * @param database
     * @param collectionName
     * @param conditons
     * @return
     */
    public Long getCount(String database, String collectionName, Map<String, Object> conditons) {
        if (client == null) {
            throw new MongoException("MongoClient Not Initialized");
        }
        MongoCollection table = getCollection(database, collectionName);
        BasicDBObject filter = buildConditon(conditons);
//        FindIterable findIterable;
//        if (filter != null) {
//            findIterable = table.find(filter);
//        } else {
//            findIterable = table.find();
//        }
//        findIterable.skip(10000).limit(1);
//        MongoCursor cursor = findIterable.iterator();
//        if (cursor.hasNext()) {
//            return 10000l;
//        }
        return table.count(filter);
    }


    /**
     * 默认数据库保存到指定的集合中，单文档
     *
     * @param collectionName
     * @param document
     */
    public void save(String collectionName, Document document) {
        save(databaseName, collectionName, document);
    }


    /**
     * 指定数据库保存到指定的集合中，单文档
     *
     * @param datebase
     * @param collectionName
     * @param document
     */
    public void save(String datebase, String collectionName, Document document) {
        if (client == null) {
            throw new MongoException("MongoClient Not Initialized");
        }
        MongoCollection collection = getCollection(datebase, collectionName);
        collection.insertOne(document);
//        getCollection(datebase, collectionName).insertOne(document);
    }

    /**
     * 默认数据库保存到指定的集合中，多文档
     *
     * @param collectionName
     * @param documents
     */
    public void save(String collectionName, List<Document> documents) {
        save(defaultDb.getName(), collectionName, documents);
    }

    /**
     * 指定数据库保存到指定的集合中，多文档
     *
     * @param datebase
     * @param collectionName
     * @param documents
     */
    public void save(String datebase, String collectionName, List<Document> documents) {
        if (client == null) {
            throw new MongoException("MongoClient Not Initialized");
        }
        getCollection(datebase, collectionName).insertMany(documents);
    }

    /**
     * 更新
     *
     * @param collectionName
     * @param _id
     * @param update
     * @return
     */
    public long update(String collectionName, String _id, Document update) {
        return update(defaultDb.getName(), collectionName, _id, update);
    }


    /**
     * 更新
     *
     * @param database
     * @param collectionName
     * @param _id
     * @param update
     * @return
     */
    public long update(String database, String collectionName, String _id, Document update) {
        Document filter = new Document();
        filter.put("_id", new ObjectId(_id));
        return update(database, collectionName, filter, update);
    }

    /**
     * 更新
     *
     * @param collectionName
     * @param filter
     * @param update
     * @return
     */
    public long update(String collectionName, Document filter, Document update) {
        return update(defaultDb.getName(), collectionName, filter, update);
    }


    /**
     * 更新
     *
     * @param database
     * @param collectionName
     * @param filter
     * @param update
     * @return
     */
    public long update(String database, String collectionName, Document filter, Document update) {
        if (client == null) {
            throw new MongoException("MongoClient Not Initialized");
        }
        Bson bson = Filters.eq("_id", filter.getObjectId("_id"));
        if (update.getObjectId("_id") != null) {
            update.remove("_id");
        }
        UpdateResult result = getCollection(database, collectionName).updateMany(bson, new Document("$set", update));
        return result.getModifiedCount();
    }

    /**
     * 按照条件查找
     *
     * @param collectionName
     * @param conditons
     * @param pageNum
     * @param pageSize
     * @param sort
     * @return
     */
    public List<Document> find(String collectionName, Map<String, Object> conditons, int pageNum, int pageSize, Map<String, Integer> sort) {
        return query(databaseName, collectionName, conditons, pageNum, pageSize, sort);
    }


    /**
     * 按照条件查找
     *
     * @param collectionName
     * @param conditons
     * @param sort
     * @return
     */
    public List<Document> find(String collectionName, Map<String, Object> conditons, Map<String, Integer> sort) {
        return query(databaseName, collectionName, conditons, sort);
    }


    /**
     * 按照条件查找
     *
     * @param collectionName
     * @param conditons
     * @param propertyNames  属性名
     * @param limitCount
     * @return
     */
    public List<Map<String, Object>> find(String collectionName, Map<String, Object> conditons, String[] propertyNames, int limitCount) {

        if (client == null) {
            throw new MongoException("MongoClient Not Initialized");
        }

        MongoCollection table = getCollection(defaultDb.getName(), collectionName);
        FindIterable findIterable = table.find();
        BasicDBObject findConditon = buildConditon(conditons);
        if (findConditon != null) {
            findIterable.filter(findConditon);
        }
        if (limitCount > -1) {
            findIterable.limit(limitCount);
        }

        MongoCursor cursor = findIterable.iterator();
        List<Map<String, Object>> result = new ArrayList<>();
        Map<String, Object> recordMap = null;


        while (cursor.hasNext()) {
            Document document = (Document) cursor.next();
            recordMap = new HashMap<>();
            for (String key : propertyNames) {
                recordMap.put(key == "phone" ? "dest_id" : key, document.get(key));
            }

            result.add(recordMap);
        }


        return result;
    }


    /**
     * 按照条件查找
     *
     * @param databseName
     * @param collectionName
     * @param conditons
     * @param pageNum
     * @param pageSize
     * @param sort
     * @return
     */
    public List<Document> find(String databseName, String collectionName, Map<String, Object> conditons, int pageNum, int pageSize, Map<String, Integer> sort) {
        return query(databseName, collectionName, conditons, pageNum, pageSize, sort);
    }


    /**
     * 查询一条记录
     *
     * @param collectionName
     * @param conditons
     * @param sort
     * @return
     */
    public Document findOne(String collectionName, Map<String, Object> conditons, Map<String, Integer> sort) {
        return findOne(defaultDb.getName(), collectionName, conditons, sort);
    }

    /**
     * 查询一条记录
     *
     * @param databseName
     * @param collectionName
     * @param conditons
     * @param sort
     * @return
     */
    public Document findOne(String databseName, String collectionName, Map<String, Object> conditons, Map<String, Integer> sort) {
        List<Document> documents = query(databseName, collectionName, conditons, 0, 1, sort);
        if (documents != null && !documents.isEmpty()) {
            return documents.get(0);
        }
        return null;
    }


    /**
     * 查询
     *
     * @param database
     * @param collectionName
     * @param conditons
     * @param pageNum
     * @param pageSize
     * @param sort
     * @return
     */
    private List<Document> query(String database, String collectionName, Map<String, Object> conditons, int pageNum, int pageSize, Map<String, Integer> sort) {
        if (client == null) {
            throw new MongoException("MongoClient Not Initialized");
        }
        MongoCollection table = getCollection(database, collectionName);
        FindIterable findIterable = table.find();
        BasicDBObject findConditon = buildConditon(conditons);
        if (findConditon != null) {
            findIterable.filter(findConditon);
        }
        if (pageNum > -1 && pageSize > 0) {
            findIterable.skip(pageNum * pageSize).limit(pageSize);
        }
        BasicDBObject findSort = buildSort(sort);
        if (sort != null) {
            findIterable.sort(findSort);
        }
        MongoCursor cursor = findIterable.iterator();
        List<Document> documents = new ArrayList<>();
        while (cursor.hasNext()) {
            Document document = (Document) cursor.next();
            documents.add(document);
        }
        return documents;
    }

    /**
     * 查询
     *
     * @param database
     * @param collectionName
     * @param conditons
     * @param sort
     * @return
     */
    private List<Document> query(String database, String collectionName, Map<String, Object> conditons, Map<String, Integer> sort) {
        if (client == null) {
            throw new MongoException("MongoClient Not Initialized");
        }
        MongoCollection table = getCollection(database, collectionName);
        FindIterable findIterable = table.find();
        BasicDBObject findCondition = buildConditon(conditons);
        if (findCondition != null) {
            findIterable.filter(findCondition);
        }
        BasicDBObject findSort = buildSort(sort);
        if (sort != null) {
            findIterable.sort(findSort);
        }
        MongoCursor cursor = findIterable.iterator();
        List<Document> documents = new ArrayList<>();
        while (cursor.hasNext()) {
            Document document = (Document) cursor.next();
            documents.add(document);
        }
        return documents;
    }


    /**
     * 构造筛选条件文档对象
     *
     * @param conditons
     * @return
     */
    public static BasicDBObject buildConditon(Map<String, Object> conditons) {
        if (conditons != null && !conditons.isEmpty()) {
            BasicDBObject document = new BasicDBObject();
            Set<String> keys = conditons.keySet();
            for (String string : keys) {
                Object ov = conditons.get(string);
                document.append(string, ov);
            }
            return document;
        }
        return null;
    }

    /**
     * 构造排序条件
     *
     * @param sort
     * @return
     */
    public static BasicDBObject buildSort(Map<String, Integer> sort) {
        if (sort != null && !sort.isEmpty()) {
            BasicDBObject document = new BasicDBObject();
            Set<String> keys = sort.keySet();
            for (String string : keys) {
                Integer ov = sort.get(string);
                document.append(string, ov);
            }
            return document;
        }
        return null;
    }

    /**
     * 批量更新
     *
     * @param collectionName
     * @param update
     * @param ids
     * @return
     */
    public long batchUpdate(String collectionName, Document update, List<ObjectId> ids) {
        if (client == null) {
            throw new MongoException("MongoClient Not Initialized");
        }
        Bson bson = Filters.in("_id", ids.toArray());
        if (update.getObjectId("_id") != null) {
            update.remove("_id");
        }
        UpdateResult result = getCollection(defaultDb.getName(), collectionName).updateMany(bson, new Document("$set", update));
        return result.getModifiedCount();
    }


    /**
     * 批量更新
     *
     * @param database
     * @param collectionName
     * @param update
     * @param ids
     * @return
     */
    public long batchUpdate(String database, String collectionName, Document update, List<ObjectId> ids) {
        if (client == null) {
            throw new MongoException("MongoClient Not Initialized");
        }
        Bson bson = Filters.in("_id", ids.toArray());
        if (update.getObjectId("_id") != null) {
            update.remove("_id");
        }
        UpdateResult result = getCollection(database, collectionName).updateMany(bson, new Document("$set", update));
        return result.getModifiedCount();
    }

    /**
     * 删除一条数据
     * @param database
     * @param collectionName
     * @param
     */
    public boolean deleteOne(String database, String collectionName, BasicDBObject condition){
        if (client == null) {
            throw new MongoException("MongoClient Not Initialized");
        }
        DeleteResult result=getCollection(database,collectionName).deleteOne(condition);
        return result.wasAcknowledged();
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPsw() {
        return psw;
    }

    public void setPsw(String psw) {
        this.psw = psw;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public Integer getPort() {
        return port;
    }

    public void setPort(Integer port) {
        this.port = port;
    }

    public String getDatabaseName() {
        return databaseName;
    }

    public void setDatabaseName(String databaseName) {
        this.databaseName = databaseName;
    }

}
