package main;

import java.util.Scanner;

public class ProductMainClass {
	public static void main(String[] args) {
		//new ProductManagement().manage();
		
		Scanner sc = new Scanner(System.in);
		System.out.print("수정할 제품명 입력(수정 안하려면 엔터) >>> ");
		String pName = sc.nextLine();
		System.out.print("수정할 제품가격 입력(수정 안하려면 엔터) >>> ");
		String strPrice = sc.nextLine();
		
		int r1 = pName.isEmpty() ? 1 : 0;
		int r2 = strPrice.isEmpty() ? 2 : 0;
		System.out.println(r1 + r2);
		
		//UPDATE PRODUCT SET PNAME = ? WHERE PNO = ?
		//UPDATE PRODUCT SET PRICE = ? WHERE PNO = ?
		//UPDATE PRODUCT SET PNAME = ?, PRICE = ? WHERE PNO = ?
		
	}
}
