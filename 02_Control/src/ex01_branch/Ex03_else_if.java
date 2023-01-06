package ex01_branch;

public class Ex03_else_if {

	public static void ex01() {
	
		// 80 이상 : 상
		// 60 이상 : 중
		// 나머지  : 하
		
		int score = 80;
		
		if(score >= 80) {
			System.out.println("상");
		} 
		else if(score >= 60) {  		// 가독성이 좋아짐.
			System.out.println("중");
		}
		else {
			System.out.println("하");
		}
		
	}

	public static void ex02() {   // 연습
		
		// 수, 우, 미, 양, 가, 잘못된 점수(100초과, 마이너스 점수)
		// 90 80 70 60 나머지
		
		int score = 95;
		
		if(score < 0 || score > 100) { 			// 잘못된 점수 먼저 처리 해주자
			System.out.println("잘못된 점수");
		} 
		else if(score >= 90) {
			System.out.println("수");
		} 
		else if(score >= 80) {
			System.out.println("우");
		} 
		else if(score >= 70) {
			System.out.println("미");
		} 
		else if(score >= 60) {
			System.out.println("양");
		} 
		else {
			System.out.println("가");
		} 
		
	}

	public static void ex03() {   // 연습
		
		int month = 11; // 나누기로 생각 (12로 나눈다, 12,1,2를 12로 나누면 나머지값이 0,1,2로 나온다)
		
		int mod = month % 12;
		
		if(mod <= 2) {
			System.out.println("겨울");
		}
		else if(mod <= 5) {
			System.out.println("봄");
		} 
		else if(mod <= 8) {
			System.out.println("여름");
		} 
		else {
			System.out.println("가을");
		} 
		
		/* if(month <= 2) {
			System.out.println("겨울");
		}
		else if(month <= 5) {
			System.out.println("봄");
		} 
		else if(month <= 8) {
			System.out.println("여름");
		} 
		else {
			System.out.println("가을");
		} */
		
	}
	
	public static void ex04() {   // 연습
		
		int day = 6; // 6일은 금요일
		int nDay = 10;	// 10일 후
		
		day += nDay; // day = day + nDay; 복합연산으로 바꿔봄 같은 계산임.
		
		String weekName;	// 월요일이 나와야 됨
		
		int mod = day % 7;	// mod값으로 계산
		
		if(mod == 0) {
			weekName = "토";
		}
		else if(mod == 1) {
			weekName = "일";
		}
		else if(mod == 2) {
			weekName = "월";
		}
		else if(mod == 3) {
			weekName = "화";
		}
		else if(mod == 4) {
			weekName = "수";
		}
		else if(mod == 5) {
			weekName = "목";
		}
		else {
			weekName = "금";
		} // 배운 게 없어서 조금 긺.
		
		System.out.println(nDay + "일 후는 " + weekName + "요일이다.");
		
	}
	 
	
	
	public static void main(String[] args) {
		ex04();
	}

}
