package com.unionx.core.task;

import org.apache.log4j.Logger;
import org.apache.shiro.util.CollectionUtils;
import org.quartz.*;

import java.util.Date;
import java.util.List;

/**
 * 功能：执行任务调度
 * Author:Yang yanli
 */

/**
 * @PersistJobDataAfterExecution //保存在JobDataMap传递的参数
 * @DisallowConcurrentExecution //保证多个任务间不会同时执行
 */
@PersistJobDataAfterExecution
@DisallowConcurrentExecution
public class DeleteRemindJob implements Job{

    private static final Logger logger = Logger.getLogger(DeleteRemindJob.class);

    @Override
    public void execute(JobExecutionContext context){
        logger.error("删除任务执行了一次");
        try {
            TaskSchedule taskSchedule = new TaskSchedule();
            List<Trigger> allTrigger = taskSchedule.getAllTrigger();
            if(!CollectionUtils.isEmpty(allTrigger)){
                for (Trigger trigger : allTrigger){
                    Date startTime = trigger.getStartTime();//获取触发器创建时间
                    Long timeMillis = System.currentTimeMillis();
                    Long createTime = startTime.getTime();
                    Long days = 7775999000L;
                    if(timeMillis - createTime > days){
                        JobKey jobKey = trigger.getJobKey();//获取触发器任务
                        if(jobKey.getGroup().contains("remind")){
                            taskSchedule.deleteJob(jobKey);
                        }
                    }
                }
            }
        }catch (Exception e){
            logger.error("删除90天后到期的任务",e);
        }
    }
}
