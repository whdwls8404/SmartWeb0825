package ex4_instance_array;

public class CompanyStaffMainClass {

	public static void main(String[] args) {
		
		Company company = new Company(3);
		
		company.addStaff(new Staff("이사원", "총무"));
		company.addStaff(new Staff("박과장", "인사"));
		company.addStaff(new Staff("최대리", "전략"));
		
		company.deleteStaff(3);
		
		company.staffList();

	}

}
