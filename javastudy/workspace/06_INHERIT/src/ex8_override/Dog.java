package ex8_override;

public class Dog extends Animal {
	
	private String name;
	
	public Dog(int age, String name) {
		super(age);
		this.name = name;
	}

	@Override
	public void move() {
		System.out.println("달린다.");
	}
	
	@Override
	public void info() {
		super.info();  // Animal 클래스의 info 메소드 호출
		System.out.println("이름: " + name);
	}
	
}
