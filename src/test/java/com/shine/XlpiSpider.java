package com.shine;

import com.shine.service.ResourcesService;
import com.shine.spider.XlpuSpider;
import net.shine.mongodb.entity.InfoBean;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.IOException;

/**
 * Created by hq on 2016/11/8.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath*:spring.xml"})
public class XlpiSpider {

    @Autowired
    ResourcesService resourcesService;

    @Test
    public void spider1() throws Exception {
        XlpuSpider xlpuSpider =null;
/*12447*/
        for (int i = 1; i <= 44467; i++) {
            try {
                InfoBean infoBean = xlpuSpider.getData(i);

                resourcesService.saveRes(infoBean);

                System.out.println(i + ": " + infoBean.getSid());
            } catch (Exception e) {
                e.printStackTrace();
                continue;
            }
        }



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
