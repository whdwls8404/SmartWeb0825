package ex2_Set;

import java.util.*;

public class MainClass {

	public static void method1() {
		
		// Set
		// 1. 저장 순서가 없다. (인덱스가 없다.)
		// 2. 중복 저장이 불가능하다.

		// 생성
		Set<String> subjects = new HashSet<String>();
		
		// 데이터 추가
		subjects.add("자바");
		subjects.add("자바");
		subjects.add("JSP");
		subjects.add("파이썬");
		subjects.add("스프링");
		
		// 확인
		System.out.println(subjects);
		
		// 데이터 제거
		subjects.remove("JSP");
		
		// 확인
		System.out.println(subjects);
		
	}
	
	public static void method2() {
		
		// 초기화, List -> Set 생성자에 넣어 줌
		Set<String> hobbies = new HashSet<String>(Arrays.asList("수영", "조깅", "푸쉬업"));
		
		// 일반 for문 : 불가능 (인덱스가 없으므로)
		
		// 향상 for문
		for (String hobby : hobbies) {
			System.out.println(hobby);
		}
		
	}
	
	public static void method3() {
		
		// lotto 번호 6개를 HashSet에 저장해 본다.
	
		// <>
		// 제네릭 처리 : 오직 클래스만 타입으로 사용할 수 있다.
		//               int, long, double 등은 사용할 수 없다.
		
		Set<Integer> lotto = new HashSet<Integer>();
		
		while (true) {
			lotto.add( (int)(Math.random() * 45) + 1 );
			if (lotto.size() == 6) {
				break;
			}
		}
		
		while (lotto.size() < 6) {
			lotto.add( (int)(Math.random() * 45) + 1 );
		}
		
		System.out.println(lotto);
		
		// Set -> List
		List<Integer> list = new ArrayList<Integer>(lotto);
		
		// List는 정렬할 수 있다.
		Collections.sort(list);  // 오름차순 정렬
		System.out.println(list);
		
		Collections.sort(list, Collections.reverseOrder());  // 내림차순 정렬
		System.out.println(list);
		
	}
	
	public static void main(String[] args) {
		method3();
	}

}
