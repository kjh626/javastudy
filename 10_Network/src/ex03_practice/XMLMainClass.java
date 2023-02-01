package ex03_practice;

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
		
		String apiURL = "http://openapi.airport.co.kr/service/rest/AirportCodeList/getAirportCodeList";
		String serviceKey = "/crf+XWfbPub+yJFATeJmDpsQiWP4ffIHn3Fa2CFRpEwxkb+iSoDidUPYuNuoiVX7msyy1xzyz/yQ0dUbGZx6w==";
		
		URL url = null;
		HttpURLConnection con = null;
		BufferedReader reader = null;
		BufferedWriter writer = null;
		
		try {
			apiURL += "?serviceKey=" + URLEncoder.encode(serviceKey, "UTF-8");
			url = new URL(apiURL);
			con = (HttpURLConnection) url.openConnection();
			
			con.setRequestMethod("GET");
			con.setRequestProperty("Content-Type", "application/xml; charset=UTF-8");
			
			if(con.getResponseCode() == 200) {
				reader = new BufferedReader(new InputStreamReader(con.getInputStream()));
			} else {
				reader = new BufferedReader(new InputStreamReader(con.getErrorStream()));
			}
			
			char[] cbuf = new char[10];
			StringBuilder sb = new StringBuilder();
			int readCount = 0;
			while((readCount = reader.read(cbuf)) != -1) {
				sb.append(cbuf, 0, readCount);
			}
			System.out.println(sb.toString());
			
			reader.close();
			con.disconnect();
			
			writer = new BufferedWriter(new FileWriter("C:" + File.separator + "pracstorage" + File.separator + "공항코드정보.xml"));
			writer.write(sb.toString());
			writer.close();
			
			System.out.println("파일이 생성되었습니다.");
			
					
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void ex02() {
		
		// 한국공항공사_항공기 운항정보 : 국제선 운항 스케줄
		
		String serviceKey = "/crf+XWfbPub+yJFATeJmDpsQiWP4ffIHn3Fa2CFRpEwxkb+iSoDidUPYuNuoiVX7msyy1xzyz/yQ0dUbGZx6w==";
		String apiURL = "http://openapi.airport.co.kr/service/rest/FlightScheduleList/getDflightScheduleList";
		
	}
	
	
	public static void main(String[] args) {
		ex01();
	}

}
