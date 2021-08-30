package ex3_abstract;

public class MainClass {

	public static void main(String[] args) {
		
		Company company = new Company(5);
		
		// company.addStaff(new Staff());  추상 클래스는 객체를 생성할 수 없다.
		company.addStaff(new SalaryMan(2000000));
		company.addStaff(new Alba(9200, 200));
		
		company.payInfo();
		
	}

}
