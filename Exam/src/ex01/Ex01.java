package ex01;

public class Ex01 {

	public static void ex01() {
		
		// 문제1. int serial의 첫 번째 글자가 1,3,5이면 "남자", 2,4,6이면 "여자"를 출력하시오.
		// int serial의 첫 번째 글자는 항상 1 ~ 6 사이의 정수라고 가정한다.
		// 예시
		// 남자입니다.
		
		int serial = 6;
		if(serial < 1 || serial > 6) {
			return;
		}
		switch(serial % 2) {
		case 0:
			System.out.println("여자입니다.");
			break;
		default : System.out.println("남자입니다.");
		/*case 1:
			System.out.println("남자입니다.");
			break;
		*/
		
		}
	}
	
	public static void main(String[] args) {
		ex01();
	}
}
