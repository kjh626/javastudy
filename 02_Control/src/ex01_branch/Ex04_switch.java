package ex01_branch;

public class Ex04_switch {

	/*
		switch(표현식) {
		case 값1: 실행문
		case 값2: 실행문
		...
		default: 실행문 -> default : if의 else 개념
		}
		
		표현식의 결과로 주로 사용하는 타입
		- int
		- String
		
		표현식의 결과로 사용 불가능한 타입
		- boolean 타입(a > 0 크기 비교 같은) true,false
		- long
		- double
	 */
	
	public static void ex01() {
		
		int month = 1;
		
		switch(month) { // 해당 번호 찾고, 아래로 쭉 그만하랄 때까지 실행함. break문이 필요함.
		case 12:
		case 1: 
		case 2: System.out.println("겨울"); break;
		case 3:
		case 4:
		case 5: System.out.println("봄"); break;
		case 6:
		case 7:
		case 8: System.out.println("여름"); break;
		default: System.out.println("가을"); // break 할 필요 X, 마지막 실행문 이기때문에 말 안해도 그만한다. 넣어도 문제없음.
		}
		
	}
	
	public static void ex02() {
		
		int day = 13;
		
		String weekName;
		
		switch(day % 7) {
		case 0: weekName = "토"; break;
		case 1: weekName = "일"; break;
		case 2: weekName = "월"; break;
		case 3: weekName = "화"; break;
		case 4: weekName = "수"; break;
		case 5: weekName = "목"; break;
		default: weekName = "금";	// else if문 보다 switch문이 가독성이 더 좋다
		}
		
		System.out.println(day + "일은 " + weekName + "요일이다.");
		
	}

	public static void ex03() {
		
		// 수, 우, 미, 양, 가, 잘못된 점수
		
		int score = 100; // 100일 경우(-> case 10: ), 일의 자리일 경우 어케함?(-> case 0: )
		
		// if로 처리해야할 것을 먼저 거른다. 실무에서는 if를 사용해서 switch문을 깔끔하게 쓴다.
		if(score < 0 || score > 100) {
			System.out.println("잘못된 점수");
			return;	  // ex03 메소드를 종료하시오.
		}
		
		switch(score / 10) {
			case 10: 
			case 9: System.out.println("수"); break;
			case 8: System.out.println("우"); break;
			case 7: System.out.println("미"); break;
			case 6: System.out.println("양"); break;
			default: System.out.println("가");		
			/*case 5:
			case 4:
			case 3:
			case 2:
			case 1: 
			case 0: System.out.println("가"); break;
			default: System.out.println("잘못된 점수"); 	if문으로 먼저 거르지 않았을 경우
			*/
		}
		
	}
	
	public static void ex04() {   // 연습
		
		// 1분기(1~3), 2분기, 3분기, 4분기
		// if, switch가 필요하진 않다.
		
		/* 1번
		int month = 11;
		
		switch(month) {
		case 1:
		case 2:
		case 3: System.out.println("1분기"); break;
		case 4:
		case 5:
		case 6: System.out.println("2분기"); break;
		case 7:
		case 8:
		case 9: System.out.println("3분기"); break;
		default: System.out.println("4분기");
		} */
		
		/* 2번
		int month = 11;
		
		switch(month) {
			case 1: case 2: case 3:
				System.out.println("1분기");
				break;						이렇게 적어도 된다.
			case 4: case 5: case 6:
				System.out.println("2분기");
				break;
			case 7: case 8: case 9:
				System.out.println("3분기");
				break;
			default: 
				System.out.println("4분기");
		}
		*/
		
		/* 3번 이런 계산식으로도 가능
		int month = 11;
		
		switch((month -1) / 3) {
			case 0:
				System.out.println("1분기");
				break;
			case 1:
				System.out.println("2분기");
				break;
			case 2:
				System.out.println("3분기");
				break;
			default: 
				System.out.println("4분기");
		} */
		
		int month = 11;
		
		System.out.println((month - 1) / 3 + 1 + "분기"); // 굳이 switch문 필요X. => 경험이 필요하다.
		
		
	}
	
	public static void main(String[] args) {
		ex04();
	}

}
