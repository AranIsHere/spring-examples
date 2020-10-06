package com.aran.parts.TimerSchedule.quartz;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

/**
 * @Author Aran
 * @Date 2020/7/31 8:52 上午
 */
public class Main {
    public static void main(String[] args) {
        ApplicationContext ctx = new FileSystemXmlApplicationContext(
                "web/WEB-INF/applicationContext.xml");
    }
}
