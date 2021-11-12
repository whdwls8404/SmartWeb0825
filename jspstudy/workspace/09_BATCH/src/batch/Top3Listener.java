package batch;

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


@WebListener


public class Top3Listener implements ServletContextListener {

	/* field */
	private Scheduler scheduler;
	
	/* constructor */
    public Top3Listener() {
        try {
        	scheduler = new StdSchedulerFactory().getScheduler();
        } catch (Exception e) {
			e.printStackTrace();
		}
    }

	/* method */
    public void contextDestroyed(ServletContextEvent sce)  { 
    	try {
    		if (scheduler != null) {
    			scheduler.shutdown();
    		}
    	} catch (Exception e) {
			e.printStackTrace();
		}
    }

    public void contextInitialized(ServletContextEvent sce)  { 
    	try {
    		// 1) Top3Job
    		JobDetail job = JobBuilder.newJob(Top3Job.class)
    				.withIdentity("job3", "group3")
    				.build();
    		// 2) Trigger
    		Trigger trigger = TriggerBuilder.newTrigger()
    				.withIdentity("trigger3", "group3")
    				.withSchedule(CronScheduleBuilder.cronSchedule("0 29 11 1/1 * ? *"))
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
