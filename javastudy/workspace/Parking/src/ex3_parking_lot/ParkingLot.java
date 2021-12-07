package ex3_parking_lot;

import java.util.Scanner;

public class ParkingLot {
	
	// field
	private final int MAX_SIZE = 5;  // final 상수 (값을 못 바꿈, 상수는 대문자로 표시하기)
	private Car[] cars = new Car[MAX_SIZE];  // 배열
	private int idx = 0;  // 인덱스
	private Scanner sc = new Scanner(System.in);
	
	// constructor
	// 안 만들면 디폴트 생성자가 사용됨
	// new ParkingLot()으로 생성함

	// method
	
	// 1. 차량 추가
	public void addCar() {
		// 차량번호를 입력 받아서 배열 cars에 저장
		if (idx == MAX_SIZE) {
			System.out.println("주차장이 만차입니다.");
			return;
		}
		System.out.print("새로 등록할 차량번호 입력 >>> ");
		cars[idx++] = new Car(sc.next());
		// 중요.
		// idx는 차량이 추가되면 함께 증가되는 변수로,
		// idx는 실제로 등록된 차량의 수와 같다.
		// 물론, idx는 여전히 새로운 차량이 등록될 인덱스이기도 하다.
	}
	
	// 2. 차량 제거 : 차량번호를 입력 받아서 해당 차량 제거. 어려움.
	public void deleteCar() {
		if (idx == 0) {
			System.out.println("주차장이 비었습니다.");
			return;
		}
		System.out.print("삭제할 차량번호 입력 >>> ");
		String deleteNo = sc.next();
		for (int i = 0; i < cars.length; i++) {
			if (deleteNo.equals(cars[i].getCarNo())) {
				System.out.println(cars[i].getCarNo() + " 차량을 삭제합니다.");
				System.arraycopy(cars, i + 1, cars, i, idx - i - 1);  // 삭제된 차량의 뒤에 있는 전체 차량을 앞으로 한 칸씩 옮기는 코드
				idx--;  // 차량 대수를 감소시킨다.
				return;  // deleteCar() 메소드 종료(한 번에 한 대만 삭제한다.)
			}
		}
		System.out.println(deleteNo + " 차량이 없습니다.");
	}
	
	// 3. 차량 검색 : 차량번호를 입력 받아서 있다. 없다.
	public void findCar() {
		if (idx == 0) {
			System.out.println("주차장이 비었습니다다.");
			return;
		}
		System.out.print("검색할 차량번호 입력 >>> ");
		String findNo = sc.next();
		for (int i = 0; i < idx; i++) {
			if (findNo.equals(cars[i].getCarNo())) {
				System.out.println(findNo + " 차량이 있습니다.");
				return;  // findCar() 메소드 종료(차량을 발견하면 바로 종료)
			}
		}
		System.out.println(findNo + " 차량이 없습니다.");  // for문 끝날때까지 return;을 못 만나면 여기로 온다. 다 찾아봤는데 없다는 의미이다.
	}
	
	// 4. 전체 차량 출력
	public void printAllCar() {
		if (idx == 0) {
			System.out.println("주차장이 비었습니다.");
			return;
		}
		for (int i = 0; i < idx; i++) {
			cars[i].info();
		}
	}
	
	// 5. 차량 관리
	public void manage() {
		
		while (true) {
			
			System.out.println("*** 1.추가  2.제거  3.검색  4.전체  0.종료 ***");
			System.out.print("선택 >>> ");
			int choice = sc.nextInt();
			
			switch(choice) {
			case 1: // 차량 추가
				addCar();
				break;  // switch문 종료 (무한루프 종료 아님)
			case 2: // 차량 제거
				deleteCar();
				break;
			case 3: // 차량 검색
				findCar();
				break;
			case 4: // 전체 차량 출력
				printAllCar();
				break;
			case 0: // 차량 관리 종료
				System.out.println("Good bye!");
				return;  // 반환이 void인 메소드는 return; 이 종료를 의미한다.
			default: // 잘못된 메뉴 선택
				System.out.println("Try again!");
			}
			
		}
		
	}
	
}
