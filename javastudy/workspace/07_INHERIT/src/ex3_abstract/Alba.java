package ex3_abstract;

public class Alba extends Staff {

	private int payPerHour;
	private int times;
	
	public Alba(int payPerHour, int times) {
		super();
		this.payPerHour = payPerHour;
		this.times = times;
	}
	
	@Override
	public int pay() {
		return payPerHour * times;
	}
	
}
