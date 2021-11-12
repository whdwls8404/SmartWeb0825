package ex.schedule;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

/* Scheduler가 수행할 작업 : Job */
/* Job 인터페이스를 구현하면 된다. */

public class HelloJob implements Job {

	@Override
	public void execute(JobExecutionContext arg0) throws JobExecutionException {
		System.out.println("Hello World");
	}

}
