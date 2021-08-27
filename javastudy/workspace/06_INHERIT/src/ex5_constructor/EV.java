package ex5_constructor;

public class EV extends Car {

	private String batteryMaker;
	
	public EV(String model, String batteryMaker) {
		super(model);  // Car 클래스의 생성자는 디폴트 생성자가 아니므로 반드시 직접 호출해야 함.
		this.batteryMaker = batteryMaker;
	}
	
	public String getBatteryMaker() {
		return batteryMaker;
	}
	public void setBatteryMaker(String batteryMaker) {
		this.batteryMaker = batteryMaker;
	}
	
}
