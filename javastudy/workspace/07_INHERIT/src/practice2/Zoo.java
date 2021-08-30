package practice2;

public class Zoo {

	// 어떤 동물이든 저장할 수 있는 animals 배열 선언
	private Animal[] animals;
	private int idx;
	
	public Zoo() {
		animals = new Animal[3];
	}
	
	// addAnimal()
	public void addAnimal(Animal animal) {
		if (idx == animals.length) {
			System.out.println("Full!");
			return;
		}
		animals[idx++] = animal;
	}
	
	// animalsInfo()
	public void animalsInfo() {
		for (int i = 0; i < idx; i++) {
			animals[i].eat();
			if (animals[i] instanceof Lion) {
				((Lion)animals[i]).run();
			} else if (animals[i] instanceof Shark) {
				((Shark)animals[i]).swim();
			}
		}
	}
	
}
