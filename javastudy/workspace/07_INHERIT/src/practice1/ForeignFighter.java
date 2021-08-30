package practice1;

public class ForeignFighter extends Fighter {

	public ForeignFighter(String name) {
		super(name);
	}

	@Override
	public void attack(Fighter other) {
		if (Math.random() < 0.2) {
			other.setEnergy(0);  // 20% 확률로 KO
		} else if (Math.random() < 0.4) {
			// 20% 확률로 헛 방
		} else {
			other.setEnergy( other.getEnergy() - getPower() );
		}
		System.out.println(getName() + "의 공격, " + other.getName() + "의 남은 에너지: " + other.getEnergy());
	}
	
}
