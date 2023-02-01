package c;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

public class MainClass {

	public static void ex01() {
		// 둘의 차이점은 무엇인가?
		/* ArrayList는 clone() 메소드가 있다. 
		List 는 인터페이스 : 사용할 수 있는 메소드가 적을 수 있다. <= 인터페이스에서의 구현클래스를 생각(Person - eat(), Student implements Person - eat(), study())
		인터페이스는 추상메소드(본문X) 때문에 Person p = new Person() 불가능하다. 메소드의 본문이 없기 때문에 할 수 없음. / 람다에서 배우는 데 하는 방법이 있다.
		보통 구현체(ArrayList)가 메소드가 더 많다.
		ArrayList의 메소드(전용 메소드)를 꼭 써야된다 싶으면 List말고 ArrayList를 써야한다. ArrayList<String> list = ...;
		그런데 우린 필요가 없어서 안 썼다.
		*/
		List<String> list = new ArrayList<String>();
		// 순서대로 저장된다
		list.add("봄");
		list.add("여름");
		list.add("가을");
		list.add("겨울");
		// 꺼내보기 , 상대적으로 삭제같은 거는 거의 할 일 없다.(DB에서 가져올 때 삭제할 거는 가져오지 않는다. 조건 지정해서 가져오기 때문에...) DB -> Array -> View (예쁘게 펼쳐볼 수 있음)
		System.out.println(list.get(0));
		System.out.println(list.get(1));
		System.out.println(list.get(2));
		System.out.println(list.get(3));

		for(int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
		System.out.println("------");
		// 향상 for문 앞에가 변수, 뒤에가 배열이나 리스트
		for(String season : list) {
			System.out.println(season);
		}
		
		// 일반 for문 과 향상 for문의 차이점 : index가 없다. 
		/*
		int[] arr = new int[3];
		arr[0] = 10;
		arr[1] = 20;
		arr[2] = 30;
		
		for(int i = 0; i < arr.length; i++) {
			arr[i] += 10; 	// 20  30  40
		}
		
		for(int n : arr) {
			n += 10;	// 10  20  30
		}  // n은 배열요소를 전달 받은 변수(복사)
		   // n 이 더하기를 당하는 것. 배열에 더해지는 것이 아니다.
		   // arr[0] -> n -> n + 10 , arr[1] -> n -> n + 10, arr[1] -> n -> n + 10
		System.out.println(Arrays.toString(arr));
		*/
	}
	
	public static void ex02() {
		
		// 트리맵 키값이 자연스럽게 트리구조로 저장된다. 그래서 데이터의 순서 관리가 쉽다.
		// 트리맵의 순서관리기법이 트리맵의 장점. ArrayList로 선언한 거 처럼, 전용메소드가 잔뜩 있다.
		TreeMap<Integer, String> treeMap = new TreeMap<Integer, String>();
		// 애들이 시험을 봤는데 성적순으로 저장하고 싶다
		treeMap.put(90, "제시카");
		treeMap.put(100, "블랑카");
		treeMap.put(50, "제레미");
		treeMap.put(80, "사만다");
		
		System.out.println(treeMap);	// 순서가 점수 순서대로 되어있다.
		// 트리맵을 Map 타입으로 쓰면 쓸 수 있는 메소드 적어진다. 트리맵 쓸 때는 타입을 TreeMap으로 써야함.
		
		Map<Integer, String> map = new HashMap<Integer, String>();
		map.put(1, "a");
		map.put(10, "b");
		map.put(101, "c");
		map.put(11, "d");
		
		System.out.println(map);	// 순서가 저장순서대로가 아님. 순서가 지멋대로임.
		
	}
	public static void ex03() {
		// 종종 사용하는 Map
		
		String name = "제시카";
		String phone = "010-1111-2222";
		int age = 20;
		
		Map<String, String> map = new HashMap<String, String>();
		map.put("name", name);
		map.put("phone", phone);
		map.put("age", age + "");
	
		System.out.println(map);
	}
	
	public static void ex04() {
		
		Map<String, Object> map = new HashMap<String, Object>();
		// Post방식이어서 주소창에 못 붙이는 상황.(Post 예: 로그인하면 아이디,비번 주소창에 안 붙음)
		map.put("Service-Key", "aikrbgbdsfk");
		map.put("Content-Type", "application/xml");
		
		// 그냥 get메소드로 map에서 꺼내기 => get메소드! / entrySet으로 하는 것도 있고 get메소드로 직접 꺼내는 경우도 있다.
		System.out.println(map.get("Service-Key"));
		System.out.println(map.get("Content-Type"));
		
		ex05(map);	// ex05에 전달
		// 보내고자 하는 데이터가 많을 때 예) 아이디, 비밀번호를 하나로 합친다(객체로 만들든, 맵으로 만들든)
		// 하나로 만들어서 보낸다(ex05에 보내는 것처럼) 그리고 보내진 데이터는 다시 풀어 헤친다(분할한다). 
		// 나중되면 기능 하나 구현하기 위해 파일 5~6개 켜놓고 넘기고 넘기고 넘기고 해줘야 한다.
	}

	public static void ex05(Map<String, Object> map) {
		// map에 있는 내용을 하나씩 꺼내서 출력하려고 한다.
		// 맵은 하나의 데이터(다 붙어있다 생각) -> entrySet을 통해 분할을 해준다. 그리고 그걸 Set에 저장한다.
		// => for문 써야 함.

		/* 풀어서 쓰자면
		Set<Entry<String, Object>> set = map.entrySet();
		for( Entry<String, Object> entry : set ) {

		}
		*/
		for( Entry<String, Object> entry : map.entrySet() ) {
			System.out.println(entry.getKey() + " : " + entry.getValue());
		}
		
	}
	
	public static void main(String[] args) {
		ex04();		
	}

}
