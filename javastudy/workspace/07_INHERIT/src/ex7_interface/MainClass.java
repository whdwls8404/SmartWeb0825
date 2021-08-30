package ex7_interface;

public class MainClass {

	public static void main(String[] args) {
		
		Person person = new Person();
		
		Dog dog = new Dog("백구");
		Cat cat = new Cat("냥구");
		Snake snake = new Snake("낼름이");
		
		person.walk(dog);
		person.walk(cat);
		// person.walk(snake);  // 못하도록 막기

	}

}
