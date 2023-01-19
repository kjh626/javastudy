package ex03_practice;

import java.util.Scanner;

public class MainClass {

	public static void ex01() {
		
		try {
			//Integer.parseInt("히히힣");
			int a = 5 / 0;
			System.out.println(a);
			
		} catch(Exception e) {
			System.out.println(e.getClass().getName());
			System.out.println(e.getMessage());
		}
		
	}
	
	public static void ex02() {
		
		try {
			Integer.parseInt("knight");
		} catch(Exception e) {
			e.printStackTrace();
			System.out.println(e.getClass().getName());
			System.out.println(e.getMessage());
		}
	}

	public static void ex03() {
		
		// throw
		
		Scanner sc = null;
		
		try {
			sc = new Scanner(System.in);
			System.out.print("나이를 입력하세요 >>> ");
			int age = sc.nextInt();
			if(age < 0 || age > 100) {
				throw new RuntimeException(age + "살은 불가능합니다.");
			}
			System.out.println(age >= 20 ? "주류 가능" : "주류 불가능");
		} catch(Exception e) {
			System.out.println(e.getMessage());
		} finally {
			sc.close();
		}
		
	}
	
	public static void main(String[] args) {
		ex03();
	}

}
