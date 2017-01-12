package com.shine.spider;


import net.shine.mongodb.BeanHelper;
import net.shine.mongodb.entity.InfoBean;
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

    public static InfoBean getData(int i) throws IOException {
        InfoBean infoBean = new InfoBean();
        Document doc = Jsoup.connect(baseUrl + i + ".html").header("User-Agent", "Mozilla/5.0 (Macintosh; U; Intel Mac OS X 10.4; en-US; rv:1.9.2.2) Gecko/20100316 Firefox/3.6.2").timeout(5000).get();

        if (doc.title() != null) {
            infoBean.setTitle(removeHtml(doc.title().substring(0, doc.title().toString().indexOf("-"))));
        }

        Element search = doc.select("#classpage6").get(2);
        //拿到图片
        Elements photos = search.select("img[src]");
        ArrayList photoList = new ArrayList();
        for (Element element : photos) {
            String photo = element.attr("src");
            photoList.add(photo);
        }
        infoBean.setPhoto(photoList);

        //拿到资源内容
        Pattern pattern1 = Pattern.compile("[\\ \\[\\]\\【\\\n\\　\\】]");
        Matcher matcher1 = pattern1.matcher(search.toString());
        String e = matcher1.replaceAll("");
        e.replace("&nbsp;","");
        int index = 0;
        if (e.indexOf("译名") > 0) {
            if(e.substring(+e.indexOf("译名")).indexOf("|")>0)
                index = (e.substring(+e.indexOf("译名")).indexOf("<br") < e.substring(+e.indexOf("译名")).indexOf("|")) ? e.substring(+e.indexOf("译名")).indexOf("<br") : e.substring(+e.indexOf("译名")).indexOf("|");
            else
                index = e.substring(+e.indexOf("译名")).indexOf("<br");
            infoBean.setTranslationName(removeHtml(e.substring(e.indexOf("译名") + 2, e.indexOf("译名") + index)));
        }
        if (e.indexOf("片名") > 0) {
            if(e.substring(+e.indexOf("片名")).indexOf("|")>0)
                index = (e.substring(+e.indexOf("片名")).indexOf("<br") < e.substring(+e.indexOf("片名")).indexOf("|")) ? e.substring(+e.indexOf("片名")).indexOf("<br") : e.substring(+e.indexOf("片名")).indexOf("|");
            else
                index = e.substring(+e.indexOf("片名")).indexOf("<br");
             infoBean.setName(removeHtml(e.substring(e.indexOf("片名") + 2, e.indexOf("片名") + index)));
        }
        if (e.indexOf("年代") > 0) {
            if(e.substring(+e.indexOf("年代")).indexOf("|")>0)
                index = (e.substring(+e.indexOf("年代")).indexOf("<br") > e.substring(+e.indexOf("年代")).indexOf("|")) ? e.substring(+e.indexOf("年代")).indexOf("<br") : e.substring(+e.indexOf("年代")).indexOf("|");
            else
                index = e.substring(+e.indexOf("年代")).indexOf("<br");
            infoBean.setYears(removeHtml(e.substring(e.indexOf("年代") + 2, e.indexOf("年代") + index)));
        }
        if (e.indexOf("国家") > 0) {
            if(e.substring(+e.indexOf("国家")).indexOf("|")>0)
                index = (e.substring(+e.indexOf("国家")).indexOf("<br") < e.substring(+e.indexOf("国家")).indexOf("|")) ? e.substring(+e.indexOf("国家")).indexOf("<br") : e.substring(+e.indexOf("国家")).indexOf("|");
            else
                index = e.substring(+e.indexOf("国家")).indexOf("<br");
            infoBean.setCountry(removeHtml(e.substring(e.indexOf("国家") + 2, e.indexOf("国家") + index)));
        }
        if (e.indexOf("类别") > 0) {
            if(e.substring(+e.indexOf("类别")).indexOf("|")>0)
                index = (e.substring(+e.indexOf("类别")).indexOf("<br") < e.substring(+e.indexOf("类别")).indexOf("|")) ? e.substring(+e.indexOf("类别")).indexOf("<br") : e.substring(+e.indexOf("类别")).indexOf("|");
            else
                index = e.substring(+e.indexOf("类别")).indexOf("<br");
            infoBean.setType(removeHtml(e.substring(e.indexOf("类别") + 2, e.indexOf("类别") + index)));
        }
        if (e.indexOf("语言") > 0) {
            if(e.substring(+e.indexOf("语言")).indexOf("|")>0)
                index = (e.substring(+e.indexOf("语言")).indexOf("<br") < e.substring(+e.indexOf("语言")).indexOf("|")) ? e.substring(+e.indexOf("语言")).indexOf("<br") : e.substring(+e.indexOf("语言")).indexOf("|");
            else
                index = e.substring(+e.indexOf("语言")).indexOf("<br");
            infoBean.setLanguage(removeHtml(e.substring(e.indexOf("语言") + 2, e.indexOf("语言") + index)));
        }
        if (e.indexOf("字幕") > 0) {
            if(e.substring(+e.indexOf("字幕")).indexOf("|")>0)
                index = (e.substring(+e.indexOf("字幕")).indexOf("<br") < e.substring(+e.indexOf("字幕")).indexOf("|")) ? e.substring(+e.indexOf("字幕")).indexOf("<br") : e.substring(+e.indexOf("字幕")).indexOf("|");
            else
                index = e.substring(+e.indexOf("字幕")).indexOf("<br");
            infoBean.setSubtitle(removeHtml(e.substring(e.indexOf("字幕") + 2, e.indexOf("字幕") + index)));
        }
        if (e.indexOf("上映时间") > 0) {
            if(e.substring(+e.indexOf("上映时间")).indexOf("|")>0)
                index = (e.substring(+e.indexOf("上映时间")).indexOf("<br") < e.substring(+e.indexOf("上映时间")).indexOf("|")) ? e.substring(+e.indexOf("上映时间")).indexOf("<br") : e.substring(+e.indexOf("上映时间")).indexOf("|");
            else
                index = e.substring(+e.indexOf("上映时间")).indexOf("<br");
            infoBean.setReleaseTime(removeHtml(e.substring(e.indexOf("上映时间") + 4, e.indexOf("上映时间") + index)));
        }
        if (e.indexOf("豆瓣评分") > 0) {
            if(e.substring(+e.indexOf("豆瓣评分")).indexOf("|")>0)
                index = (e.substring(+e.indexOf("豆瓣评分")).indexOf("<br") < e.substring(+e.indexOf("豆瓣评分")).indexOf("|")) ? e.substring(+e.indexOf("豆瓣评分")).indexOf("<br") : e.substring(+e.indexOf("豆瓣评分")).indexOf("|");
            else
                index = e.substring(+e.indexOf("豆瓣评分")).indexOf("<br");
            infoBean.setDbScore(removeHtml(e.substring(e.indexOf("豆瓣评分") + 4, e.indexOf("豆瓣评分") + index)));
        }
        if (e.indexOf("片长") > 0) {
            if(e.substring(+e.indexOf("片长")).indexOf("|")>0)
                index = (e.substring(+e.indexOf("片长")).indexOf("<br") < e.substring(+e.indexOf("片长")).indexOf("|")) ? e.substring(+e.indexOf("片长")).indexOf("<br") : e.substring(+e.indexOf("片长")).indexOf("|");
            else
                index = e.substring(+e.indexOf("片长")).indexOf("<br");
            infoBean.setTime(removeHtml(e.substring(e.indexOf("片长") + 2, e.indexOf("片长") + index)));
        }
        if (e.indexOf("导演") > 0) {
            if(e.substring(+e.indexOf("导演")).indexOf("|")>0)
                index = (e.substring(+e.indexOf("导演")).indexOf("<br") < e.substring(+e.indexOf("导演")).indexOf("|")) ? e.substring(+e.indexOf("导演")).indexOf("<br") : e.substring(+e.indexOf("导演")).indexOf("|");
            else
                index = e.substring(+e.indexOf("导演")).indexOf("<br");
            infoBean.setDirector(removeHtml(e.substring(e.indexOf("导演") + 2, e.indexOf("导演") + index)));
        }
        if (e.indexOf("主演") > 0) {
            if(e.substring(+e.indexOf("主演")).indexOf("|")>0)
                index = (e.substring(+e.indexOf("主演")).indexOf("<br") < e.substring(+e.indexOf("主演")).indexOf("|")) ? e.substring(+e.indexOf("主演")).indexOf("<br") : e.substring(+e.indexOf("主演")).indexOf("|");
            else
                index = e.substring(+e.indexOf("主演")).indexOf("<br");
            infoBean.setStar(removeHtml(e.substring(e.indexOf("主演") + 2, e.indexOf("主演") + index)));
        }
        if (e.indexOf("简介") > 0) {
            infoBean.setIntroduction(removeHtml(e.substring(e.indexOf("简介") + 2, e.indexOf("简介") + getCharacterPosition(e.substring(e.indexOf("简介"))))));
        } else if (e.indexOf("剧情介绍") > 0) {
            infoBean.setIntroduction(removeHtml(e.substring(e.indexOf("剧情介绍") + 4, e.indexOf("剧情介绍") + getCharacterPosition(e.substring(e.indexOf("剧情介绍"))))));
        }

        //拿到下载地址
        Elements download = search.select("a[href]");
        List urlInfoList = new ArrayList();
        for (Element element : download) {
            InfoBean.UrlInfo urlInfo = new InfoBean.UrlInfo();
            if ("".equals(element.text()) || element.text() != null) {
                urlInfo.setName(element.text());
                if (element.attr("href") == null || element.attr("href").equals("#") || element.attr("href").equals("")) {
                    String url = element.toString();
                    urlInfo.setUrl(url.substring(url.indexOf("thunder:"), url.indexOf("thunderpid") - 2));
                } else {
                    urlInfo.setUrl(element.attr("href"));
                }
                urlInfoList.add(urlInfo);
            }
        }
        infoBean.setUrlInfo(urlInfoList);
        return infoBean;
    }

    public static int getCharacterPosition(String string) {
        //这里是获取"/"符号的位置
        Matcher slashMatcher = Pattern.compile("<br").matcher(string);
        int mIdx = 0;
        while (slashMatcher.find()) {
            mIdx++;
            //当<br>符号第三次出现的位置
            if (mIdx == 3) {
                break;
            }
        }
        return slashMatcher.start();
    }

    public static String removeHtml(String str) {
        Pattern pattern = Pattern.compile("<.+?>", Pattern.DOTALL);
        Matcher matcher = pattern.matcher(str);
        return matcher.replaceAll("");
    }

    public static void main(String[] args) throws IOException {
        InfoBean infoBean = getData(1);
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
