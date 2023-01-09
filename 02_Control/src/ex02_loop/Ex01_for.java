package ex02_loop;

public class Ex01_for {

	/*
		for문
		1. 연속된 숫자를 생성하는 반복문(배열에서 주로 사용)
	 	2. 형식
	 		for(초기문; 조건문; 증감문) {
	 			실행문
	 		}
	 		=> 1초기문 -> 2조건문 -> 3실행문 -> 4증감문 / 초기문 1번만 실행, 2->3->4 반복하는 루프 발생
	 */
	
	public static void ex01() {
		
		// 1 ~ 10
		for(int a = 1; a <= 10; a++) { // 조건문 : a가 10이하이면 실행문을 실행하시오.
			System.out.println(a);
		}
		
	}
	
	public static void ex02() {

		// 횟수(5번)
		int count = 5;   // 횟수를 저장하는 변수
		
		for(int a = 0; a < count; a++) {    // 0부터 시작하는 것을 선호. a < 5 는 5번이라는 것을 나타냄
			System.out.println("Hello World"); // 5번 실행 (1~5든지 2~6이든지)
		}
			
	}
	
	public static void ex03() {    // 연습
		
		// 10 ~ 1 
		for(int a = 10; a >= 1; a--) {
			System.out.println(a);
		}
		
	}
	
	public static void ex04() {    // 연습
		
		// 구구단 2단 출력
		// 2 x 1 = 2
		// 2 x 2 = 4
		// ...
		
		int dan = 9; // 이 곳에 원하는 구구단을 넣으면 된다.
		
		for(int a = 1; a <= 9; a++) {
			System.out.println(dan + " x " + a + " = " + (dan * a)); // 2 부분이 두 군데로 겹치기 때문에 변수(dan)로 만들면 9단까지 가능
		}
		
	}
	
	public static void main(String[] args) {
		ex04();
	}

}
