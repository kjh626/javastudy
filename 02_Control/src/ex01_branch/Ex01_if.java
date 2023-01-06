package ex01_branch;

public class Ex01_if {
	
	public static void ex01() {
		
		// if 문
		
		int score = 50;
		
		if(score >= 60)
			System.out.println("합격");
		
		if(score < 60)
			System.out.println("불합격");
		
	}
	
	public static void ex02() {
		
		// if 문의 중괄호 (if문의 적용 범위는 한 줄, 그래서 두 줄 이상이면 중괄호를 꼭 적어줘야 한다.)
		// 실행문이 1개인 경우 생략할 수 있다.
		// 실행문이 2개 이상인 경우 반드시 필요하다.
		// 많은 사람들은 중괄호를 생략하지 않고 무조건 적어준다. 시작과 끝을 명확하게 구분해주는 역할을 해주는 중괄호이기 때문에 적어주는 편이 좋아보인다.
		
		int score = 50;
		
		if (score >= 60) {
			System.out.println("합격"); 
			System.out.println("축하합니다."); 
		}
			
		if (score < 60) {
			System.out.println("불합격");
			System.out.println("보충수업입니다.");
		}
		
	}
	
	public static void main(String[] args) {
		ex02();
			
		
		
	}

}
