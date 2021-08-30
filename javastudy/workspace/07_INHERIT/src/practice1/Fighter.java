package practice1;

public abstract class Fighter {

	private String name;
	private int energy;  // 0 ~ 100
	private int power;   // 1 ~ 10
	private boolean alive;
	
	public Fighter(String name) {
		this.name = name;
		this.energy = (int)(Math.random() * 101);  // 0 ~ 100 사이에서 랜덤 생성
		this.power = (int)(Math.random() * 10) + 1;  // 1 ~ 10 사이에서 랜덤 생성
		this.alive = this.energy > 0;
		System.out.println(this.name + ", 에너지: " + this.energy + ", 공격력: " + this.power);
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getEnergy() {
		return energy;
	}
	public void setEnergy(int energy) {
		this.energy = energy;
		if (this.energy < 0) {
			this.energy = 0;
		}
		setAlive(this.energy > 0);
	}
	public int getPower() {
		return power;
	}
	public void setPower(int power) {
		this.power = power;
	}
	public boolean isAlive() {
		return alive;
	}
	public void setAlive(boolean alive) {
		this.alive = alive;
	}
	public abstract void attack(Fighter fighter);
	
}