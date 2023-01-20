package ex05_practice;

import java.util.HashMap;
import java.util.Map;

// 실무에서 많이 쓰는 타입 List<Map<String, Object>>

public class MainClass {
	
	public static void ex01() {
		
		Map<String, Object> person = new HashMap<String, Object>();
		
		person.put("name", "홍길동");
		person.put("age", 70);
		
		// 수정
		person.put("name", "김정현");
		person.put("age", 30);
		
		// 삭제
		//person.remove("name");
		
		int age = (int)person.remove("age");
		System.out.println("삭제된 나이 : " + age );
		
		String name = (String)person.remove("name");
		System.out.println("삭제된 이름 : " + name);
		
		System.out.println(person);
	}
	public static void main(String[] args) {
		
		ex01();
	}
}
