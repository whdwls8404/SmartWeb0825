package ex4_datetime;

import java.sql.Date;

public class Ex3_Date {

	public static void main(String[] args) {
		
		// java.sql.Date
		// DB에 저장하기 위한 Date
		
		Date now = new Date(System.currentTimeMillis());
		System.out.println(now);

	}

}
