package com.shine.util;

import java.io.*;

/**
 * 对象序列化工具
 *
 * @author hq 2016/6/29
 */
public class SerializableUtil {


    public static byte[] serialize(Object object) {
        try (
                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                ObjectOutputStream oos = new ObjectOutputStream(baos);
                ){
            //序列化
            oos.writeObject(object);
            baos.flush();
            byte[] bytes = baos.toByteArray();

            return bytes;
        } catch (Exception e) {
            return null;
        }
    }


    public static Object unserialize(byte[] bytes) {
        ByteArrayInputStream bais = null;
        ObjectInputStream ois = null;
        try {
            //反序列化
            bais = new ByteArrayInputStream(bytes);
            ois = new ObjectInputStream(bais);

            return ois.readObject();
        } catch (Exception e) {
            return null;
        } finally {
            try {
                bais.close();
                ois.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
