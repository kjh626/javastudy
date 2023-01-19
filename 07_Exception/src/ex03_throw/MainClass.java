package ex03_throw;

import java.util.Scanner;

public class MainClass {

	public static void ex01() {
		
		try {
			
			Integer.parseInt("하핳");
			int a = 4 / 0;
			System.out.println(a);
			
		} catch(Exception e) {	// 예외 정보는 e에 들어가 있다.	
			
			System.out.println(e.getClass().getName());	// 예외 클래스 이름 확인하기.(ArithmeticException, NumberFormatException... )
			System.out.println(e.getMessage()); 		// 예외 메시지 확인. 왜 발생했는지 같은 설명(/ by zero, For input string: "하핳"... )
		}
		
	}
	
	public static void ex02() {
		
		try {
			
			Integer.parseInt("호홓");
			
		} catch(Exception e) {  		
			// catch의 내용을 채워놔야 문제를 알기 쉽다.
			e.printStackTrace(); 		// 예외를 추적하는 메소드(개발중에는 이것만 사용함). 우리는 추적해서 수정하면 됨.
			
		}	// 이 catch가 try,catch에서 기본이 되는 코드라 생각해라
		
	}
	
	public static void ex03() {
		
		/*
			throw 
			1. 예외 객체를 생성해서 직접 던질 수 있다.
			2. 개발자가 직접 예외를 처리할 때 사용한다.
		*/
		Scanner sc = null;
		
		try {
			sc = new Scanner(System.in);
			System.out.println("나이를 입력하세요 >>> ");
			int age = sc.nextInt();
			if(age < 0 || age > 100) {
				throw new RuntimeException(age + "살은 불가능합니다.");		// 그냥 RuntimeException 던져라
			}
			System.out.println(age >= 20 ? "주류 구매 가능" : "주류 구매 불가능");
			
		} catch(Exception e) {
			System.out.println(e.getMessage());		// 메시지 확인하는 방법
		} finally {
			sc.close();
		}
		
	}
	
	public static void main(String[] args) {
		ex01();
	}
	
}
