package com.shine.spider;

import net.sedion.mongodb.BeanHelper;
import net.sedion.mongodb.entity.InfoBean;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.io.IOException;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by hq on 2016/11/2.
 */
public class XlpuSpider {
    private final static String baseUrl = "http://www.xlpu.cc/html/";

    public static InfoBean getData() throws IOException {
        InfoBean infoBean=new InfoBean();
        Document doc = Jsoup.connect(baseUrl + "41253.html").header("User-Agent", "Mozilla/5.0 (Macintosh; U; Intel Mac OS X 10.4; en-US; rv:1.9.2.2) Gecko/20100316 Firefox/3.6.2").timeout(5000).get();

        infoBean.setTitle(doc.title());

        Element search = doc.select("#classpage6").get(2);
        //拿到图片
        Elements photos = search.select("img[src]");
        List photoList =new ArrayList();
        for (Element element : photos) {
            String photo = element.attr("src");
            photoList.add(photo);
        }
        infoBean.setPhoto(photoList);

        //拿到资源内容
        String e=search.toString();
        e = e.replace(" ", "");
        e =e.replace("　","");
        e =e.replace("\n", "");
        if (e.indexOf("译名") > 0) {
            infoBean.setTranslationName(e.substring(e.indexOf("译名")+2, e.indexOf("译名") + e.substring(+e.indexOf("译名")).indexOf("<br")));
        }
        if (e.indexOf("片名") > 0) {
            infoBean.setName(e.substring(e.indexOf("片名")+2, e.indexOf("片名") + e.substring(+e.indexOf("片名")).indexOf("<br")));
        }
        if (e.indexOf("年代") > 0) {
            infoBean.setYears(e.substring(e.indexOf("年代")+2, e.indexOf("年代") + e.substring(+e.indexOf("年代")).indexOf("<br")));
        }
        if (e.indexOf("国家") > 0) {
            infoBean.setCountry(e.substring(e.indexOf("国家")+2, e.indexOf("国家") + e.substring(+e.indexOf("国家")).indexOf("<br")));
        }
        if (e.indexOf("类别") > 0) {
            infoBean.setType(e.substring(e.indexOf("类别")+2, e.indexOf("类别") + e.substring(+e.indexOf("类别")).indexOf("<br")));
        }
        if (e.indexOf("语言") > 0) {
            infoBean.setLanguage(e.substring(e.indexOf("语言")+2, e.indexOf("语言") + e.substring(+e.indexOf("语言")).indexOf("<br")));
        }
        if (e.indexOf("字幕") > 0) {
            infoBean.setSubtitle(e.substring(e.indexOf("字幕")+2, e.indexOf("字幕") + e.substring(+e.indexOf("字幕")).indexOf("<br")));
        }
        if (e.indexOf("上映时间") > 0) {
            infoBean.setReleaseTime(e.substring(e.indexOf("上映时间")+4, e.indexOf("上映时间") + e.substring(+e.indexOf("上映时间")).indexOf("<br")));
        }
        if (e.indexOf("豆瓣评分") > 0) {
            infoBean.setDbScore(e.substring(e.indexOf("豆瓣评分")+4, e.indexOf("豆瓣评分") + e.substring(+e.indexOf("豆瓣评分")).indexOf("<br")));
        }
        if (e.indexOf("片长") > 0) {
            infoBean.setTime(e.substring(e.indexOf("片长")+2, e.indexOf("片长") + e.substring(+e.indexOf("片长")).indexOf("<br")));
        }
        if (e.indexOf("导演") > 0) {
            infoBean.setDirector(e.substring(e.indexOf("导演")+2, e.indexOf("导演") + e.substring(+e.indexOf("导演")).indexOf("<br")));
        }
        if (e.indexOf("主演") > 0) {
            infoBean.setStar(e.substring(e.indexOf("主演")+2, e.indexOf("主演") + e.substring(+e.indexOf("主演")).indexOf("<br")));
        }
        if (e.indexOf("简介") > 0) {
            infoBean.setIntroduction(e.substring(e.indexOf("简介")+2, e.indexOf("简介") + getCharacterPosition(e.substring(e.indexOf("简介")))));
        }else if(e.indexOf("剧情介绍") > 0){
            infoBean.setIntroduction(e.substring(e.indexOf("剧情介绍")+4, e.indexOf("剧情介绍") + getCharacterPosition(e.substring(e.indexOf("剧情介绍")))));
        }

        //拿到下载地址
        Elements download = search.select("a[href]");
        Map map=new HashMap();
        for (Element element : download) {
            if ("".equals(element.text()) || element.text() != null){
                if (element.attr("href") == null || element.attr("href").equals("#") || element.attr("href").equals("")) {
                    String url = element.toString();
                    map.put(element.text(),url.substring(url.indexOf("thunder:"), url.indexOf("thunderpid") - 2));
                } else {
                    map.put(element.text(),element.attr("href"));
                }
            }
        }
        infoBean.setUrl(map);
        return infoBean;
    }

    public static int getCharacterPosition(String string){
        //这里是获取"/"符号的位置
        Matcher slashMatcher = Pattern.compile("<br").matcher(string);
        int mIdx = 0;
        while(slashMatcher.find()) {
            mIdx++;
            //当<br>符号第三次出现的位置
            if(mIdx == 3){
                break;
            }
        }
        return slashMatcher.start();
    }

    public static void main(String[] args) throws IOException {
        InfoBean infoBean = getData();
        org.bson.Document document = BeanHelper.bean2Document(infoBean);


        System.out.print(infoBean.toString());
/*        FileWriter writer;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
        String id = simpleDateFormat.format(new Date());
        try {
            System.out.println("正在为您写入文件。。。");
            writer = new FileWriter(id + ".txt");
            writer.write(str);
            writer.flush();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            System.out.println("恭喜您，文件写入完成!,文件名是" + id + ".txt");
        }*/
    }
}
