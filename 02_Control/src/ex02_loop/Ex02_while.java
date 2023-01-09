package ex02_loop;

public class Ex02_while {

	/*
		while문 (대상 : 특정 file, db)
		1. 특정 조건을 만족하면 반복하는 반복문(어떤 데이터를 가져오는 경우 주로 사용)
		2. 형식
			while(조건문) {
				실행문
			}
	 */
	
	public static void ex01() {
		
		// 1 ~ 10 (for문으로 짜는 문제임)
		int a = 1;
		while(a <= 10) {
			System.out.println(a);
			a++;
		}
		
	}
	
	public static void ex02() {
		
		int account = 85000;
		int money = 550;    // 550원씩 출금
		int n = 0;  // 출금의 횟수
		
		while(account >= money) {    // 돈이 남아있으면 계속 빼가겠다.
			System.out.print(++n + "번째 출금 결과 : ");    // ++n을 써서 먼저 n을 1로 증가시켜 사용
			account -= money;
			System.out.println("계좌 " + account + "원");
		}
		
	}
	
	public static void main(String[] args) {
		ex02();
	}

}
