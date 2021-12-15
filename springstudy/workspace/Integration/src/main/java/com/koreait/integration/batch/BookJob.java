package com.koreait.integration.batch;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

public class BookJob implements Job {

	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException {
		
		// 저자 "황순원", "생텍쥐베리" 중 임의로 한 명의 정보를 이용하여 도서를 검색한
		// 결과를 출력하시오. (파일을 생성하시오.)

	}

}
