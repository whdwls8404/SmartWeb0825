package ex9_override;

public class MainClass {

	public static void main(String[] args) {
		
		SalaryMan staff1 = new SalaryMan("김사원", "총무", 2000000);
		
		Alba staff2 = new Alba("최알바", "판매", 9160);
		for (int day = 1; day <= 20; day++) {
			staff2.addTimes((int)(Math.random() * 8) + 1);
		}
		
		staff1.info();
		staff2.info();

	}

}
