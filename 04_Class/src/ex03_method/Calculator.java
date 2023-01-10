package ex03_method;

public class Calculator {

	// Car 와 Calculator를 이해하면 좋겠다. CoffeeMachine도 시간 나면 ㄱㄱ
	
	// 메소드 (함수) : 어떤 기능을 만든다고 생각.
	// 계산기의 기능을 만든다.
	
	/*
		메소드 형식
		
		반환타입 메소드명(매개변수) {			void / int method(?)
			메소드 본문							메소드 본문
			return 반환값						return 반환값;
		}
		
		1. 반환값 + 반환타입 (반환값은 반환타입이어야 함. int 면 int , double 이면 double)
			메소드 실행(메소드 호출)의 결과
		2. 메소드명
			개발자 마음대로 정함
		3. 매개변수
			메소드로 전달되는 값(인수, argument)을 저장하는 변수
	*/
	
	/*																				메소드 호출
		메소드의 4가지 형식
		
		1. 반환값 X, 인수 X : 반환값이 없고, 전달되는 인수가 없을 때
			void : 반환 타입이 없다는 키워드										method();
			void method() {    // 인수가 없으니 매개변수 자리 비워둔다.
				메소드 본문
			}
		
		2. 반환값 X, 인수 O															int a = 0;
			void method(int arg) {													method(a);
				메소드 본문
			}
		
		3. 반환값 O, 인수 X (int를 반환한다고 가정)									int result;			// int 타입을 지정해줘야 한다.
			int method() {															result = method();
				메소드 본문
				return 반환값
			}
		
		4. 반환값 O, 인수 O															int a = 0;
		 	int method(int arg) {													int result;				
		 		메소드 본문															result = method(a);		int result = method(a);
		 		return 반환값																		    =>반환타입 변수 = method(인자)
		 	}
	*/
	
	
	// addition 메소드 정의 (반환값 O, 인수 O)
	double addition(double a, double b) { // double a, double b : 매개변수
		return a + b;
	}
	
	// subtraction 메소드 정의 
	double subtraction(double a, double b) {
		return a - b;
	}
	
	
	
}
