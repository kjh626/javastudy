package api;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONObject;


public class ApiMain {

	public static void main(String[] args) {
	
		String serviceKey = "/crf+XWfbPub+yJFATeJmDpsQiWP4ffIHn3Fa2CFRpEwxkb+iSoDidUPYuNuoiVX7msyy1xzyz/yQ0dUbGZx6w==";
		String apiURL = "http://apis.data.go.kr/B552061/AccidentDeath/getRestTrafficAccidentDeath";
		
		URL url = null;
		HttpURLConnection con = null;
		BufferedReader reader = null;
		BufferedWriter writer = null;
		
		try {
			
			StringBuilder sbURL = new StringBuilder();
			sbURL.append(apiURL);
			sbURL.append("?ServiceKey=" + URLEncoder.encode(serviceKey, "UTF-8"));
			sbURL.append("&searchYear=2021");
			sbURL.append("&siDo=1100");
			sbURL.append("&guGun=1125");
			sbURL.append("&type=json");
			sbURL.append("&numOfRows=10");
			sbURL.append("&pageNo=1");
			
			
			url = new URL(sbURL.toString());
			con = (HttpURLConnection) url.openConnection();
			
			con.setRequestMethod("GET");
			con.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
			
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
			
			reader.close();
			con.disconnect();
			
			File file = new File("accident.txt");
			writer = new BufferedWriter(new FileWriter(file));
			
			JSONObject obj = new JSONObject(sb.toString());
			JSONArray item = obj.getJSONObject("items").getJSONArray("item");
			String[] day = {"", "일요일", "월요일", "화요일", "수요일", "목요일", "금요일" ,"토요일"};
			
			List<Map<String, Object>> acciList = new ArrayList<Map<String,Object>>();
		
			for(int i = 0; i < item.length(); i++) {
				JSONObject itemAcci = item.getJSONObject(i);
				
				Accident acci = new Accident();
				acciList.add(itemAcci.toMap());

				acci.setOccrrncDt(itemAcci.getString("occrrnc_dt"));
				acci.setOccrrncDayCd(itemAcci.getString("occrrnc_day_cd"));
				acci.setDthDnvCnt(itemAcci.getInt("dth_dnv_cnt"));
				acci.setInjpsnCnt(itemAcci.getInt("injpsn_cnt"));
				
				int dayInt = Integer.parseInt(acci.getOccrrncDayCd());
				StringBuilder strb = new StringBuilder();
				strb.append("발생일자 " + acci.getOccrrncDt());
				strb.append(" " + day[dayInt]);
				strb.append(", 사망자수 " + acci.getDthDnvCnt() + "명");
				strb.append(", 부상자수 " + acci.getInjpsnCnt() + "명" + "\n");
				
				writer.write(strb.toString());

			}
			
			writer.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
