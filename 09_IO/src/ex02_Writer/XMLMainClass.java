package ex02_Writer;

import java.io.File;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class XMLMainClass {

	/* 만드는 거 보다는 읽어들이는 걸 주로 하게 될 것이다.
		XML
		1. eXtensible Markup Language
		2. HTML(표준 마크업 언어)의 확장 버전
		3. 정해진 태그 외 사용자 정의 태그의 사용이 가능하다.
	*/
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
	public static void main(String[] args) {
		
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
			Document document = builder.newDocument();		// .dom
			document.setXmlStandalone(true);	// standalone="no"? 제거하기
			
			// <products> 태그 : Element 생성
			Element products = document.createElement("products");
			document.appendChild(products);		// 만들고, 자식으로 집어넣어 줘야 한다.
			
			// productList 순회
			for(Map<String, Object> map : productList) {
				
				// <product> 태그 : Element 생성
				Element product = document.createElement("product");
				products.appendChild(product);		// 만들고, 자식으로 집어넣어 줘야 한다.
				
				// <model> 태그 : Element 생성
				Element model = document.createElement("model");
				product.appendChild(model);
				model.setTextContent((String)map.get("model"));		// Object 타입이라 캐스팅해줘야 한다. toString으로도 가능. "" 도 가능.
				
				// <maker> 태그 : Element 생성
				Element maker = document.createElement("maker");
				product.appendChild(maker);
				maker.setTextContent((String)map.get("maker"));
				
				// <price> 태그 : Element 생성
				Element price = document.createElement("price");
				product.appendChild(price);
				price.setTextContent((int)map.get("price") + "");		// int로 캐스팅하지 마라.
			}
			
			// XML 설정
			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			transformer.setOutputProperty("encoding", "UTF-8"); 	// 출력속성 설정.
			transformer.setOutputProperty("indent", "yes");			// 들여쓰기
			transformer.setOutputProperty("doctype-public", "yes");  // standalone="no" 제거하기 위해서 document.setXmlStandalone(true);를 추가하면 개행(줄바꿈)이 안 되므로 추가한 코드
			
			// XML 문서 만들기
			File dir = new File("C:" + File.separator + "storage");
			if(dir.exists() == false) {
				dir.mkdirs();
			}
			File file = new File(dir, "product.xml");
			
			Source source = new DOMSource(document);	// 사용할 document가 무엇이냐 묻는것
			StreamResult streaResult = new StreamResult(file); 		// 결과를 보낼 곳이 어디냐. 저기다.
			transformer.transform(source, streaResult);			// 여기서 사용할 source와 streamResult를 미리 만들었음.
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}

}
