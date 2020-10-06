package com.aran.parts.TimerSchedule.quartz;

        import org.quartz.JobExecutionContext;
        import org.quartz.JobExecutionException;
        import org.springframework.scheduling.quartz.QuartzJobBean;

        import java.text.SimpleDateFormat;
        import java.util.Date;

/**
 * @Author Aran
 * @Date 2020/7/30 11:38 下午
 */
public class myQuartzJob extends QuartzJobBean {

    private Integer timeout;

    public void setTimeout(Integer timeout) {
        this.timeout = timeout;
    }

    @Override
    protected void executeInternal(JobExecutionContext jobExecutionContext) throws JobExecutionException {

        System.out.println(String.format(Thread.currentThread().getName() + "执行时间：" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date())));
    }
}
