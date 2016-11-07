package com.shine.spider;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.FileWriter;
import java.io.IOException;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;


public class AntSpider {

    private final static String baseUrl = "http://www.btany.com/search/";

    public static String getData(String key) throws IOException {
        Document doc = Jsoup.connect(baseUrl + key + "-first-asc-1").header("User-Agent", "Mozilla/5.0 (Macintosh; U; Intel Mac OS X 10.4; en-US; rv:1.9.2.2) Gecko/20100316 Firefox/3.6.2").timeout(5000).get();
        Element element = doc.getElementsByClass("bottom-pager").first().children().last();
        String index = element.attr("href").toString();
        String pageNum = index.substring(index.lastIndexOf("-") + 1, index.length());
        int indexPage = Integer.valueOf(pageNum);
        System.out.println("当前搜索关键词共查询到" + indexPage + "个页面相关的数据!");

        StringBuffer sbf = new StringBuffer();
        for (int i = 1; i <= indexPage; i++) {
            System.out.println("当前已加载并分析第" + i + "个页面======================================================》》》");
            Document docIndex = Jsoup.connect(baseUrl + key + "-first-asc-" + i).header("User-Agent", "Mozilla/5.0 (Macintosh; U; Intel Mac OS X 10.4; en-US; rv:1.9.2.2) Gecko/20100316 Firefox/3.6.2").get();
            Elements search = docIndex.getElementsByClass("search-item");
            for (Element e : search) {
                sbf.append("链接名称:" + e.child(0).text() + "\n"
                                + e.child(2).child(0).text() + "\n"
                                + e.child(2).child(1).text() + "\n"
                                + e.child(2).child(2).text() + "\n"
                                + e.child(2).child(3).text() + "\n"
                                + e.child(2).child(4).text() + ":" + e.child(2).child(4).attr("href") + "\n"
                                + e.child(2).child(5).text() + ":" + e.child(2).child(5).attr("href") + "\n\n===========光蓝Comet=====================光蓝Comet=====================光蓝Comet==========================>>>\n\n"
                );
            }
        }
        System.out.println("恭喜您!页面加载完成...");
        return sbf.toString();
    }

    public static void main(String[] args) throws IOException {
        System.out.println("请输入需要查询的关键字o(^▽^)o。。。");
        String key = URLEncoder.encode(new Scanner(System.in).next(), "utf-8");
        System.out.println("正在为您在网上搜寻数据呦，请稍后。。。");
        String str = getData(key);
        FileWriter writer;
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
        }
    }

}