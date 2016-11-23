package net.shine.mongodb.utils;


import com.jfinal.kit.PathKit;

import java.io.*;
import java.nio.charset.Charset;
import java.util.Properties;

/**
 * Properties 工具类
 *
 */
public class PropertiesUtil {

    /**
     * 加载properties
     *
     * @param file WEB-INF/classes下
     * @return
     */
    public static Properties loadPropertyFile(String file) {
        Properties properties = null;
        if (StringUtil.isEmpty(file) || file.contains("..")) {
            return null;
        }
        InputStream inputStream = null;
        InputStreamReader inputStreamReader = null;
        String fullFile; // String fullFile = PathUtil.getWebRootPath() + file;
        String rootPath = PropertiesUtil.class.getResource("/").getPath();
        if (file.startsWith(File.separator)) {
            fullFile = rootPath.substring(0, rootPath.length() - 1) + file;
        } else {
            fullFile = rootPath + File.separator + file;
        }
        try {
            inputStream = new FileInputStream(new File(fullFile));
            Properties p = new Properties();
            inputStreamReader = new InputStreamReader(inputStream, Charset.forName("UTF-8"));
            p.load(inputStreamReader);
            properties = p;
        } catch (FileNotFoundException e) {
            throw new IllegalArgumentException("Properties file not found: "
                    + fullFile);
        } catch (IOException e) {
            throw new IllegalArgumentException(
                    "Properties file can not be loading: " + fullFile);
        } finally {
            try {
                if (inputStream != null) {
                    inputStream.close();
                }
                if (inputStreamReader != null) {
                    inputStreamReader.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return properties;
    }

    /**
     * 保存配置文件
     *
     * @param properties
     * @return
     */
    public synchronized static boolean savePropertyFile(Properties properties, String file) {
        try {
            String fullFile; // String fullFile = PathUtil.getWebRootPath() + file;
            if (file.startsWith(File.separator))
                fullFile = PathKit.getWebRootPath() + File.separator + "WEB-INF"
                        + File.separator + "classes" + file;
            else
                fullFile = PathKit.getWebRootPath() + File.separator + "WEB-INF"
                        + File.separator + "classes" + File.separator + file;
            OutputStream outputStream = new FileOutputStream(fullFile);
            properties.store(outputStream, "");
            outputStream.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

}
