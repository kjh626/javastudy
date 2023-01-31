package ex01_practice;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class Infi {

	public static void ex04() {
		
		String apiURL = "https://gdlms.cafe24.com/uflist/curri/10004/bbs/68_63d8848f7d506.txt";

		URL url = null;
		HttpURLConnection con = null;
		
		InputStreamReader reader = null;
		FileWriter writer = null;
		
		try {
			
			url = new URL(apiURL);
			con = (HttpURLConnection) url.openConnection();
			
			int responseCode = con.getResponseCode();
			if(responseCode == HttpURLConnection.HTTP_OK) {
				reader = new InputStreamReader(con.getInputStream());
			} else {
				reader = new InputStreamReader(con.getErrorStream());
			}
			
			char[] cbuf = new char[3];
			int readCount = 0;
			StringBuilder sb = new StringBuilder();
			while((readCount = reader.read(cbuf)) != -1) {
				sb.append(cbuf, 0, readCount);
			}
			
			writer = new FileWriter("C:" + File.separator + "pracstorage" + File.separator + "다운로드4.txt");
			writer.write(sb.toString());
			
			reader.close();
			writer.close();
			con.disconnect();
			
			System.out.println("다운 완료되었음");
			
		} catch (MalformedURLException e) {
			System.out.println("apiURL 주소 오류");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public static void ex04_buffered() {
		
		String apiURL = "https://gdlms.cafe24.com/uflist/curri/10004/bbs/68_63d8848f7d506.txt";

		URL url = null;
		HttpURLConnection con = null;
		
		BufferedReader reader = null;
		BufferedWriter writer = null;
		
		File file = null;
		
		try {
			
			url = new URL(apiURL);
			con = (HttpURLConnection) url.openConnection();
			
			int responseCode = con.getResponseCode();
			if(responseCode == HttpURLConnection.HTTP_OK) {
				reader = new BufferedReader(new InputStreamReader(con.getInputStream()));
				file = new File("C:" + File.separator + "pracstorage", "다운로드5.txt");
			} else {
				reader = new BufferedReader(new InputStreamReader(con.getErrorStream()));
				file = new File("C:" + File.separator + "pracstorage", "다운로드 실패.txt");
			}
			
			String line = null;
			StringBuilder sb = new StringBuilder();
			while((line = reader.readLine()) != null) {
				sb.append(line + "\n");
			}
			
			writer = new BufferedWriter(new FileWriter(file));
			writer.write(sb.toString());
			
			reader.close();
			writer.close();
			con.disconnect();
			
			System.out.println("다운 완료되었음");
			
		} catch (MalformedURLException e) {
			System.out.println("apiURL 주소 오류");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public static void main(String[] args) {
		ex04_buffered();
	}

}
