package ex03_Reader;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CSVMainClass {

	public static void main(String[] args) {

		// C:\storage\product.csv 읽기
		// 목적 : csv를 뽑아서 보관해두기
		File file = new File("C:" + File.separator + "storage", "product.csv");
		
		BufferedReader br = null;
		
		try {
			
			br = new BufferedReader(new FileReader(file));	// 파일을 읽을 통로
			
			List<Map<String, Object>> products = new ArrayList<Map<String,Object>>();
			
			String line = null;		// 초기화
			while((line = br.readLine()) != null) {
				String[] items = line.split(",");	 //{asda,adsf,zxcv} 이렇게 3개짜리 배열이 나와용. split은 배열로 반환해줌.
				Map<String, Object> product = new HashMap<String, Object>();
				product.put("model", items[0]);    // 세탁기
				product.put("maker", items[1]);    // 삼성
				product.put("price", Integer.parseInt(items[2]));    // 100 은 int 값인데... items는 String인뎅 -> parseInt 해줘야 한다.
				products.add(product);		// 제품들에 제품 넣기
				
			}
			
			System.out.println(products);
			
		} catch(IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if(br!= null) {
					br.close();
				} 
			} catch(IOException e) {
				e.printStackTrace();
			}
		}
		
		
	}

}
