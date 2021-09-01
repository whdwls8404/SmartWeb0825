package ex3_Map;

import java.util.*;

public class MainClass {

	// HashMap
	// 1. Map 인터페이스를 구현한 클래스이다.
	// 2. 데이터가 쌍(pair)으로 구성된다.
	//    키(key)-값(value)  =>  변수-값
	// 3. 키(key)
	//    값(value)을 꺼낼 때 사용하고, 중복된 키(key)는 존재할 수 없다.
	// 4. 값(value)
	//    실제 데이터를 의미하고, 중복된 값(value)은 가능하다.
	
	public static void method1() {
		
		// 생성
		Map<String, Integer> sungjuk = new HashMap<String, Integer>();
		
		// 데이터 저장
		sungjuk.put("국어", 80);
		sungjuk.put("영어", 100);
		sungjuk.put("수학", 70);
		
		// 확인
		System.out.println(sungjuk);
		
		// 데이터 수정 (동일한 키(key)를 사용하면 수정) 
		sungjuk.put("국어", 90);
		
		// 확인
		System.out.println(sungjuk);
		
		// 데이터 삭제
		sungjuk.remove("수학");
		
		// 확인
		System.out.println(sungjuk);
		
	}
	
	public static void method2() {
		
		Map<String, Object> staff = new HashMap<String, Object>();
		
		staff.put("staffNo", 1000);
		staff.put("name", "천송이");
		staff.put("dept", "전략");
		
		// 개별 요소
		System.out.println("사원번호: " + staff.get("staffNo"));
		System.out.println("사원명: " + staff.get("name"));
		System.out.println("부서명: " + staff.get("dept"));
		
	}
	
	public static void method3() {

		Map<String, Object> staff = new HashMap<String, Object>();
		
		staff.put("사원번호", 1000);
		staff.put("사원명", "천송이");
		staff.put("부서명", "전략");
		
		// Map과 반복문1
		// 키(key)만 빼서 개별 요소 접근하기
		Set<String> keys = staff.keySet();
		for (String key : keys) {
			System.out.println(key + ": " + staff.get(key));
		}
		
		// Map과 반복문2
		// 키(key)-값(value) 조합을 빼서 접근하기
		// Entry: 키-값을 합쳐서 부르는 용어
		for ( Map.Entry<String, Object> entry : staff.entrySet() ) {
			System.out.println(entry.getKey() + ": " + entry.getValue());
		}
		
	}
	
	public static void main(String[] args) {
		method3();
	}

}







