package ex01_lambda.ch01;

public class MainClass {

	/*
		람다식
		
		1. 익명 객체를 생성하기 위한 표현식이다.
		2. 실행(Runtime)할 때 익명 객체가 생성되면서 동작한다. 
		3. 추상 메소드가 하나인 인터페이스(함수형 인터페이스)에서 람다식을 사용할 수 있다.
		4. 형식
			(매개변수) -> { 메소드 본문 } 
		5. 예시
			1) () -> { System.out.println("Hello World"); }  실패
			   () -> System.out.println("Hello World");      메소드 본문이 한 줄이면 중괄호({}) 생략
			2) (int n) -> { System.out.println(n); };        실패
			   (n) -> System.out.println(n);                 매개변수의 타입은 생략한다.
			3) (a, b) -> {
			       System.out.println(a + ", " + b);
			       return a + b;
			   }                                             반환타입은 생략
			4) (a, b) -> { return a + b; }                   실패
			   (a, b) -> a + b;                              실행문이 return만 있으면 return 생략
	*/
	public static void m1() {

		// 어차피 new Car 할 거니까 빼, 어차피 추상메소드 완성해줘야 하니까 빼, 한 줄만 적으면 되니까 중괄호도 빼
		// 만약에 2개 이상의 추상메소드가 있다면 한 줄이 어느 메소드 것인지 뭔지 모르게 된다. (람다식은 이게 어디의 추상메소드의 내용인 지를 적어줄 수가 없다.)
		// 그래서 보통 추상메소드가 1개일 때 람다식을 쓴다. (java8부터)
		Car car = () -> System.out.println("기름 넣기");  // 이 한 줄이 addOil()의 내용.
		
		car.addOil();
		
	}
	
	public static void gasStation() {
		
		GasStation gasStation = new GasStation();
		
		gasStation.getCar().addOil();
		
		System.out.println("남은 기름 : " + gasStation.getTotalOil());
		System.out.println("번 돈 : " + gasStation.getEarning());
		
	}
	
	public static void main(String[] args) {

		m1();
		
	}

}
