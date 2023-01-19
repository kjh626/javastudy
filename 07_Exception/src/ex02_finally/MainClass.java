package ex02_finally;

import java.util.Scanner;

public class MainClass {

	public static void main(String[] args) {

		// finally 블록
		// 항상 마지막에 실행되는 블록으로 생략할 수 있다.
		
		Scanner sc = null;			// 선언, 생성 분리해놓는다. 선언할 때 초기화값을 주는 연습을 하는 것이 큰 도움이 될 것.
		
		try {
			sc = new Scanner(System.in);		// sc 선언문은 try블록에서 선언했기 때문에 벗어나면 사용할 수 없다. try밖으로 선언만 빼준다.
			System.out.print("나이를 입력하세요 >>> ");
			int age = sc.nextInt();		// 여기서 입력 후 예외에 해당하면 예외(catch)로 간다.
			System.out.println(age >= 20 ? "주류 구매 가능" : "주류 구매 불가능");	// 예외 발생하면 이 줄부터 실행 안 함.
			// sc.close(); 			// 이 코드도 실행 안 함. => sc.close() : 자원을 반납하는 역할을 수행. sc.close()는 생략 가능
		} catch(Exception e) {
			System.out.println("예외 발생");
		} finally {
			sc.close();		// finally 블록은 자원(resource)을 반납할 때 주로 사용한다. => 간단하게 말해서 finally는 close할 때 쓴다.
		}
	}	// 여기까지는 자바가 던져주는 예외, 이 다음에는 우리가 봤을 때 예외를 예외처리하는 방법에 대해

}
