package ex6_exception_class;

public class MainClass {

	public static void main(String[] args) {
		
		BankAccount myAccount = new BankAccount("월매", "123-456-789", 50000);
		myAccount.accountManage();

	}

}
