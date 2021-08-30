package ex3_abstract;

// 추상 클래스 Staff의 자식들은
// 반드시! 추상 메소드 pay()를 오버라이드 해야 한다.

public class SalaryMan extends Staff {

	private int salary;

	public SalaryMan(int salary) {
		super();
		this.salary = salary;
	}
	
	@Override
	public int pay() {
		return salary;
	}
	
}
