package ex8_override;

public class Animal {
	
	private int age;
	
	public Animal(int age) {
		super();
		this.age = age;
	}

	public void move() {
		// 비워 둠.
	}
	public void info() {
		System.out.println("나이: " + age + "살");
	}
	
}
