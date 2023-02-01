package ex03_api;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

import org.json.JSONObject;


public class JSONMainClass {

	public static void ex01() {
		// 요청 주소로 함, 데이터 표출 방식은 옵션이지만 반드시 json으로 해줘야 한다.
		String serviceKey = "/crf+XWfbPub+yJFATeJmDpsQiWP4ffIHn3Fa2CFRpEwxkb+iSoDidUPYuNuoiVX7msyy1xzyz/yQ0dUbGZx6w==";
		String apiURL = "http://apis.data.go.kr/B552584/ArpltnInforInqireSvc/getCtprvnRltmMesureDnsty";
						
		URL url = null;
		HttpURLConnection con = null;
		BufferedReader reader = null;
		
		try {
			String sidoName = "서울";
			/* 길어지면 StringBuilder 사용하는 것도 좋다.
				StringBuilder sbURL = new StringBuilder();
				sbURL.append(apiURL)
				sbURL.append("?serviceKey=" + URLEncoder.encode(serviceKey, "UTF-8");
				sbURL.append("&returnType=json");
				sbURL.append("&sidoName=" + URLEncoder.encode(sidoName, "UTF-8"));
				new URL(sbURL.toString());
			*/
			apiURL += "?serviceKey=" + URLEncoder.encode(serviceKey, "UTF-8");
			apiURL += "&returnType=json";
			apiURL += "&sidoName=" + URLEncoder.encode(sidoName, "UTF-8");	// 한글이라서 인코딩해줘야 함 !!!
			
			url = new URL(apiURL);
			con = (HttpURLConnection) url.openConnection();
			
			con.setRequestMethod("GET");
			con.setRequestProperty("Content-Type", "application/xml; chrset=UTF-8");
			
			int responseCode = con.getResponseCode();
			if(responseCode == 200) {
				reader = new BufferedReader(new InputStreamReader(con.getInputStream()));
			} else {
				reader = new BufferedReader(new InputStreamReader(con.getErrorStream()));
			}

			StringBuilder sb = new StringBuilder();
			String line = null;
			while((line = reader.readLine()) != null) {
				sb.append(line);
			}
			
			reader.close();
			con.disconnect();
			
			System.out.println(sb.toString());
			JSONObject obj = new JSONObject(sb.toString());
			// value값을 가져오기 위해서 어떻게 해야할까?  // 하나씩 쭈욱 벗겨서 봤다.- {"response":{"body":{"totalCount":40,"items":[{" ... 
			// 방법은 2가지 => (JSONObject)obj.get("response") / obj.getJSONObject("response")
			JSONObject body = obj.getJSONObject("response").getJSONObject("body"); 		// obj3 == body 메소드 체이닝
		
			// 주소 + 파라미터 + 방식(GET인지) => 입력하면 응답(결과) 미리 알려주는 소프트웨어 많다. 우리는 Postman이라는 프로그램 쓸 거임. ==> 우리가 파싱하기가 편해진다. 
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public static void main(String[] args) {
		ex01();
	}

}
