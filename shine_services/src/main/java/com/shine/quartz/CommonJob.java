package com.shine.quartz;

import org.apache.log4j.Logger;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.SchedulerContext;

/**
 * @author hq
 */
public class CommonJob implements Job {

    protected static final Logger quartzLogger = Logger.getLogger("quartz");					// WARN remind in llmao-wcback.log

    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        System.out.println("任务成功运行");
         try{
             //获取JobExecutionContext中的service对象
             SchedulerContext skedCtx = context.getScheduler().getContext();
             //获取SchedulerContext中的service
             //这里的service就是通过配置文件 配置的
//             UserInfoService userInfoService = (UserInfoService)skedCtx.get("userInfoService");
//             System.out.println(userInfoService);
//             System.out.println(userInfoService.getUserInfoById(1));
         }catch (Exception e){
             e.printStackTrace();
         }

    }
}
