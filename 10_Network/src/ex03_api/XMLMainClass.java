package ex03_api;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

public class XMLMainClass {

	public static void ex01() {
		
		/*
			한국공항공사_항공기 운항정보 : 공항 코드 정보
			1. 서비스 URL : http://openapi.airport.co.kr/service/rest/AirportCodeList/getAirportCodeList
			2. 요청변수(Request Parameter)
				1) ServiceKey : 인증키
		*/
		
		// 보통 아래 걸로 쓰인다. 이걸 공부하고 연습해라
		String serviceKey = "/crf+XWfbPub+yJFATeJmDpsQiWP4ffIHn3Fa2CFRpEwxkb+iSoDidUPYuNuoiVX7msyy1xzyz/yQ0dUbGZx6w==";	// 원본
		String apiURL = "http://openapi.airport.co.kr/service/rest/AirportCodeList/getAirportCodeList";
		URL url = null;
		HttpURLConnection con = null;
		BufferedReader reader = null;
		BufferedWriter writer = null;
		
		try {
			apiURL += "?serviceKey=" + URLEncoder.encode(serviceKey, "UTF-8");
			url = new URL(apiURL);
			con = (HttpURLConnection) url.openConnection();
			
			// 주소창에 요청 데이터 적는 타입은 GET 타입이다.
			// 반드시 대문자로 적어줘야 한다. 조심!
			con.setRequestMethod("GET");
			con.setRequestProperty("Content-Type", "application/xml; charset=UTF-8");    // 우리가 내려받을 타입..XML의 컨텐트 타입을 지정하는 방법. 세미콜론을 붙여주면 한글 처리 가능
			
			int responseCode = con.getResponseCode();
			if(responseCode == 200) {	// HttpURLConnection.HTTP_OK 이 200을 의미한다.
				reader = new BufferedReader(new InputStreamReader(con.getInputStream()));
			} else {
				reader = new BufferedReader(new InputStreamReader(con.getErrorStream()));
			}
			
			// 읽어오는 메소드 3개 배움. read(), read(char[] cbuf), readLine()
			String line = null;
			StringBuilder sb = new StringBuilder();
			while((line = reader.readLine()) != null) {
				sb.append(line); 
			}
			
			reader.close();
			con.disconnect();
			
			// 파일만들어서 보내기
			File file = new File("C:" + File.separator + "storage", "공항코드정보.xml");
			writer = new BufferedWriter(new FileWriter(file));
			writer.write(sb.toString());
			writer.close();
			
			System.out.println("공항코드정보.xml 이 생성되었습니다.");
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public static void ex02() {
		
		/*
			한국공항공사_항공기 운항정보 : 국제선 운항 스케줄
			1. 서비스 URL : http://openapi.airport.co.kr/service/rest/FlightScheduleList/getIflightScheduleList
			2. 요청변수(Request Parameter)
				1) ServiceKey : 인증키
				2) pageNo : 조회할 페이지번호
				3) schDate : 검색일자
				4) schdeptCityCode : 출발도시 코드
				5) schArrvCityCode : 도착도시 코드
		*/
		
		String serviceKey = "/crf+XWfbPub+yJFATeJmDpsQiWP4ffIHn3Fa2CFRpEwxkb+iSoDidUPYuNuoiVX7msyy1xzyz/yQ0dUbGZx6w==";	// 원본
		String apiURL = "http://openapi.airport.co.kr/service/rest/FlightScheduleList/getIflightScheduleList";
		
		URL url = null;
		HttpURLConnection con = null;
		BufferedReader reader = null;
		BufferedWriter writer = null;
		
		try {
			apiURL += "?serviceKey=" + URLEncoder.encode(serviceKey, "UTF-8");
			apiURL += "&pageNo=1";    // "&"를 기억해라. 서비스키처럼 인코딩이 필요할 수도 있다.
			apiURL += "&schDate=20230201";
			apiURL += "&schdeptCityCode=ICN";
			apiURL += "&schArrvCityCode=JFK";
			
			url = new URL(apiURL);
			con = (HttpURLConnection) url.openConnection();
			
			con.setRequestMethod("GET");
			con.setRequestProperty("Content-Type", "application/xml; charset=UTF-8");    // 우리가 내려받을 타입..XML의 컨텐트 타입을 지정하는 방법. 세미콜론을 붙여주면 한글 처리 가능
			
			int responseCode = con.getResponseCode();
			if(responseCode == 200) {	// HttpURLConnection.HTTP_OK 이 200을 의미한다.
				reader = new BufferedReader(new InputStreamReader(con.getInputStream()));
			} else {
				reader = new BufferedReader(new InputStreamReader(con.getErrorStream()));
			}
			
			String line = null;
			StringBuilder sb = new StringBuilder();
			while((line = reader.readLine()) != null) {
				sb.append(line); 
			}
			
			reader.close();
			con.disconnect();
			
			File file = new File("C:" + File.separator + "pracstorage", "국제선운항스케줄.xml");
			writer = new BufferedWriter(new FileWriter(file));
			writer.write(sb.toString());
			writer.close();
			
			System.out.println("국제선운항스케줄.xml이 생성되었습니다.");
			// xml 파싱은 생략. 덜 중요
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public static void main(String[] args) {
		ex02();
	}

}
