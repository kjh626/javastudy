package ex03_Set;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class MainClass {

	/*
		Set
		1. 저장된 요소들의 index가 없다. → 저장 순서가 없다.
		2. 중복 저장이 되지 않는다. => (유니크한 데이터)중복 없는 데이터 저장할 때, 관리할 때 Set이 좋다.
	*/
	
	public static void ex01() {
		
		// Set이라는 인터페이스
		// HashSet 객체 선언 및 생성
		Set<String> set = new HashSet<String>();	// generic 구조
		
		// 추가
		set.add("spring");
		set.add("spring");  // 무시됨
		set.add("spring");  // 무시됨
		set.add("summer");
		set.add("autumn");
		set.add("winter");

		// 제거
		set.remove("winter");
		
		// 확인
		System.out.println(set);  //[spring, winter, autumn, summer] 이르케 나옴 => 순서가 없다.
		
	}
	
	public static void ex02() {
		
		// HashSet 객체의 초기화 (List를 이용해서 초기화를 진행)
		Set<Integer> set = new HashSet<Integer>(Arrays.asList(1, 2, 3, 4, 5));
		
		// 인덱스가 없기 때문에 향상 for문만 가능하다
		for(Integer n : set) {
			System.out.println(n);
		}
		
	}
	
	public static void ex03() { // 기록만 남겨두는 것
		
		Set<Integer> set1 = new HashSet<Integer>(Arrays.asList(1, 2, 3, 4, 5));
		Set<Integer> set2 = new HashSet<Integer>(Arrays.asList(3, 4, 5, 6, 7));
		
		// 교집합
		set1.retainAll(set2);	// set1 에 교집합 결과가 저장된다.
		// 문제는 교집합 결과가 반환되지 않는다. 그 결과 어디에 저장??
		
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
	
	public static void ex06() {   // 연습
		Set<Integer> lotto = new HashSet<Integer>();
		
		// 1 ~ 45 : 6개 랜덤으로 발생
		while(lotto.size() < 6) {
			lotto.add((int)(Math.random() * 45) + 1);
		}
		System.out.println(lotto);
	}
	
	public static void main(String[] args) {
	
		ex05();
		
	}
}
