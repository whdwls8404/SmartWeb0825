package ex3_parking_lot;

public class Car {
	// field
	private String carNo;
	
	// constructor
	public Car(String carNo) {
		this.carNo = carNo;
	}
	
	// method
	public void info() {
		System.out.println("차량번호: " + carNo);
	}
	public String getCarNo() {
		return carNo;
	}
	public void setCarNo(String carNo) {
		this.carNo = carNo;
	}
	
}
