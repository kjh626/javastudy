package ex03_Reader;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONObject;

public class JSONMainClass {

	public static void main(String[] args) {

		// C:\storage\product.json 읽기
		
		File file = new File("C:" + File.separator + "storage", "product.json");
		
		BufferedReader br = null;
		
		try {
			
			br = new BufferedReader(new FileReader(file));
			
			String line = null;
			StringBuilder sb = new StringBuilder();
			while((line = br.readLine()) != null) {
				sb.append(line);
			}
			
			JSONArray arr = new JSONArray(sb.toString()); // 스트링빌더에 있는 정보를 스트링으로 바꿔서 넣어줘야한다. -> toString을 써주면 된다.

			// JSON배열에 있는 내용을 List로 보내줄 것
			List<Map<String, Object>> products = new ArrayList<Map<String,Object>>();
			for(int i = 0; i < arr.length(); i++) {
				JSONObject obj = arr.getJSONObject(i);
				products.add(obj.toMap());	// 라이브러리에 Object를 Map으로 바꾸는 toMap() 메소드
											// JSONObject obj를 Map으로 바꿔서 List에 저장하기
			}
			
			System.out.println(products);
			
		} catch(IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if(br != null) {
					br.close();
				}
			} catch(IOException e) {
				e.printStackTrace();
			}
		}
	}

}
