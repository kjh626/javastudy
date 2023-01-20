package ex03_practice;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class MainClass {
	
	public static void ex01() {
		
		// Set이라는 인터페이스
		// HashSet 객체 선언 및 생성
		Set<String> set = new HashSet<String>();
		
		// 추가
		set.add("빨강");
		set.add("주황");
		set.add("노랑");
		set.add("노랑");
		set.add("초록");
		set.add("파랑");
		
		// 제거
		set.remove("주황");
		
		// 확인
		System.out.println(set);
	}
	
	public static void ex02() {
		
		Set<Integer> set = new HashSet<Integer>(Arrays.asList(10,20,30,40,50));
		
		for(Integer n : set) {
			System.out.println(n);
		}
	}
	
	public static void ex03() {
		
		Set<Integer> set1 = new HashSet<Integer>(Arrays.asList(1,2,4,5));
		Set<Integer> set2 = new HashSet<Integer>(Arrays.asList(3,5,6,7));
		
		//교집합
		set1.retainAll(set2);
		
		System.out.println(set1);
		System.out.println(set2);
	}
	
	public static void ex04() {  // 기록만 남겨두는 것
		
		Set<Integer> set1 = new HashSet<Integer>(Arrays.asList(1, 2, 3, 4, 5));
		Set<Integer> set2 = new HashSet<Integer>(Arrays.asList(3, 4, 5, 6, 7));
		
		// 합집합
		set1.addAll(set2);    // set1에 합집합 결과가 저장된다.
		
		System.out.println(set1);
		System.out.println(set2);
		
	}
	
	public static void ex05() {  // 기록만 남겨두는 것
		
		Set<Integer> set1 = new HashSet<Integer>(Arrays.asList(1, 2, 3, 4, 5));
		Set<Integer> set2 = new HashSet<Integer>(Arrays.asList(3, 4, 5, 6, 7));
		
		// 차집합
		set1.removeAll(set2);    // set1에 차집합 결과가 저장된다.
		
		System.out.println(set1);
		System.out.println(set2);
	}
	
	public static void ex06() {
		Set<Integer> lotto = new HashSet<Integer>();
		
		// 1 ~ 45 : 6개 랜덤으로 발생
		while(lotto.size() < 6) {
			lotto.add((int)(Math.random() * 45) + 1);
		}
		System.out.println(lotto);
	}
	
	public static void main(String[] args) {
		ex06();
	}
}
