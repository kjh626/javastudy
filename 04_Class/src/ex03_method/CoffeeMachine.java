package ex03_method;

public class CoffeeMachine { // 돈을 넣으면 커피가 나온다.
	
	// 필드
	int moneyPot;	// 돈통
	String[] menu = {"아메리카노", "카페라떼", "마키아또"};
	int[] prices = {900, 1500, 2000}; 	// 커피 가격
	
	// 메소드						// 자판기가 받는 것은 돈, 무슨 커피 선택했는지...
	CoffeeAndChange buyCoffee(int money, int choice) { // 커피를 형상화 하자면 커피를 클래스로 만드는 게 좋다. 사람이 받는 것은 커피와 잔돈  -> 반환타입 : CoffeeAndChange클래스
		
		// 돈이 모자라면 money를 그대로 반환.
		int price = prices[choice - 1];
		
		if(money < price) {
			CoffeeAndChange cnc = new CoffeeAndChange();
			cnc.change = money;
			return cnc;
		}
		
		String coffee = menu[choice - 1]; // 메뉴, 가격.  choice 1,2,3 - 1 => 배열 0,1,2로 
		
		moneyPot += price;
		
		CoffeeAndChange cnc = new CoffeeAndChange();
		cnc.coffee = coffee; 		// 어떤 커피, 잔돈 얼마
		cnc.change = money - price;
		return cnc;
	}
	
}
