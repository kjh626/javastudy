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

public class JSONMainClass2 {

	public static void ex01() {
		
		JSONObject product = new JSONObject();
		
		product.put("model", "세탁기");
		product.put("maker", "삼성");
		product.put("price", 100);
		
		System.out.println(product.toString());
	}
	
	public static void ex02() {
		
		JSONObject product1 = new JSONObject();
		
		product1.put("model", "세탁기");
		product1.put("maker", "삼성");
		product1.put("price", 100);
		
		JSONObject product2 = new JSONObject();
		
		product2.put("model", "건조기");
		product2.put("maker", "LG");
		product2.put("price", 200);
		
		JSONArray products = new JSONArray();
		products.put(product1);
		products.put(product2);
		
		System.out.println(products.toString());
	}
	
	public static void ex03() {

		String str = "{\"name\":\"james\",\"age\":30,\"height\":180.5,\"isAlive\":\"true\"}";
		
		JSONObject obj = new JSONObject(str);
		
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

		String str = "[{\"price\":100,\"maker\":\"삼성\",\"model\":\"세탁기\"},{\"price\":200,\"maker\":\"LG\",\"model\":\"건조기\"}]";
		
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
		System.out.println(content);
		File dir = new File("C:" + File.separator + "pracstorage");
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
