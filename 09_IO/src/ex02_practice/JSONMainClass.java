package ex02_practice;

import org.json.JSONArray;
import org.json.JSONObject;

public class JSONMainClass {

	public static void ex01() {
		
		JSONObject product = new JSONObject();
		
		product.put("model", "가습기");
		product.put("maker", "LG");
		product.put("price", 100);
		
		System.out.println(product.toString());
		
	}
	
	public static void ex02() {
		
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
	
	
	
	public static void main(String[] args) {
		ex02();
	}

}
