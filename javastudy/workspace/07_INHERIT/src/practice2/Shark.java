package practice2;

public class Shark implements Animal {
	@Override
	public void eat() {
		System.out.println("상어는 물고기를 먹는다.");
	}
	public void swim() {
		System.out.println("상어는 헤엄을 칠 수 있다.");
	}
}
