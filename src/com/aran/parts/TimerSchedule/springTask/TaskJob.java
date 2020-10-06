package com.aran.parts.TimerSchedule.springTask;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Author Aran
 * @Date 2020/7/31 4:58 下午
 */
@Service
public class TaskJob {
    public void job(){
        System.out.println( "执行时间：" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
    }

    @Scheduled(cron = "0/3 * * * * ?")
    public void annotationJob(){
        System.out.println("注解定时任务执行时间：" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
    }
}
