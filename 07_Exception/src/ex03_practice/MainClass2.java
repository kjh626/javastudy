package ex03_practice;

import java.util.Scanner;

public class MainClass2 {

	public static void main(String[] args) {

		Scanner sc = null;
		
		try {
			sc = new Scanner(System.in);
			System.out.print("나이를 입력하세요 >>> ");
			int age = sc.nextInt();
			System.out.println(age >= 20 ? "주류 구매 가능" : "주류 구매 불가능");
			
		} catch (Exception e) {
			System.out.println("예외 발생");
		} finally {
			sc.close();
		}
		
		
	}

}
