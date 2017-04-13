package com.unionx.core.task;


import org.apache.log4j.Logger;
import org.quartz.*;
import org.quartz.impl.matchers.GroupMatcher;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 功能：任务调度
 * Author:Yang yanli
 */


public class TaskSchedule{

    public Scheduler getScheduler() {
        return scheduler;
    }

    public void setScheduler(Scheduler scheduler) {
        this.scheduler = scheduler;
    }

    private Scheduler scheduler;

//
//    static {
//        ApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");
//        scheduler = (StdScheduler) context.getBean("quartzScheduler");
//    }
//    private static SchedulerFactory schedulerFactory = new StdSchedulerFactory();

    private static final Logger logger = Logger.getLogger(TaskSchedule.class);

    /**
     * 添加一个任务
     * @param jobName 任务名
     * @param jobGroupName 任务组名
     * @param triggerName 触发器名
     * @param triggerGroupName 触发器组名
     * @param cronExpression    时间设置，参考quartz说明文档
     */
   public void startSchedule(String jobName, String jobGroupName, String triggerName, String triggerGroupName,
                                    Job job, Map<String,Object> paramMap, String cronExpression)
                               throws Exception{
            JobDetail jobDetail = JobBuilder.newJob(job.getClass()).withIdentity(jobName, jobGroupName).build();
            jobDetail.getJobDataMap().putAll(paramMap);
            Trigger trigger=TriggerBuilder.newTrigger().withIdentity(triggerName,triggerGroupName).withSchedule(CronScheduleBuilder.cronSchedule(cronExpression)).startNow().build();
//            Scheduler scheduler = schedulerFactory.getScheduler();
            scheduler.scheduleJob(jobDetail, trigger);
    }

    /**
     * 从数据库中找到已经存在的job，并重新开户调度
     */
//    @PostConstruct
    public void resumeJob(){
            try {
//                Scheduler scheduler = schedulerFactory.getScheduler();
                scheduler.start();
            } catch (Exception e) {
                logger.error("", e);
            }
        }

    /**
     * 获取所有任务key
     * @throws SchedulerException
     */
    public List<Trigger> getAllTrigger(){
        List<Trigger> triggerList = new ArrayList<>();
        try {
//            Scheduler scheduler = schedulerFactory.getScheduler();
            Set<TriggerKey> triggers = scheduler.getTriggerKeys(GroupMatcher.anyTriggerGroup());
            for(TriggerKey triggerKey : triggers){
                Trigger trigger = scheduler.getTrigger(triggerKey);
                triggerList.add(trigger);
            }
        }catch (Exception e){
            logger.error("", e);
        }
        return triggerList;
    }

    /**
	 * 删除任务
	 */
	public boolean deleteJob(JobKey jobKey){
		try {
//            Scheduler scheduler = schedulerFactory.getScheduler();
            scheduler.deleteJob(jobKey);// 删除任务
        } catch (Exception e) {
            logger.error("", e);
        }
        return true;
	}

    /**
     * 删除任务组
     */
    public void deleteGroupJob(String jobGroupName) {
        try {
//            Scheduler scheduler = schedulerFactory.getScheduler();
            Set<JobKey> jobKeys = scheduler.getJobKeys(GroupMatcher.jobGroupEquals(jobGroupName));
            List<JobKey> jobKeyList = new ArrayList<>();
            for (JobKey jobKey : jobKeys) {
                jobKeyList.add(jobKey);
            }
            scheduler.deleteJobs(jobKeyList);
        } catch (Exception e) {
            logger.error("", e);
        }
    }

    /**
     * shutdown
     */
//    @PreDestroy
    public void shutdown() {
        try {
//            Scheduler scheduler = schedulerFactory.getScheduler();
            scheduler.shutdown();
        } catch (Exception e) {
            logger.error("", e);
        }
    }

//     public static void main(String[] args) throws SchedulerException {
//        TaskSchedule taskSchedule = new TaskSchedule();
//        taskSchedule.startSchedule("deleteJob", "remind", "deleteTrigger","yunwei",new DeleteRemindJob(),null,"0 0 10 */3 * ?");
//         Scheduler scheduler = schedulerFactory.getScheduler();
//         scheduler.start();
//     }

}
