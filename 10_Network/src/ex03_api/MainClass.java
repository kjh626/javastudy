package ex03_api;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class MainClass {

	public static void ex01() {
		
		/*
			한국공항공사_항공기 운항정보 : 공항 코드 정보
			1. 서비스 URL : http://openapi.airport.co.kr/service/rest/AirportCodeList/getAirportCodeList
			2. 요청변수(Request Parameter)
				1) ServiceKey : 인증키
		*/
		String encodingKey = "%2Fcrf%2BXWfbPub%2ByJFATeJmDpsQiWP4ffIHn3Fa2CFRpEwxkb%2BiSoDidUPYuNuoiVX7msyy1xzyz%2FyQ0dUbGZx6w%3D%3D";
		String apiURL = "http://openapi.airport.co.kr/service/rest/AirportCodeList/getAirportCodeList";
		apiURL += "?ServiceKey=" + encodingKey;
		
		// 보통 아래 걸로 쓰인다. 이걸 공부하고 연습해라
		String decodingKey = "/crf+XWfbPub+yJFATeJmDpsQiWP4ffIHn3Fa2CFRpEwxkb+iSoDidUPYuNuoiVX7msyy1xzyz/yQ0dUbGZx6w==";	// 원본
		String apiURL = "http://openapi.airport.co.kr/service/rest/AirportCodeList/getAirportCodeList";
		try {
			apiURL += "?ServiceKey=" + URLEncoder.encode(decodingKey, "UTF-8");
		} catch(UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
	}
	
	public static void main(String[] args) {
		
		
		
		
	}

}
