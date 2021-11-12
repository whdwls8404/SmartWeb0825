package ex.schedule;

import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SimpleScheduleBuilder;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;

public class SchedulerMainClass {

	public static void main(String[] args) {
		
		try {
			
			// Scheduler 생성
			Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();
			
			// scheduler 객체 실행 시작
			scheduler.start();
			
			// scheduler 객체가 처리할 HelloJob 생성
			JobDetail job = JobBuilder.newJob(HelloJob.class)
					.withIdentity("job1", "group1")
					.build();
			
			// scheduler 객체의 실제 스케쥴 동작 시점 생성
			Trigger trigger = TriggerBuilder.newTrigger()
					.withIdentity("trigger1", "group1")
					.startNow()
					.withSchedule(SimpleScheduleBuilder.simpleSchedule()
							.withIntervalInSeconds(5)
							.repeatForever())
					.build();
			
			// scheduler 객체에게 job과 trigger 알려 주기
			scheduler.scheduleJob(job, trigger);
			
			// scheduler 동작을 확인하기 위해서 일시 중지
			Thread.sleep(30000);  // 30초 sleep
			
			// 스케쥴러 종료
			scheduler.shutdown();
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
