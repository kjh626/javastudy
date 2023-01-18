package practice05_Cart;

public class Cart {

	// 제품을 여러개 담는다. = 제품들
	private Product[] products;		// 배열 선언
	private int prodCount;			// 실제로 products 배열에 저장된 product의 개수
	
	// 작은 카트, 큰 카트 2개 있다고 가정
	// new Cart(10), new Cart(20), ...
	public Cart(int cartSize) {		// 이 사이즈는 배열의 사이즈라고 생각. 배열은 선언, 생성을 해야한다.
		products = new Product[cartSize];	// 배열 생성
		prodCount = 0; 				// 필드는 자동으로 0으로 초기화, 안 줘도 된다.
	}

	public Product[] getProducts() {
		return products;
	}

	public void setProducts(Product[] products) {
		this.products = products;
	}

	public int getProdCount() {
		return prodCount;
	}

	public void setProdCount(int prodCount) {
		this.prodCount = prodCount;
	}
	
	// 카트에 물건 담기
	// addProduct(new Meat(1, "소고기", 5000))
	// addProduct(new Pizza(2, "고구마피자", 3000))
	// addProduct(new Noodle(3, "누들면", 1500))
	public void addProduct(Product product) {		// 받아올 건 제품(매개변수)

		// 카트가 가득 차면 물건을 담지 못한다.
		if(products.length == prodCount) {
			System.out.println("카트가 가득 찼습니다.");
			return;
		}
		
		// 카트에 물건 담기
		products[prodCount++] = product;	// 사용하고 1개 늘리기 prodCount++
	}
	
	// 카트에서 물건 빼기
	// 빈 자리 어떻게 처리할 거냐? 방법 2가지
	// 1. 물건 빼면 비어있는 자리를 앞 당겨 준다 2. 물건 뺀 자리에 맨 뒤 물건을 넣어준다.	/ 1번 방법 tip : System.arraycopy()
	// deleteProduct(1)
	// deleteProduct(2)
	// deleteProduct(3) 이 번호 제품 빼주세요
	public void deleteProduct(int prodNo) {
		
		// 카트가 비어 있으면 뺄 물건이 없다.
		if(prodCount == 0) {
			System.out.println("카트가 비어있습니다.");
			return;
		}
		for(int i = 0; i < prodCount; i++) {	// 어디까지? prodCount까지 하는 게 맞다. 끝까지 찾으면 손해다.
			if(products[i].getProdNo() == prodNo) {
				// 물건이 5개 있다고 가정, 나머지는 다 null값.[1234500000]
				// 물건 뺀 자리에 맨 뒤 물건을 넣어준다. 이 방법
				products[i] = products[--prodCount];	// 코드 리팩토링.
				break;
				/*
				products[i] = products[prodCount - 1];	// 마지막 물건을 뺀 물건 자리로 옮기기
				prodCount--;							// 물건을 뺐으면 prodCount의 수를 줄여줘야 한다.
				*/
			}	// 마지막 물건 자리는 옮겨지는 건가??
		}
		
	}
	
	
	
	
}
