package ex4_datetime;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Ex4_LocalDateTime {

	public static void main(String[] args) {
		
		// LocalDateTime 클래스
		// JDK 1.8 이후 최신 날짜/시간 클래스
		
		LocalDateTime now = LocalDateTime.now();
		System.out.println(now);

		int year = now.getYear();
		int month = now.getMonthValue();
		int day = now.getDayOfMonth();
		int hour = now.getHour();
		int minute = now.getMinute();
		int second = now.getSecond();
		
		System.out.println(year + "-" + month + "-" + day);
		System.out.println(hour + ":" + minute + ":" + second);
		
		// pattern 적용
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd a h:mm");
		String result = dtf.format(now);
		System.out.println(result);
		
	}

}
