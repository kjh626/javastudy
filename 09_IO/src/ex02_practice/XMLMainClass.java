package ex02_practice;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;


public class XMLMainClass {

	public static void main(String[] args) {

		/* 
		목표
		1. 경로 
				C:\storage\product.xml => products.xml을 document 라고 부름
		2. 내용 - 이런 처리방식을 dom 처리방식(문서객체모델 처리방식)이라고 한다. 문서를 document로 보자, element로 보자. 모두 객체로 바라보는..
			<products>
				<product>
					<model>세탁기</model>	// 태그 사이의 텍스트 -> textContent라고 부른다.
					<maker>삼성</maker>
					<price>100</price>
				</product>
				<product>
					<model>냉장고</model>
					<maker>LG</maker>
					<price>200</price>
				</product>
				<product>
					<model>TV</model>
					<maker>삼성</maker>
					<price>300</price>
				</product>
			</products>
	*/
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
		
		List<Map<String, Object>> productList = Arrays.asList(product1, product2, product3);
		
		try {
		// Document 생성(Document는 XML문서 자체를 의미한다.)
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		Document document = builder.newDocument();
		
		// <products> 태그 : Element 생성
		Element products = document.createElement("products");
		document.appendChild(products);
		
		// productList 순회
		for(Map<String, Object> map : productList) {
			// <product> 태그 : Element 생성
			Element product = document.createElement("product");
			document.appendChild(products);
			
			// <model> 태그 : Element 생성
			Element model = document.createElement("model");
			document.appendChild(model);
			document.setTextContent((String)map.get("model"));
			// <maker> 태그 : Element 생성
			
			// <price> 태그 : Element 생성
			
		}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
