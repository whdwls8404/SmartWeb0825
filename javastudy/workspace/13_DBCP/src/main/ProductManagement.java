package main;

import java.util.List;
import java.util.Scanner;

import dao.ProductDAO;
import dto.ProductDTO;

public class ProductManagement {

	// field
	private Scanner sc = new Scanner(System.in);
	private ProductDAO dao = new ProductDAO();
	
	// method (ProductDAO의 적절한 메소드 호출)
	public void addProduct() {
		System.out.println("=== 제품 등록 ===");
		System.out.print("제품명 입력 >>> ");
		String pName = sc.next();  // 제품명에 공백 불가
		System.out.print("제품가격 입력 >>> ");
		int price = sc.nextInt();
		int insertCount = dao.insertProduct(pName, price);
		if (insertCount == 1) {
			System.out.println("=== " + pName + " 등록 완료 ===");
		} else if (insertCount == 0) {
			System.out.println("=== " + pName + " 등록 실패 ===");
		}
	}
	public void removeProduct() {
		System.out.println("=== 제품 삭제 ===");
		System.out.print("삭제할 제품번호 입력 >>> ");
		long pNo = sc.nextLong();
		int deleteCount = dao.deleteProduct(pNo);
		if (deleteCount == 1) {
			System.out.println("=== " + pNo + " 제품 삭제 완료 ===");
		} else if (deleteCount == 0) {
			System.out.println("=== " + pNo + " 제품 삭제 실패 ===");
		}
	}
	public void modifyProduct() {
		System.out.println("=== 제품 수정 ===");
		System.out.print("수정할 제품번호 입력 >>> ");
		long pNo = sc.nextLong();
		sc.nextLine();  // 제품번호 입력하고 엔터를 누르면 그 엔터를 먹는다.
		System.out.print("수정할 제품명 입력(수정 안하려면 엔터) >>> ");
		String pName = sc.nextLine();
		System.out.print("수정할 제품가격 입력(수정 안하려면 엔터) >>> ");
		String strPrice = sc.nextLine();
		int r1 = pName.isEmpty() ? 1 : 0;
		int r2 = strPrice.isEmpty() ? 2 : 0;
		int updateCount = dao.updateProduct(pNo, pName, strPrice, r1 + r2);
		if (updateCount == 1) {
			System.out.println("=== " + pNo + " 제품 수정 완료 ===");
		} else if (updateCount == 0) {
			System.out.println("=== " + pNo + " 제품 수정 실패 ===");
		}
	}
	public void findProduct() {
		System.out.println("=== 제품 조회 ===");
		System.out.print("조회할 제품번호 입력 >>> ");
		long pNo = sc.nextLong();
		ProductDTO product = dao.selectByPno(pNo);
		if (product == null) {
			System.out.println("=== " + pNo + " 제품이 없습니다. ===");
		} else {
			System.out.println("조회된 제품 정보는 다음과 같습니다.");
			System.out.println(product);
		}
	}
	public void findAllProduct() {
		System.out.println("=== 전체 제품목록 ===");
		List<ProductDTO> products = dao.selectProductList();
		if (products.size() == 0) {
			System.out.println("조회된 제품이 없습니다.");
		} else {
			for (ProductDTO product : products) {
				System.out.println(product);
			}
		}
	}
	public void menu() {
		System.out.println("================");
		System.out.println("  1. 제품 등록");
		System.out.println("  2. 제품 삭제");
		System.out.println("  3. 제품 수정");
		System.out.println("  4. 제품 조회");
		System.out.println("  5. 전체 목록");
		System.out.println("  0. 종료");
		System.out.println("================");
	}
	public void manage() {
		while (true) {
			menu();
			System.out.print("작업 선택(1,2,3,4,5,0) >>> ");
			switch (sc.nextInt()) {
			case 1: addProduct(); break;
			case 2: removeProduct(); break;
			case 3: modifyProduct(); break;
			case 4: findProduct(); break;
			case 5: findAllProduct(); break;
			case 0: System.out.println("=== 제품관리프로그램 종료 ==="); return;
			default: System.out.println("작업은 1,2,3,4,5,0 중 하나입니다.");
			}
		}
	}
	
}
