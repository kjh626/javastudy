package ex03_method;

public class MainClass {

	public static void ex01() {
		
		// Calculator 객체 선언 + 생성
		Calculator calc = new Calculator();
		
		double add = calc.addition(1.5, 2.5);    // addition 메소드 호출
		System.out.println(add);				// 1.5, 2.5 : 인자, argument.
		
		double sub = calc.subtraction(2.5, 1.2);	// addition 메소드 호출
		System.out.println(sub);
	}
	
	public static void ex02() {
		
		CoffeeMachine coffeeMachine = new CoffeeMachine();	// 객체 선언 + 생성
		
		CoffeeAndChange coffeeAndChange = coffeeMachine.buyCoffee(1000, 1);		// 메소드 호출 CoffeeMachine 메소드에서 return된 cnc값은 메인의 coffeeMachine.buyCoffee(1000, 1)로 넘어간다.
		System.out.println(coffeeAndChange.coffee);								// coffeeMachine.buyCoffee(1000, 1)는 변수 coffeeAndChange에 저장됨
		System.out.println(coffeeAndChange.change);
		
		System.out.println(coffeeMachine.moneyPot);
		
	}
	
	public static void ex03() {
		
		Car car = new Car();
		
		car.addOil(100);
		
		for(int n = 0; n < 51; n++) {	// 51번
			car.pushAccel();
		}
		System.out.println(car.oilPot);
		System.out.println(car.carSpeed);
		
		for(int n = 0; n < 11; n++) {    // 5번, 11번
			car.pushBrake();
		}
		System.out.println(car.oilPot);
		System.out.println(car.carSpeed);
	}
	
	public static void main(String[] args) {
		ex03();
	}

}
