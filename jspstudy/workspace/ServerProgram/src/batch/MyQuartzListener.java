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
public class MyQuartzListener implements ServletContextListener {
	
	/* field */
	private Scheduler scheduler;
	
	/* constructor */
	public MyQuartzListener() {
		try {
        	scheduler = new StdSchedulerFactory().getScheduler();
        } catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/* method */
	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		try {
    		if (scheduler != null) {
    			scheduler.shutdown();
    		}
    	} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		try {
			JobDetail job = JobBuilder.newJob(MyQuartzJob.class)
					.withIdentity("job1", "group1")
					.build();
			Trigger trigger = TriggerBuilder.newTrigger()
					.withIdentity("trigger1", "group1")
					.withSchedule(CronScheduleBuilder.cronSchedule("0 0 12 ? * MON-FRI *"))
					.build();
			scheduler.scheduleJob(job, trigger);
			scheduler.start();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
