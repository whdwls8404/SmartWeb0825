package ex2_upcasting;

public class Alba extends Staff {

	private int payPerHour;
	private int times;

	public Alba(String name, String dept, int payPerHour, int times) {
		super(name, dept);
		this.payPerHour = payPerHour;
		this.times = times;
	}
	
	@Override
	public void info() {
		super.info();
		System.out.println("급여: " + payPerHour * times + "원");
	}
	@Override
	public int pay() {
		return payPerHour * times;
	}
	
}
