package ex05_practice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

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
	
	public static void ex02() {
		
		Map<String, String> dictionary = new HashMap<String, String>();
		dictionary.put("Incheon", "인천");
		dictionary.put("Seoul", "서울");
		dictionary.put("Busan", "부산");
		dictionary.put("DaeJeon", "대전");
		
		// Value 가져오기
		// get(Key)
		String city = dictionary.get("DaeJeon");
		System.out.println(city);
	}
	
	public static void ex03() {
		
		Map<String, String> dictionary = new HashMap<String, String>();
		dictionary.put("Incheon", "인천");
		dictionary.put("Seoul", "서울");
		dictionary.put("Busan", "부산");
		dictionary.put("DaeJeon", "대전");
		
		// Map 순회하기
		
		// 1. Key만 모두 가져온 뒤, 해당 key값을 가진 Value를 가져오기
		Set<String> keySet = dictionary.keySet();
		for(String key : keySet) {
			System.out.println(key + ":" + dictionary.get(key));
		}
		
		// 2. Entry를 모두 가져온 뒤, Key와 Value로 분리하기(선생님 선호방법)
		for(Entry<String, String> entry : dictionary.entrySet()) {
			System.out.println(entry.getKey() + " : " + entry.getValue());
		}

	}
	public static void ex04() {
		
		// 제목(title), 저자(author), 가격(price)으로 구성되는 책(book) : HashMap
		Map<String, Object> book1 = new HashMap<String, Object>();
		book1.put("title", "슬램덩크");
		book1.put("author", "이노우에 다케히코");
		book1.put("price", "3000");
		Map<String, Object> book2 = new HashMap<String, Object>();
		book2.put("title", "원피스");
		book2.put("author", "오다");
		book2.put("price", "4500");
		Map<String, Object> book3 = new HashMap<String, Object>();
		book3.put("title", "원펀맨");
		book3.put("author", "one");
		book3.put("price", "6000");
		
		// 책(book) 3권이 저장된 ArrayList
		List<Map<String, Object>> books = new ArrayList<Map<String,Object>>();
		books.add(book1);
		books.add(book2);
		books.add(book3);
		
		// for문 순회 - 2개 필요
		
		// List의 순회
		for(int i = 0, length = books.size(); i < length; i++) {
			// Map의 순회(List에 저장된 요소가 Map이다.)
			Map<String, Object> book = books.get(i);
			System.out.println((i + 1) + "번째 책의 정보");
			for(Entry<String, Object> entry : book.entrySet() ) {
				System.out.println(entry.getKey() + " : " + entry.getValue());
			}
			
		}
		
	}
	
	public static void main(String[] args) {
		
		ex04();
	}
}
