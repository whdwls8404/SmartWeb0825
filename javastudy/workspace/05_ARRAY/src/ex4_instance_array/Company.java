package ex4_instance_array;

public class Company {

	private Staff[] staffs;
	private int idx;  // 직원이 추가될 인덱스 + 실제 추가된 직원의 수
	
	public Company(int staffCount) {
		staffs = new Staff[staffCount];
	}
	
	// 직원 추가
	public void addStaff(Staff staff) {
		if (idx == staffs.length) {  // full check
			System.out.println("더 이상 직원을 추가할 수 없습니다.");
			return;  // 메소드 종료
		}
		staffs[idx++] = staff;
	}
	
	// 직원 제거
	public void deleteStaff(int number) {
		if (idx == 0) {  // empty check
			System.out.println("아무 직원도 없습니다.");
			return;
		}
		if (number <= 0 || number > idx) {  // wrong number
			System.out.println("존재하지 않는 사원번호입니다.");
			return;
		}
		
		/*
			deleteStaff(1);
			
			int number = 1;
			
			| s1 | s2 | s3 |
			
									   idx
			0 <- 1	: | s2 | s2 | s3 |
			
									   idx
			1 <- 2	: | s2 | s3 | s3 |
			
								  idx
					  | s2 | s3 | s3 |

								  idx
					  | s2 | s3 | null |
					  
			
			for (int i = number ; i < idx ; i++) {
				staffs[i - 1] = staffs[i];
			}
			idx--;
			staffs[idx] = null;
		*/
		
		for (int i = number; i < idx; i++) {
			staffs[i - 1] = staffs[i];
		}
		idx--;
		staffs[idx] = null;
		
	}
	
	// 직원 목록
	public void staffList() {
		System.out.println("===== 직원목록 =====");
		for (int i = 0; i < idx; i++) {
			System.out.println("사원번호(" + (i + 1) + "), 이름: " + staffs[i].getName() + ", 부서: " + staffs[i].getDept());
		}
		for (Staff s : staffs) {
			if (s != null) {
				System.out.println("이름: " + s.getName() + ", 부서: " + s.getDept());
			}
		}
	}
	
}
