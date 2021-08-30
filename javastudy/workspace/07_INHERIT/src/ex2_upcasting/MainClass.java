package ex2_upcasting;

public class MainClass {

	public static void main(String[] args) {
		
		Company company = new Company("LG", 5);
		
		company.addStaff(new Staff("이사원", "총무"));
		company.addStaff(new SalaryMan("정사원", "인사", 2000000));
		company.addStaff(new Alba("김사원", "판매", 9200, 200));

		company.companyInfo();
		company.payInfo();
		
	}

}
