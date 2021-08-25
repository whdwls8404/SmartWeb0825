package ex4_datetime;

public class Ex1_System {

	public static void main(String[] args) {
		
		// 1. timestamp
		// 1970-01-01 0:00 부터 1/1000초마다 증가하는 정수 값
		long timestamp = System.currentTimeMillis();
		System.out.println(timestamp);
		
		// 2. nanotime
		// 어떤 기준은 없다.
		// 현재 시간을 1/1,000,000,000초 단위로 표시하는 정수 값
		// 경과 시간을 계산할 때 사용
		long begin = System.nanoTime();
		int total = 0;
		for (int n = 1; n <= 1000000; n++) {
			total += n;
		}
		long end = System.nanoTime();
		
		System.out.println("경과시간: " + (end - begin) / 1000000000.0 + "초");
		
	}

}
