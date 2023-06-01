package search;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import org.json.JSONArray;
import org.json.JSONObject;

public class ApiSearchBook {

	public static void main(String[] args) throws Exception {
		
		try {
			String clientId = "SNxZ6DGf354PLLcGPlnu";
			String clientSecret = "Lp2f019JKT";
			
			Scanner sc = new Scanner(System.in);
			System.out.print("검색어를 입력하세요 >>> ");
			String query = sc.nextLine();
			
			String apiURL = "https://openapi.naver.com/v1/search/book.json?query=" + URLEncoder.encode(query, "UTF-8");
			URL url = new URL(apiURL);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			
			conn.setRequestMethod("GET");
			conn.setRequestProperty("X-Naver-Client-Id", clientId);
			conn.setRequestProperty("X-Naver-Client-Secret", clientSecret);
			
			BufferedReader br = null;
			if(conn.getResponseCode() == 200) {
				br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			} else {
				br = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
			}
			
			StringBuilder sb = new StringBuilder();
			String line = null;
			while((line = br.readLine()) != null) {
				sb.append(line);
			}
			
			br.close();
			conn.disconnect();
			
			File dir = new File("C:" + File.separator + "download");
			File file = new File(dir, query + ".html");
			if(dir.exists() == false) {
				dir.mkdirs();
			}
			
			BufferedWriter bw = null;
			bw = new BufferedWriter(new FileWriter(file));
	
			JSONObject obj = new JSONObject(sb.toString());
			JSONArray items = obj.getJSONArray("items");
			for(int i = 0; i < items.length(); i++) {
				JSONObject item = items.getJSONObject(i);
				String title = item.getString("title");
				String link = item.getString("link");
				String image = item.getString("image");
				if(title.contains(query)) {
					title = title.replace(query, "<strong>" + query + "</strong>");
				}
				String html = "<div><a href='" + link + "'>" + title + "</a>";
				html += "<div><img src='" + image + "' width='100px'></div>";
				html += "<hr>";
				bw.write(html);
			}
			bw.close();
			
		} catch(Exception e) {
			
			File dir = new File("C:" + File.separator + "download" + File.separator + "log");
			File file = new File(dir, "error_log.txt");
			if(dir.exists() == false) {
				dir.mkdirs();
			}
			
			BufferedWriter bw = null;
			bw = new BufferedWriter(new FileWriter(file));
			bw.write("예외메시지\t" + e.getMessage() + "\n" + "예외발생시간\t" + DateTimeFormatter.ofPattern("yyyy-MM-dd a hh:mm:ss").format(LocalDateTime.now()));
			bw.close();
			
		}
	}
	

}
