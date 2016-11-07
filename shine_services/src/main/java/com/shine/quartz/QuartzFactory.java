package com.shine.quartz;

import com.shine.util.TimeUtil;
import org.quartz.*;

import java.util.Map;

import static org.quartz.JobBuilder.newJob;
import static org.quartz.SimpleScheduleBuilder.simpleSchedule;
import static org.quartz.TriggerBuilder.newTrigger;

/**
 * Created by hq
 */
public class QuartzFactory {

    private Scheduler scheduler;

    /**
     * 定时开始任务
     *
     * @param startTime yyyy-MM-dd HH:mm:ss 格式
     * @param id
     * @param name
     * @param group
     * @param jobClass
     */
    public void startJobOnce(String startTime, int id, String name, String group, Class<? extends Job> jobClass, Map<String, Object> data) {
        startJob(startTime, id, name, group, 0, 0, jobClass, data);
    }

    /**
     * 从置顶时间开始，指定间隔时间内重复进行调度任务
     *
     * @param startTime
     * @param id
     * @param name
     * @param group
     * @param repeatCount
     * @param interval
     * @param jobClass
     */
    public void startJob(String startTime, int id, String name, String group, int repeatCount, int interval, Class<? extends Job> jobClass, Map<String, Object> data) {
        try {
            JobDetail job = newJob(jobClass)
                    .withIdentity("job_" + name + "_" + id, "group_" + group + "_" + id)
                    .requestRecovery()
                    .build();
            if (data!=null){
                job.getJobDataMap().putAll(data);
            }
            // 定时执行
            SimpleTrigger trigger = newTrigger()
                    .withIdentity("trigger_" + name + "_" + id, "group_" + group + "_" + id)
                    .startAt(TimeUtil.stringToDate2(startTime))
                    .withSchedule(simpleSchedule()
                            .withIntervalInSeconds(interval)
                            .withRepeatCount(repeatCount))
                    .build();
            scheduler.scheduleJob(job, trigger);
            scheduler.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 停止任务
     *
     * @param name
     * @param group
     * @param id
     */
    public void stopJob(String name, String group, int id) {
        try {
            TriggerKey triggerKey = TriggerKey.triggerKey("trigger_" + name + "_" + id, "group_" + group + "_" + id);
            Trigger trigger = scheduler.getTrigger(triggerKey);
            if (trigger != null) {
                scheduler.pauseTrigger(triggerKey);
                scheduler.unscheduleJob(triggerKey);
                scheduler.deleteJob(trigger.getJobKey());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setScheduler(Scheduler scheduler) {
        this.scheduler = scheduler;
    }
}
