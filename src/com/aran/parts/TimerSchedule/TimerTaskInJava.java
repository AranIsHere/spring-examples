package com.aran.parts.TimerSchedule;

import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.*;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author Aran
 * @Date 2020/7/29 5:59 下午
 */
public class TimerTaskInJava {

    ScheduledExecutorService scheduledExecutorService =
            Executors.newScheduledThreadPool(1);

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        new TimerTaskInJava().testScheduledExecutorService4();


    }


    /**
     *  测试Timer
     */
    public void testTimer() {
        Timer timer = new Timer();

        timer.scheduleAtFixedRate(new TimerTask() {

            @Override
            public void run() {
                System.out.println("hello Aran at->" + System.currentTimeMillis());
            }
        }, 2000, 3000);
    }


    /**
     * 测试ScheduledExecutorService中的schedule[Runnable]
     */
    public static void testScheduledExecutorService1(){
        ScheduledExecutorService scheduledExecutorService =
                Executors.newScheduledThreadPool(1);

        scheduledExecutorService.schedule(new Runnable() {
            @Override
            public void run() {
                System.out.println(" 使用ScheduledExecutorService延迟执行任务" + new Date());
            }
        }, 2, TimeUnit.SECONDS);
        scheduledExecutorService.shutdown();
    }

    /**
     * 测试ScheduledExecutorService中的schedule[Callable]
     */
    public  void testScheduledExecutorService2() throws ExecutionException, InterruptedException {

     ScheduledFuture<String> s =  scheduledExecutorService.schedule(new Callable<String>() {

            @Override
            public String call() throws Exception {
                return "hello Aran!";
            }
        }, 2, TimeUnit.SECONDS);
        String theValue   = s.get();
        System.out.println("得到的返回值是：" + theValue);
        scheduledExecutorService.shutdown();
    }


    private final AtomicInteger count = new AtomicInteger(0);
    /**
     * 测试ScheduledExecutorService中的scheduleAtFixedRate​
     */

    public  void testScheduledExecutorService3() {
        System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));

     Runnable beep = new Runnable(){
         int  i = 0;
         @Override
         public void run() {
             count.getAndIncrement();
             System.out.println("输出时间:" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
             if(count.get() == 5){
                 System.out.println("条件达标，结束定时任务！");
                 scheduledExecutorService.shutdown();
             }
         }
     };
     scheduledExecutorService.scheduleAtFixedRate(beep,3, 4, TimeUnit.SECONDS);


    }

    /**
     * 测试ScheduledExecutorService中的scheduleWithFixedDelay​
     */
    public  void testScheduledExecutorService4() {
        System.out.println("开始执行时间：" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));

        Runnable beep = new Runnable(){
            int  i = 0;
            @Override
            public void run() {
                count.getAndIncrement();
                System.out.println("输出时间:" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
                if(count.get() == 5){
                    System.out.println("条件达标，结束定时任务！");
                    scheduledExecutorService.shutdown();
                }
            }
        };
        scheduledExecutorService.scheduleWithFixedDelay(beep,3, 4, TimeUnit.SECONDS);


    }
}
