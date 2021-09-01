package ex1_List;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class MainClass {

	public static void method1() {
		
		// 생성
		List<String> list = new ArrayList<>();
		
		// 추가
		list.add("자바");  // 마지막 요소로 추가
		list.add("데이터베이스");
		list.add("자바");
		list.add(0, "프론트");  // 인덱스 0에 추가
		
		// 확인
		System.out.println(list);
		
		// 제거
		list.remove(0);  // 인덱스 0 제거
		list.remove("자바");  // 첫 번째 "자바" 제거
		
		// 확인
		System.out.println(list);

	}
	
	public static void method2() {
		
		// 초기화
		List<String> foods = Arrays.asList("사과", "김치찌개", "삼겹살");
		
		// 길이
		System.out.println(foods.size());
		
		// 개별 요소
		System.out.println(foods.get(0));
		System.out.println(foods.get(1));
		System.out.println(foods.get(2));
		
		// 수정
		foods.set(0, "김밥");  // 인덱스 0 수정
		System.out.println(foods.get(0));
		
	}
	
	public static void method3() {
		
		List<String> list = Arrays.asList("짱구", "뽀로로", "띠띠뽀");
		
		// 일반 for문
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
		// 개선된 일반 for문 (size() 메소드를 한 번만 호출)
		for (int i = 0, size = list.size(); i < size; i++) {
			System.out.println(list.get(i));
		}
		// 향상 for문
		for (String s : list) {
			System.out.println(s);
		}
		
	}
	
	public static void main(String[] args) {
		method1();
	}

}
