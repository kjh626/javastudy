package ex04_method_overloading;

public class Calculator {
	
	/*
		메소드 오버로딩
		1. 같은 이름의 메소드를 여러 개 만들 수 있다.
		2. 제한 조건
			1) 메소드 이름이 같아야 한다.
			2) 매개변수의 타입이나 개수가 달라야 한다. (=> 메소드 이름 같고, 매개변수의 타입(int타입) 같으면 -> 메소드 오버로딩 X)
			3) 주의) 반환타입은 메소드 오버로딩과 연관이 없다.
	*/
	double addition(double a, double b) {
		return a + b;	// return은 a + b 한 결과를 addition메소드를 호출한 곳으로 돌려주시오
	}
	
	double addition(double[] numbers) { // 매개변수와 이름이 달라도 된다(전달하는 배열 이름(arr)과 받는 배열 이름(numbers)이 달라도 된다)
		double total = 0.0;
		for(int i = 0; i <numbers.length; i++) {
			total += numbers[i];
		}
		return total;
	}
	
	
	
	
	
	
}
