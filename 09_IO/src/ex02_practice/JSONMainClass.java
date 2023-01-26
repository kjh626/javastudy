package ex02_practice;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONObject;


// https://www.json.org/json-en.html
public class JSONMainClass {

	public static void ex01() {
		
		// 객체 : 중괄호 { }
		JSONObject product = new JSONObject();
		
		product.put("model", "가습기");
		product.put("maker", "LG");
		product.put("price", 100);
		
		System.out.println(product.toString());
		
	}
	
	public static void ex02() {
		
		// 배열 : 대괄호 [ ]
		JSONObject product1 = new JSONObject();
		product1.put("model", "가습기");
		product1.put("maker", "LG");
		product1.put("price", 100);
		
		JSONObject product2 = new JSONObject();
		product2.put("model", "건조기");
		product2.put("maker", "삼성");
		product2.put("price", 300);
		
		JSONArray products = new JSONArray();
		products.put(product1);
		products.put(product2);
		
		System.out.println(products.toString());
		
	}
	
	public static void ex03() {

		// String 형식의 JSON 데이터
		String str = "{\"name\":\"james\",\"age\":22,\"height\":200.3,\"isAlive\":true}";
		// JSONObject 객체 생성
		JSONObject obj = new JSONObject(str);
		// JSONObject 객체를 구성하는 프로퍼티 값 가져오기
		String name = obj.getString("name");
		int age = obj.getInt("age");
		double height = obj.getDouble("height");
		boolean isAlive = obj.getBoolean("isAlive");
		
		System.out.println(name);
		System.out.println(age);
		System.out.println(height);
		System.out.println(isAlive);
	}
	
	public static void ex04() {
		
		String str = "[{\"model\":\"가습기\",\"maker\":\"삼성\",\"price\":100},{\"model\":\"건조기\",\"maker\":\"LG\",\"price\":200}]";
		
		JSONArray products = new JSONArray(str);
		
		// 1. 일반 for문
		for(int i = 0; i < products.length(); i++) {
			JSONObject obj = products.getJSONObject(i);
			String model = obj.getString("model");
			String maker = obj.getString("maker");
			int price = obj.getInt("price");
			System.out.println(model + "," + maker + "," + price);
		}
		// 2. 향상 for문
		for(Object obj : products) {
			JSONObject product = (JSONObject) obj;
			String model = product.getString("model");
			String maker = product.getString("maker");
			int price = product.getInt("price");
			System.out.println(model + "," + maker + "," + price);
		}
	}
	
	public static void ex05() {
		
		Map<String, Object> product1 = new HashMap<String, Object>();
		product1.put("model", "세탁기");
		product1.put("maker", "삼성");
		product1.put("price", 100);
		
		Map<String, Object> product2 = new HashMap<String, Object>();
		product2.put("model", "냉장고");
		product2.put("maker", "LG");
		product2.put("price", 200);
		
		Map<String, Object> product3 = new HashMap<String, Object>();
		product3.put("model", "TV");
		product3.put("maker", "삼성");
		product3.put("price", 300);
		
		List<Map<String, Object>> products = Arrays.asList(product1, product2, product3);
		
		
		JSONArray arr = new JSONArray(products);
		
		String content = arr.toString();
		File dir = new File("C:" + File.separator + "storage");
		if(dir.exists() == false) {
			dir.mkdirs();
		}
		File file = new File(dir, "product.json");
		
		try(BufferedWriter bw = new BufferedWriter(new FileWriter(file))) {
			bw.write(content);
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		ex05();
	}

}
