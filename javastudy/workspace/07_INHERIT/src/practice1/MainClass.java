package practice1;

public class MainClass {

	public static void main(String[] args) {
		
		// KoreanFighter			ForeignFighter
		// 10% 확률로 한 방 KO		20% 확률로 한 방 KO
		// 10% 확률로 헛 방			20% 확률로 헛 방
		
		Fighter fighter1 = new KoreanFighter("정찬성");
		Fighter fighter2 = new ForeignFighter("에드가");
		
		while (fighter1.isAlive() && fighter2.isAlive()) {
			if (Math.random() < 0.5) {
				fighter1.attack(fighter2);				
			} else {
				fighter2.attack(fighter1);
			}
		}
		
		if (fighter1.isAlive()) {
			System.out.println(fighter1.getName() + " 승리.");
		} else {
			System.out.println(fighter2.getName() + " 승리.");
		}
		
	}
	
}
