package ex01_practice;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLDecoder;
import java.net.URLEncoder;

public class MainClass {
	
	public static void ex01() {
		
		String apiURL = "https://search.naver.com/search.naver?query=삼성전자";
		URL url = null;
		
		try {
			url = new URL(apiURL);
			
			System.out.println("프로토콜 : " + url.getProtocol());
			System.out.println("호스트   : " + url.getHost());
			System.out.println("파라미터 : " + url.getQuery());
			
		} catch(MalformedURLException e) {
			System.out.println("apiURL 주소 오류");
		}
	}
	
	public static void ex02() {
		
		String apiURL = "https://www.naver.com";
		URL url = null;
		HttpURLConnection con = null;
		
		try {
			
			url = new URL(apiURL);
			con = (HttpURLConnection)url.openConnection();
			
			System.out.println("정상 응답 : " + HttpURLConnection.HTTP_OK);
			System.out.println("Not Foud : " + HttpURLConnection.HTTP_NOT_FOUND);
			System.out.println("Internal Error : " + HttpURLConnection.HTTP_INTERNAL_ERROR);
			
			// apiURL 접속 확인
			int reponseCode = con.getResponseCode();
			if(reponseCode == 200) {
				System.out.println(apiURL + " 접속 완료");
			}
			
			// 요청 방식(요청 메소드)
			String requestMethod = con.getRequestMethod();
			System.out.println("요청 방식 : " + requestMethod);
			
			// 컨텐트 타입
			String contentType = con.getContentType();
			System.out.println("컨텐트 타입 : " + contentType);
			
			// 요청 헤더
			String userAgent = con.getRequestProperty("User-Agent");
			System.out.println("User-Agent : " + userAgent);
			
			// 리퍼러
			String referer = con.getRequestProperty("Referer");
			System.out.println("Referer : " + referer);
			
			// 접속 종료
			con.disconnect();
			
		} catch(MalformedURLException e) {
			System.out.println("apiURL 주소 오류");
		} catch(IOException e) {
			System.out.println("apiURL 접속 오류");
		}
		
	}
	
	public static void ex03() {
		// Buffered 넣어서 하는 버전 
		// ※ import 정리해주는 단축키 Ctrl + Shift + O
		
		String apiURL = "https://img1.daumcdn.net/thumb/C408x596/?fname=https%3A%2F%2Ft1.daumcdn.net%2Fmovie%2F02ef8515570b2950e9f24d663cae807e7f40b5f2";
		URL url = null;
		HttpURLConnection con = null;
		
		BufferedInputStream in = null;
		BufferedOutputStream out = null;
		
		// 코드가 길어져서 File 넣어줌
		File file = new File("C:" + File.separator + "pracstorage", "witch.png");
		
		try {
			
			url = new URL(apiURL);
			con = (HttpURLConnection)url.openConnection();
			
			int responseCode = con.getResponseCode();
			if(responseCode == HttpURLConnection.HTTP_OK) {
				
				in = new BufferedInputStream(con.getInputStream());
				out = new BufferedOutputStream(new FileOutputStream(file));
				
				byte[] b = new byte[10];
				int readByte = 0;
				
				while((readByte = in.read(b)) != -1) {
					out.write(b, 0, readByte);
				}
				
				System.out.println("다운 완료");
				
				out.close();
				in.close();
				con.disconnect();
				
			}
			
		} catch(MalformedURLException e) {
			System.out.println("apiURL 주소 오류");
		} catch(IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public static void ex04() {
		// Buffered 사용해서 해보기
		// BufferedReader 썼기 때문에 readLine()가능함
		String apiURL = "https://gdlms.cafe24.com/uflist/curri/10004/bbs/68_63d8848f7d506.txt";
		URL url = null;
		HttpURLConnection con = null;
		
		BufferedReader reader = null;
		BufferedWriter writer = null;
		
		File file = new File("C:" + File.separator + "pracstorage", "연습다운로드문서.txt");
		
		try {
			
			url = new URL(apiURL);
			con = (HttpURLConnection) url.openConnection();
			
			int responseCode = con.getResponseCode();
			if(responseCode == HttpURLConnection.HTTP_OK) {
				reader = new BufferedReader(new InputStreamReader(con.getInputStream()));
			} else {
				reader = new BufferedReader(new InputStreamReader(con.getErrorStream()));
			}
			StringBuilder sb = new StringBuilder();
			String line = null;
			
			while((line = reader.readLine()) != null) {
				sb.append(line + "\n");
			}
			
			writer = new BufferedWriter(new FileWriter(file));
			writer.write(sb.toString());
			
			writer.close();
			reader.close();
			con.disconnect();
			
			System.out.println("다운 완료");
		} catch(MalformedURLException e) {
			System.out.println("apiURL 주소 오류");
		} catch(IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public static void ex05() {
		
		String data = "한글 english 12345 !@#$+-";
		
		try {
			
			// 인코딩
			String encodeData = URLEncoder.encode(data, "UTF-8");
			System.out.println(encodeData);
			
			// 디코딩
			String decodeData = URLDecoder.decode(data, "UTF-8");
			System.out.println(decodeData);
			
		} catch(UnsupportedEncodingException e) {
			System.out.println("인코딩 실패");
		}
		
	}
	
	public static void ex06() {
		
		String apiURL = "http://www.kma.go.kr/XML/weather/sfc_web_map.xml";
		URL url = null;
		HttpURLConnection con = null;
		
		InputStreamReader reader = null;
		FileWriter writer = null;
		
		File file = new File("C:" + File.separator + "pracstorage", "sfc_web_map.xml");
		
		try {
			
			url = new URL(apiURL);
			con = (HttpURLConnection) url.openConnection();
			
			int responseCode = con.getResponseCode();
			if(responseCode == HttpURLConnection.HTTP_OK) {
				reader = new InputStreamReader(con.getInputStream());
			} else {
				reader = new InputStreamReader(con.getErrorStream());
			}
			
			char[] c = new char[3];
			StringBuilder sb = new StringBuilder();
			int readCount = 0;
			while((readCount = reader.read(c)) != -1) {
				sb.append(c, 0, readCount);
			}
			
			writer = new FileWriter(file);
			writer.write(sb.toString());
			
			reader.close();
			writer.close();
			con.disconnect();
			
			
			System.out.println("다운로드 완료");
			
		} catch(MalformedURLException e) {
			System.out.println("apiURL 주소 오류");
		} catch(IOException e) {
			e.printStackTrace();
		}
		
		
	}
	
	
	public static void main(String[] args) {
		ex05();
	}

}
