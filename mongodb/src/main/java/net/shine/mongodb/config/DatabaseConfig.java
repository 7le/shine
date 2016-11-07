package net.shine.mongodb.config;

/**
 * Created by hq
 */
public interface DatabaseConfig {

    /**
     * 数据库1 (shine)
     */
    String DATABASE_SHINE = "shine";

    /**
     * 数据库2
     */
    String DATABASE_2 = "";


    /**
     * 数据库3
     */

    interface DATABASE_3{
        //数据库
        String DATABASE_3 = "";

        /**
         * 集合
         */
        String COLLECTION_MATERIAL = "";
    }
}
