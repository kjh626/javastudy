package ex02_loop;

public class Ex03_break {

	/*
		break문
		1. switch문 종료
		2. 반복문(for, while) 종료
	 */
	
	public static void ex01() {
		
		/*
			무한루프
			1. 끝나지 않는 반복문
			2. 형식
				for(;;)
				while(true)   => 대부분 while문 사용
		 */
		
		// 1 ~ 10 (for문으로 하는 문제)
		
		int a = 1;
		while(true) {
			
			if(a > 10) {
				break;
			}
			
			System.out.println(a);
			a++;
			
		}
		
	}
	
	public static void ex02() {
		
		// 모금 (예시 둘다 for문으로 만드는 게 가능. for문으로 하는 게 좋다)
		
		int goal = 100000;
		int money = 60;    // 60원씩 모금한다고 가정
		int total = 0;    // 누적 모금액
		int n = 0;
		
		while(true) {
			
			// 1회 모금액 60원 현재 60원
			// 2회 모금액 60원 현재 120원
			// ?회 모금액 60원 현재 100000원 이상이면 그만
			if(total >= goal) {
				break;
			}
			total += money;
			System.out.println(++n + "회 모금액 " + money + "원, 현재 모금액 " + total + "원");
		}
		
		
	}
	
	public static void ex03() {    //for문으로 연습하기
		
		int goal = 100000;
		int money = 60;
		int total = 0;
		
		for(int n = 1; total <= goal; n++) {
			total += money;
			System.out.println(n + "회 모금액 " + money + "원, 현재 모금액 " + total + "원");
		}
	}
	
	public static void main(String[] args) {
		ex03();
	}

}
