package practice2;

public class MainClass {

	public static void main(String[] args) {
		
		Zoo zoo = new Zoo();
		
		zoo.addAnimal( new Lion() );
		zoo.addAnimal( new Shark() );
		
		zoo.animalsInfo();
		
		// 실행 결과
		// 사자는 고기를 먹는다.
		// 사자는 달릴 수 있다.
		// 상어는 물고기를 먹는다.
		// 상어는 헤엄을 칠 수 있다.

	}

}
