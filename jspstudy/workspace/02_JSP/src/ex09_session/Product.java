package ex09_session;

public class Product {

	private String product;  // 제품명
	private int quantity;    // 수량
	
	// 생성자를 안 만들면 디폴트 생성자를 사용하는 것이다.
	
	public String getProduct() {
		return product;
	}
	public void setProduct(String product) {
		this.product = product;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
}
