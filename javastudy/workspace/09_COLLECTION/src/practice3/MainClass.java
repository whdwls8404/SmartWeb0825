package practice3;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainClass {

	public static void main(String[] args) {
		
		// Staff 3명을 ArrayList에 저장하기
		// Staff은 HashMap으로 생성하기
		Map<String, Object> staff1 = new HashMap<String, Object>();
		staff1.put("사원번호", 1000);
		staff1.put("사원명", "김과장");
		staff1.put("부서명", "영업");
		
		Map<String, Object> staff2 = new HashMap<String, Object>();
		staff2.put("사원번호", 1001);
		staff2.put("사원명", "최대리");
		staff2.put("부서명", "관리");
		
		Map<String, Object> staff3 = new HashMap<String, Object>();
		staff3.put("사원번호", 1002);
		staff3.put("사원명", "정총무");
		staff3.put("부서명", "인사");

		List<Map<String, Object>> staffs = Arrays.asList(staff1, staff2, staff3);
		
		for (Map<String, Object> staff : staffs) {
			for (Map.Entry<String, Object> entry : staff.entrySet()) {
				System.out.println(entry.getKey() + ": " + entry.getValue());
			}
		}
		
	}

}
