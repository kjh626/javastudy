package ex01_one_dim;

public class Ex03_advanced_for {

	public static void ex01() {    // 이 정도를 안 보고 쓸 수 있도록 (손코딩: 적어서 가능한). 코드 암기가 될 수 있도록.
		// 합계 구하기 
		// 향상 for문 : 배열 전용 for문
		
		int[] scores = {50, 90, 60, 100, 80};
		
		int total = 0;
		int max = 0; // 가장 작은 값으로 잡아줌
		int min = 100; // 가장 큰 값으로 
		
		for(int n : scores) { // scores에 있는 값을 순차적으로 n으로 빼서 사용하겠습니다. 라는 뜻
			total += n;
			if(max < n) {
				max = n;
			}
			if(min > n) {
				min = n;
			}
		}

		System.out.println(total);
		System.out.println(max);
		System.out.println(min);
		
	}

	public static void ex02() {
		
		String[] files = {"hello.txt", "hi.txt", "안녕.txt"};
		
		for(String file : files) {
			System.out.println(file);
		}
		
	}
	
	public static void main(String[] args) {
		ex02();
	}

}
