package ex4_datetime;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Ex2_Date {

	public static void main(String[] args) {
		
		// java.util.Date
		Date now = new Date();
		System.out.println(now);
		
		// SimpleDateFormat 클래스
		// 날짜/시간 형식 지정 클래스
		
		// pattern
		// 1. 년도 : yyyy, yy
		// 2. 월   : MM, M
		// 3. 일   : dd, d
		// 4. 요일 : E
		// 5. 오전/오후 : a
		// 6. 시(12) : hh, h
		//    시(24) : HH, H
		// 7. 분     : mm, m
		// 8. 초     : ss, s
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd a h:mm");
		String result = sdf.format(now);
		System.out.println(result);
		
	}

}
