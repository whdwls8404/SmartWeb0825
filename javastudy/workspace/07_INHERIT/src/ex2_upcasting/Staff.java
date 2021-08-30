package ex2_upcasting;

public class Staff {

	private String name;
	private String dept;
	
	public Staff(String name, String dept) {
		super();
		this.name = name;
		this.dept = dept;
	}
	
	public void info() {
		System.out.println("사원명: " + name + "(" + dept + ")");
	}
	public int pay() {
		return 0;
	}
	
}
