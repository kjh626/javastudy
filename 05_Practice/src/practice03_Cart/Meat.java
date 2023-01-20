package practice03_Cart;

public class Meat extends Product {
	// 부모의 디폴트 생성자가 없어서 꼭 생성자를 불러와야 한다.
	
	// new Meat(1, "소고기", 5000)
	
	public Meat(int prodNo, String prodName, int prodPrice) {
		super(prodNo, prodName, prodPrice);
	}
	
	
}
