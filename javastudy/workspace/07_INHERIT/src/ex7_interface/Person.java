package ex7_interface;

public class Person {
	// 산책하기
	public void walk(Walkable pet) {
		System.out.println("Walking with " + ((Pet)pet).getName());
	}
}
