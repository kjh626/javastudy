package ex03_practice;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

import org.json.JSONArray;
import org.json.JSONObject;

public class JSONMainClass {

	public static void ex01() {
		// 대기질(미세먼지/오존) 예보통보 조회
		String serviceKey = "/crf+XWfbPub+yJFATeJmDpsQiWP4ffIHn3Fa2CFRpEwxkb+iSoDidUPYuNuoiVX7msyy1xzyz/yQ0dUbGZx6w==";
		String apiURL = "http://apis.data.go.kr/B552584/ArpltnInforInqireSvc/getMinuDustFrcstDspth";
		
		URL url = null;
		HttpURLConnection con = null;
		BufferedReader reader = null;
		
		try {
			
			StringBuilder sbURL = new StringBuilder();
			sbURL.append(apiURL);
			sbURL.append("?serviceKey=" + URLEncoder.encode(serviceKey, "UTF-8"));
			sbURL.append("&returnType=json"); 
			sbURL.append("&searchDate=2023-01-30");
			
			url = new URL(sbURL.toString());
			con = (HttpURLConnection) url.openConnection(); 
			
			con.setRequestMethod("GET");
			con.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
			
			if(con.getResponseCode() == 200) {
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
			
			System.out.println(sb.toString());
			JSONObject obj = new JSONObject(sb.toString());
			JSONObject response = obj.getJSONObject("response");
			JSONObject body = response.getJSONObject("body");
			JSONArray items = body.getJSONArray("items");
			for(int i = 0; i < items.length(); i++) {
				
				JSONObject item = items.getJSONObject(i);
				String informOverall = item.getString("informOverall");
				
				System.out.println(informOverall);
				
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public static void ex02() {
		// 통합대기환경지수 나쁨 이상 측정소 목록조회
		
		String serviceKey = "/crf+XWfbPub+yJFATeJmDpsQiWP4ffIHn3Fa2CFRpEwxkb+iSoDidUPYuNuoiVX7msyy1xzyz/yQ0dUbGZx6w==";
		String apiURL = "http://apis.data.go.kr/B552584/ArpltnInforInqireSvc/getUnityAirEnvrnIdexSnstiveAboveMsrstnList";
		
		URL url = null;
		HttpURLConnection con = null;
		BufferedReader reader = null;
		
		try {
			
			StringBuilder sbURL = new StringBuilder();
			sbURL.append(apiURL);
			sbURL.append("?serviceKey=" + URLEncoder.encode(serviceKey, "UTF-8"));
			sbURL.append("&returnType=json");
			//sbURL.append("&searchDate=2023-01-30");
			
			url = new URL(sbURL.toString());
			con = (HttpURLConnection) url.openConnection();
			
			con.setRequestMethod("GET");
			con.setRequestProperty("Content-Type", "application/json; charset = UTF-8");
			
			if(con.getResponseCode() == HttpURLConnection.HTTP_OK) {
				reader = new BufferedReader(new InputStreamReader(con.getInputStream()));
			} else {
				reader = new BufferedReader(new InputStreamReader(con.getErrorStream()));
			}
			
			String line = null;
			StringBuilder sb = new StringBuilder();
			while((line = reader.readLine()) != null) {
				sb.append(line);
			}
			
			con.disconnect();
			reader.close();
			
			System.out.println(sb.toString());
			
			JSONArray items = new JSONObject(sb.toString())
								.getJSONObject("response")
								.getJSONObject("body")
								.getJSONArray("items");
			
			for(int i = 0; i < items.length(); i++) {
				JSONObject item = items.getJSONObject(i);
				System.out.println("주소 : " + item.getString("addr") + " (측정소명 : " + item.getString("stationName") + ")");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	
	public static void main(String[] args) {
		ex02();
	}

}
