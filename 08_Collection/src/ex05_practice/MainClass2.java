package ex05_practice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import ex02_List.User;

import java.util.Set;

public class MainClass2 {

	public static void ex01() {
		
		Map<String, Object> person = new HashMap<String, Object>();
		
		//추가
		person.put("name", "홍길동");
		person.put("age", 30);
		
		// 수정
		person.put("age", 40);
		
		//삭제
		//person.remove("age");
		int age = (int)person.remove("age");
		System.out.println("삭제된 나이 : " + age);
		
		System.out.println(person);
	}
	
	public static void ex02() {
		
		Map<String, String> dictionary = new HashMap<String, String>();
		dictionary.put("spring", "봄");
		dictionary.put("summer", "여름");
		dictionary.put("autumn", "가을");
		dictionary.put("winter", "겨울");
		
		// Value 가져오기
		String season = dictionary.get("winter");
		System.out.println(season);
	}

	public static void ex03() {
		
		Map<String, String> dictionary = new HashMap<String, String>();
		dictionary.put("spring", "봄");
		dictionary.put("summer", "여름");
		dictionary.put("autumn", "가을");
		dictionary.put("winter", "겨울");
		
		// Map 순회하기
		Set<String>  keySet = dictionary.keySet();
		for(String key : keySet) {
			System.out.println(key + ":" + dictionary.get(key));
		}
		
		for(Entry<String, String> entry : dictionary.entrySet()) {
			System.out.println(entry.getKey() + ":" + entry.getValue());
		}
	}
	
	public static void ex04() {
		
		// 제목(title), 저자(author), 가격(price)으로 구성되는 책(book) : HashMap
		Map<String, Object> book1 = new HashMap<String, Object>();
		book1.put("title", "어린왕자");
		book1.put("author", "생텍쥐베리");
		book1.put("price", 10000);
		
		Map<String, Object> book2 = new HashMap<String, Object>();
		book2.put("title", "열하일기");
		book2.put("author", "박지원");
		book2.put("price", 20000);
		
		Map<String, Object> book3 = new HashMap<String, Object>();
		book3.put("title", "불씨잡변");
		book3.put("author", "정도전");
		book3.put("price", 30000);
		
		// 책(book) 3권이 저장된 ArrayList
		List<Map<String, Object>> books = new ArrayList<Map<String,Object>>();
		books.add(book1);
		books.add(book2);
		books.add(book3);
		
		for(int i = 0; i < 3; i++) {		// List인 books에는 뭐가 들어 있을까?
			System.out.println(books.get(i));
		}
		
		// for문 순회 - 2개 필요
		// List의 순회
		for(int i = 0, length = books.size(); i < length; i++) {
			Map<String, Object> book = books.get(i);
			System.out.println((i + 1) + "번째 책의 정보");
		
			for(Entry<String, Object> entry : book.entrySet()) {
				System.out.println(entry.getKey() + " : " + entry.getValue());
			}
		}
	}
	
	
	public static void main(String[] args) {
		ex04();
	}

}
