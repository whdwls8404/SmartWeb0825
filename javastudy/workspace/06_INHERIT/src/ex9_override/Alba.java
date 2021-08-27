package ex9_override;

public class Alba extends Staff {

	private int payPerHour;
	private int times;
	
	public Alba(String name, String dept, int payPerHour) {
		super(name, dept);
		this.payPerHour = payPerHour;
	}
	
	public void addTimes(int hour) {
		times += hour;
	}
	@Override
	public int getPay() {
		return payPerHour * times;
	}
	@Override
	public void info() {
		super.info();
		System.out.println("근무시간: " + times + "시간");
		System.out.println("급여: " + getPay());
	}
	
}
