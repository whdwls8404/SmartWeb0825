package ex3_has_a_without_extends;

public class Soldier {
	
	private Gun gun;
	
	public Soldier() {
		gun = new Gun();
	}
	
	public void shoot() {
		gun.shoot();
	}
	public void walk() {
		System.out.println("WALK!");
	}
	
}
