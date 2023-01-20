package ex02_List;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainClass {

	public static void ex01() {
		// ☆☆☆ 아주 중요 ☆☆☆ 자주 쓸 것.
		
		// 배열 리스트(ArrayList) 선언 및 생성
		List<String> list = new ArrayList<String>();
		// 크기를 정하지 않음. 제한이 없음(저장공간 다 찰 때까지 가능)
		
		// 추가
		list.add("summer");   // 인데스 지정이 없으면 항상 마지막에 추가됨
		list.add("autumn");
		list.add("frog");
		list.add("winter");
		list.add(0, "spring");  // 인덱스 0에 spring 추가됨, 위에 거는 알아서 하나씩 밀린다.
		
		// 삭제 - 2가지 방법
		// list.remove("frog");   // 1. 삭제할 대상("frog") 직접 전달
		list.remove(3);         // 2. 삭제할 대상의 인덱스를 전달
		
		// 수정
		list.set(2, "fall");    // 인덱스 2의 요소를 fall로 수정함
		
		// 확인
		System.out.println(list);	// List는 배열을 sysout으로 볼 수 있게 제공해준다.
		System.out.println(list.size()); 
		System.out.println(list.get(3));
		
	}
	
	public static void ex02() {
		
		// ArrayList 초기화 - 특정 클래스(Arrays)의 도움을 받아야 함
		List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);   // 1,2,3,4,5 로 초기화를 했다.

		// 리스트 길이
		System.out.println("리스트 길이 : " + list.size());
		
		// 개별 요소 확인
		System.out.println("첫 번째 요소 : " + list.get(0));
		System.out.println("마지막 요소 : " + list.get(list.size()-1));
		
		// 리스트 순회
		// 모든 요소의 합계 구하기
		int total = 0;
		for(int i = 0, length = list.size(); i < length; i++) {   // 리팩토링함. 초기화 블록으로 옮겨서 list.size()가 1번만 실행됨
			total += list.get(i);
		}
		System.out.println("모든 요소의 합 : " + total);
		
	}
	
	public static void ex03() {   // 연습
		
		List<User> userList = new ArrayList<User>();    // 길이가 없다.
		
		for(int i = 0; i < 3; i++) {		// int i = 0, length = userList.size(); i < length;  → 0에서 0까지니까 반복문 한번도 안 하는 것임.
			User user = new User("user", "123456");
			userList.add(user);
		}
		
		// 아이디만 출력하기 ( 아이디가 필요해 )
		for(int i = 0, length = userList.size(); i < length; i++) { // 이미 위에서 어레이리스트 정해졌음. 
			System.out.println(userList.get(i).getId());
		}
		
	}
	
	public static void main(String[] args) {
		ex01();
	}

}
