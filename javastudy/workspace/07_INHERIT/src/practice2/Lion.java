package practice2;

public class Lion implements Animal {
	@Override
	public void eat() {
		System.out.println("사자는 고기를 먹는다.");
	}
	public void run() {
		System.out.println("사자는 달릴 수 있다.");
	}
}
