package ex9_override;

public class Staff {

	private String name;
	private String dept;
	
	public Staff(String name, String dept) {
		super();
		this.name = name;
		this.dept = dept;
	}
	
	public int getPay() {
		return 0;  // 의미 없는 반환 (작성할 필요가 없는 본문)
	}
	public void info() {
		System.out.println("사원명: " + name);
		System.out.println("부서: " + dept);
	}
	
}
