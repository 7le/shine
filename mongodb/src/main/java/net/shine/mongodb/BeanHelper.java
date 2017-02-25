package net.shine.mongodb;

import org.bson.Document;
import org.bson.types.ObjectId;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by hq
 *
 * 将对象转出范型
 */
public class BeanHelper {

    /**
     * 将查询出来的文档转化为对象
     *
     * @param documents
     * @return
     */
    public static <T> List<T> documentToRecords(List<Document> documents,Class<T> clazz) {
        List<T> list = new ArrayList<>();
        for (Document document : documents) {
            T t = documentToBean(document, clazz);
            list.add(t);
        }
        return list;
    }

    /**
     * document 转化为对象
     *
     * @param document
     * @return
     */
    public static <T> T documentToBean(Document document,Class<T> clazz) {
        try {
            T t = clazz.newInstance();
            Class c = t.getClass();
            Field[] fields = c.getDeclaredFields();
            for (Field field : fields) {
                /**
                 * 如果是静态跳过
                 */
                if(Modifier.isStatic(field.getModifiers())){
                    continue;
                }
                field.setAccessible(true);
                String name = field.getName();
                String setName = "set" + name.substring(0, 1).toUpperCase() + name.substring(1);
                String typeName = field.getType().getName();
                Method setMethod = t.getClass().getMethod(setName, field.getType());
                if (typeName.equals(ObjectId.class.getName())) {
                    setMethod.invoke(t, document.getObjectId("_id"));
                } else if (typeName.equals(List.class.getName())) {
                    List<Document> children_origin = (List) document.get(name);
                    //根据我们设置获得List的类型
                    String className = field.getName() + "_clazz";
                    Field list_field = c.getField(className);
                    Class List_clazz = (Class) list_field.get(clazz);

                    //设置子类型
                    List children = new ArrayList();
                    for(Document  o : children_origin){
                        children.add(documentToBean(o,List_clazz));
                    }
                    setMethod.invoke(t, children);
                }else {
                    Object o =  document.get(name);
                    if(o != null)
                        setMethod.invoke(t, o);
                }
            }

            return t;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static <T> Document deliverMsgToDocument(T t) {
        try {
            Document document = new Document();
            Class c = t.getClass();
            Field[] fields = c.getDeclaredFields();
            for (Field field : fields) {
                field.setAccessible(true);
                String type = field.getType().getName();
                Object value = field.get(t);

                if (type.equals(ObjectId.class.getName())) {
                    if (value != null) {
                        document.put("_id", new ObjectId(value.toString()));
                    }
                } else {
                    document.put(field.getName(), value);
                }
            }
            return document;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static <T> Document bean2Document(T t) {
        try {
            Document document = new Document();
            Class c = t.getClass();
            Field[] fields = c.getDeclaredFields();
            for (Field field : fields) {
                /**
                 * 如果是静态跳过
                 */
                if(Modifier.isStatic(field.getModifiers())){
                    continue;
                }

                field.setAccessible(true);
                String type = field.getType().getName();
                Object value = field.get(t);

                if (type.equals(ObjectId.class.getName())) {
                    if (value != null) {
                        document.put("_id", new ObjectId(value.toString()));
                    }
                } else  if(field.getType().equals(List.class)){
                    List list = (List) field.get(t);
                    List<Document> documentList = list2Document(list);
                    document.put(field.getName(),documentList);
                }else {
                    document.put(field.getName(), value);
                }
            }
            return document;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * List装换
     * @param list
     * @param <T>
     * @return
     */
    public static <T> List<Document> list2Document(List<T> list) {
        List<Document> documentList = new ArrayList<>();
        for(T t : list){
            Document document = bean2Document(t);
            documentList.add(document);
        }
        return documentList;
    }


}
