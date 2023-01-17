package ex03_date_time;

public class Ex01_System {

	public static void ex01() {
		
		/*
			타임스탬프
			1. 현재 시간을 long 타입의 정수값으로 가지고 있는 값을 의미한다.
			2. 1970년 01월 01일 0시부터 1/1000초 마다 1씩 증가하고 있는 값이다.
		*/
		long timestamp = System.currentTimeMillis();
		System.out.println(timestamp);		// 임시 파일 이름으로 쓸 수 있다. 웬만해서는 겹치지 않는다.
	}
	
	public static void ex02() {
		
		/* 나노 타임 은 2번 재서 얼마가 걸렸는지를 재는 용도
			시간 단위
			second > ㎳ 	 > ㎲		 > ㎱ 	  > ㎰
					 밀리초    마이크로초  나노초   피코초
		*/
		
		// String의 + 연산과 StringBuilder의 append 메소드 성능 확인하기
		String str = "";
		StringBuilder sb = new StringBuilder();
		
		// 시작시간
		long nanoTime1 = System.nanoTime();	// 나노 타임은 timestamp값이 아님(1970~ 현재시간 아님)

		// 작업수행
		for(char ch = 'A'; ch <+ 'Z'; ch++) {
			// str += ch;	// 70400ns
			 sb.append(ch);  // 13700ns
		}
		
		// 종료시간
		long nanoTime2 = System.nanoTime();
		
		// 결과 확인
		System.out.println("작업수행시간 : " + (nanoTime2 - nanoTime1) + "ns");
		
	}
	
	public static void main(String[] args) {
		ex02();
		
	}

}
