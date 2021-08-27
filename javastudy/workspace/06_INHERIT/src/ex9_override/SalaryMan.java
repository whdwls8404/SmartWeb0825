package ex9_override;

public class SalaryMan extends Staff {

	private int salary;

	public SalaryMan(String name, String dept, int salary) {
		super(name, dept);
		this.salary = salary;
	}
	
	@Override
	public int getPay() {
		return salary;
	}
	@Override
	public void info() {
		super.info();
		System.out.println("급여: " + getPay());
	}
	
}
