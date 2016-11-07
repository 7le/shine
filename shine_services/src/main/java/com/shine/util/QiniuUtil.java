package com.xidian.neptune.smsplatform.util;

import com.qiniu.common.QiniuException;
import com.qiniu.http.Response;
import com.qiniu.storage.UploadManager;
import com.qiniu.util.Auth;
import com.shine.util.BaseConstant;

import java.io.*;

/**
 * 七云储存工具
 *
 */
public class QiniuUtil {

    /**
     * 简单上传
     *
     * @param date
     * @param key
     * @throws IOException
     */
    public static void simpleUpload(byte[] date, String key) throws IOException {
        try {
            //调用put方法上传
            Response res = uploadManager.put(date, key, getUpToken0());
        } catch (QiniuException e) {
         /*   Response r = e.response;
            // 请求失败时打印的异常的信息
            System.out.println(r.toString());
            try {
                //响应的文本信息
                System.out.println(r.bodyString());
            } catch (QiniuException e1) {
            }*/
        }
    }


    /************************/

    public static final String IMG_TYPE = ".jpg|.jepg|.gif|.png|.bmp";
    public static final String ALL_TYPE = ".jpg|.jepg|.gif|.png|.bmp|.gz|.rar|.zip|.pdf|.txt|.swf|.wmv|.doc|.docx";

    private static Auth auth = Auth.create(BaseConstant.QINIU_ACCESS_KEY, BaseConstant.QINIU_SECRET_KEY);
    private static UploadManager uploadManager = new UploadManager();

    /**
     * 获得文件拓展名
     * @param fileName
     * @return
     */
    public static String getFileType(String fileName){
        return fileName.substring(fileName.lastIndexOf('.'), fileName.length());
    }

    /**
     * 检查类型
     * @param fileName
     * @param isImg
     * @return
     */
    public static boolean checkFileType(String fileName, boolean isImg) {
        String fileType = getFileType(fileName);
        if (isImg) {
            return IMG_TYPE.indexOf(fileType.toLowerCase()) == -1;
        } else {
            return ALL_TYPE.indexOf(fileType.toLowerCase()) == -1;
        }
    }

    //要上传的空间
    private static final String BUCKETNAME = "llmao";
    /**
     * 获得空间
     * @return
     */
    public static String getUpToken0(){
        return auth.uploadToken(BUCKETNAME);
    }

    /**
     * 上传文件
     * @param data 数据
     * @param key 文件名，如果为null  则文件名自动生成
     * @return
     */
    public static String uploadFile(byte[] data,String key)  {
        try {
            Response res = uploadManager.put(data,key,getUpToken0());
            MyRet ret = null;
            ret = res.jsonToObject(MyRet.class);
            if(res.isOK()){
                return BaseConstant.QINIU_BUCKET_URL + ret.getKey() ;//+ BaseConstant.SPLIT  + BaseConstant.STYLE;
            }else {
                return null;
            }
        } catch (QiniuException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 公共上传文件
     * @param data 数据
     * @param key 文件名，如果为null  则文件名自动生成
     * @return
     */
    public static String uploadFilePublick(byte[] data,String key)  {
        try {
            Response res = uploadManager.put(data,key,auth.uploadToken("llmaopublic"));
            MyRet ret = res.jsonToObject(MyRet.class);
            if(res.isOK()){
                return BaseConstant.QINIU_BUCKET_PUBLIC_URL + ret.getKey() ;//+ BaseConstant.SPLIT  + BaseConstant.STYLE;
            }else {
                return null;
            }
        } catch (QiniuException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 上传文件
     * @param file 文件
     * @param key 文件名，如果为null  则文件名自动生成
     * @return
     */
    public static String uploadFile(File file,String key)  {
        try {
            Response res = uploadManager.put(file,key,getUpToken0());
            MyRet ret = res.jsonToObject(MyRet.class);
            if(res.isOK()){
                return BaseConstant.QINIU_BUCKET_URL + ret.getKey() ;//+ BaseConstant.SPLIT  + BaseConstant.STYLE;
            }else {
                return null;
            }
        } catch (QiniuException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 验证地址
     * @param url  原地址
     * @param availableTime 可用实际那
     * @return
     */
    static Long DEFAULT_TIME = 7200L;// 7200秒
    public static String getAuthUrl( String url,Long availableTime){
        if(availableTime == null)
            availableTime = DEFAULT_TIME;
        String downloadRUL = auth.privateDownloadUrl(url,availableTime);
        return  downloadRUL;
    }

    public static void main(String[] args) {
//        String a = "http://image.5iliulang.com/guangyawy_8c9skc1a4m_新建文本文档.txt";
//        System.out.println(getAuthUrl(a,3600L));
//            byte[] buff ;
//            InputStream is = new FileInputStream(new File("F:/a.jpg"));
//            ByteArrayOutputStream bos = new ByteArrayOutputStream(1000);
//            byte[] b = new byte[1000];
//            int n;
//            while ((n = is.read(b)) != -1) {
//                bos.write(b, 0, n);
//            }
//            is.close();
//            bos.close();
//            buff = bos.toByteArray();
//            String token = getUpToken0();
//            String fileName = uploadFile(new File("F:/a.jpg"),"呵呵",token);
//            System.out.println(fileName);



    }
//    public static void deleteFile(String url){
//        Mac mac = new Mac(Config.ACCESS_KEY, Config.SECRET_KEY);
//        RSClient client = new RSClient(mac);
//        String key = url.substring(url.lastIndexOf("/")+1);
//        client.delete(Config.QINIU_BUCKET, key);
//    }

    /**
     * 返回对象
     */
    public static class MyRet {
        public long fsize;
        public String key;
        public String hash;
        public int width;
        public int height;

        public long getFsize() {
            return fsize;
        }

        public void setFsize(long fsize) {
            this.fsize = fsize;
        }

        public String getKey() {
            return key;
        }

        public void setKey(String key) {
            this.key = key;
        }

        public String getHash() {
            return hash;
        }

        public void setHash(String hash) {
            this.hash = hash;
        }

        public int getWidth() {
            return width;
        }

        public void setWidth(int width) {
            this.width = width;
        }

        public int getHeight() {
            return height;
        }

        public void setHeight(int height) {
            this.height = height;
        }
    }
}
