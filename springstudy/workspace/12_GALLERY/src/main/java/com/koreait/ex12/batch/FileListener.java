package com.koreait.ex12.batch;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import org.quartz.CronScheduleBuilder;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;

/**
 * Application Lifecycle Listener implementation class FileListener
 *
 */
@WebListener
public class FileListener implements ServletContextListener {

	/* field */
	private Scheduler scheduler;
	
    /**
     * Default constructor. 
     */
    public FileListener() {
        // TODO Auto-generated constructor stub
    	try {
        	scheduler = new StdSchedulerFactory().getScheduler();
        } catch (Exception e) {
			e.printStackTrace();
		}
    }

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent sce)  { 
         // TODO Auto-generated method stub
    	try {
    		if (scheduler != null) {
    			scheduler.shutdown();
    		}
    	} catch (Exception e) {
			e.printStackTrace();
		}
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent sce)  { 
         // TODO Auto-generated method stub
    	try {
    		// 1) Top3Job
    		JobDetail job = JobBuilder.newJob(FileJob.class)
    				.withIdentity("job1", "group1")
    				.build();
    		// 2) Trigger
    		Trigger trigger = TriggerBuilder.newTrigger()
    				.withIdentity("trigger1", "group1")
    				.withSchedule(CronScheduleBuilder.cronSchedule("0 0/1 * 1/1 * ? *"))
    				.build();
    		// 3) scheduler에 job, trigger 등록
    		scheduler.scheduleJob(job, trigger);
    		// 4) scheduler 실행 시작
    		scheduler.start();
    	} catch (Exception e) {
			e.printStackTrace();
		}
    }
	
}
