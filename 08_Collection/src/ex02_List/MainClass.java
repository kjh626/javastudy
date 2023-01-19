package ex02_List;

import java.util.ArrayList;
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
	
	public static void main(String[] args) {
		
		ex01();
		
	}

}
