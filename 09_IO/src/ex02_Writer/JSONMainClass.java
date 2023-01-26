package ex02_Writer;

import org.json.JSONArray;
import org.json.JSONObject;

public class JSONMainClass {

	/*
		JSON 
		1. JavaScript Object Notation
		2. 객체는 { }로 표기하고, 배열은 [ ]로 표기한다.
		3. 프로퍼티(Property)와 값(value)으로 데이터를 구성한다.
	*/

	/*
		JSON-Java (JSON in Java) 라이브러리
		1. 객체 : JSONObject 클래스 (Map 기반으로 제작된 클래스. 사용법이 Map과 흡사)
		2. 배열 : JSONArray 클래스 
	*/
	public static void ex01() {
		
		// 목표. 아래 JSON 만들기 ( Object만들기 )
		/*
			{
				"model" : "세탁기"
				"maker" : "삼성"
				"price" : 100
			}
		*/
		
		JSONObject product = new JSONObject();
		// Map 이랑 사용법 똑같다.
		product.put("model", "세탁기");	
		product.put("maker", "삼성");
		product.put("price", 100);
		
		System.out.println(product.toString()); 	// toSting : String으로 바꿔준다.
	}
	
	public static void ex02() {
		
		// 목표. 아래 JSON 만들기 ( Object만들기 )
		/*
		시작할 때 열어주는 대괄호
			[
				{
					"model" : "세탁기"
					"maker" : "삼성"
					"price" : 100
				},
				{
					"model" : "냉장고"
					"maker" : LG
					"price" : 200
				}
			] 닫는 대괄호
		*/

		
		JSONObject product1 = new JSONObject();

		product1.put("model", "세탁기");	
		product1.put("maker", "삼성");
		product1.put("price", 100);
		
		JSONObject product2 = new JSONObject();
		
		product2.put("model", "냉장고");	
		product2.put("maker", "LG");
		product2.put("price", 200);
		
		
		JSONArray products = new JSONArray();
		products.put(product1);
		products.put(product2);
		
		System.out.println(products.toString());
		
	}
	
	public static void ex03() {
		
		// String 형식의 JSON 데이터
		String str = "{\"name\":\"james\",\"age\":30,\"height\":180.5,\"isAlive\":true}";	// String 형식으로 작성할 거면 밖에다 작성하고 ""로 복붙해라.

		// JSONObject 객체 생성
		JSONObject obj = new JSONObject(str);
		
		// JSONObject 객체를 구성하는 프로퍼티 값 가져오기
		String name = obj.getString("name");	// 프로퍼티이름은 "name"
		// String name = (String)obj.get("name");
		int age = obj.getInt("age");			// 꼭 문자열로 프로퍼티 이름을 지정해줘야 한다.
		double height = obj.getDouble("height");
		boolean isAlive = obj.getBoolean("isAlive");
		// Map 에서는 String name = obj.get("name"); 안 됨. 왜냐? -> 타입이 안 맞아서 캐스팅 해줘야한다. Object로 저장하기 때문에..
		
		
		System.out.println(name);
		System.out.println(age);
		System.out.println(height);
		System.out.println(isAlive);
	}

	public static void ex04() {
		
		// 객체 2개를 저장한 배열
		// String 형식의 JSON 데이터
		String str = "[{\"model\":\"세탁기\",\"maker\":\"삼성\",\"price\":\"100\"},{\"model\":\"냉장고\",\"maker\":\"LG\",\"price\":200}]";
				
		// JSONArray 객체 생성
		JSONArray products = new JSONArray(str);
		
		// 1. 일반 for문
		for(int i = 0; i < products.length(); i++) { 	// 객체를 읽어들이는 get=>
			JSONObject obj = products.getJSONObject(i);	// 하나의 객체를 가져와서 obj에 전달
			String model = obj.getString("model");
			String maker = obj.getString("maker");
			int price = obj.getInt("price");
			System.out.println(model + "," + maker + "," + price);
		}
		
		
	}
	
	public static void main(String[] args) {
		ex04();
	}

}
