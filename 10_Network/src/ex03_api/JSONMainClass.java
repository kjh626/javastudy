package ex03_api;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;


public class JSONMainClass {

	public static void ex01() {
		// 요청 주소로 함, 데이터 표출 방식은 옵션이지만 반드시 json으로 해줘야 한다.
		String serviceKey = "/crf+XWfbPub+yJFATeJmDpsQiWP4ffIHn3Fa2CFRpEwxkb+iSoDidUPYuNuoiVX7msyy1xzyz/yQ0dUbGZx6w==";
		String apiURL = "http://apis.data.go.kr/B552584/ArpltnInforInqireSvc/getCtprvnRltmMesureDnsty";
		URL url = null;
		HttpURLConnection con = null;
		BufferedReader reader = null;
		BufferedWriter writer = null;
		
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
			
			File file = new File("C:" + File.separator + "storage", "시도별 실시간 측정정보 조회.json");
			writer = new BufferedWriter(new FileWriter(file));
			writer.write(sb.toString());
			writer.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public static void main(String[] args) {
		ex01();
	}

}
