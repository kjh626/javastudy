package ex01_internet;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class MainClass {

	/*
		URL
		1. Uniform Resource Locator
		2. 정형화된 자원의 경로
		3. 실제로는 웹 주소를 의미한다.
		4. 구성
			프로토콜://     호스트     / 서버경로   ?파라미터=값&파라미터=값&파라미터=갑...  / 																%EC%82%BC%EC%84%B1%EC%A0%84%EC%9E%90 이게 "삼성전자" 의 인코딩된 데이터.
			   https://search.naver.com/search.naver?where=nexearch&sm=top_sug.pre&fbm=0&acr=1&acq=%EC%82%BC%EC%84%B1%EC%A0%84%EC%9E%90&qdt=0&ie=utf8&query=삼성전자
			1) 프로토콜 : 통신규약, https(secure + http : 보안 처리된 하이퍼텍스트 전송 프로토콜)
			2) 호스트   : 서버의 대표 주소  (돈 주고 사서 바꿀 수 있음) / 그냥 서버라고 생각해도 됨.
			3) 서버경로 : URL Mapping(URL Pattern) -> 개발자가 만든 것임.(우리가 만드는..), 우리가 계속해서 연습할 내용임
			4) 파라미터 : 서버로 보내는 데이터를 의미(변수라고 생각하면 된다.) => ? 는 주소에 1개밖에 못 온다. ? 다음에 파라미터가 나옴. (? 2개 오면 잘못된 주소임.)
	*/
	// URL을 분석해내는 클래스 : URL 클래스
	
	public static void ex01() {
		
		String apiURL = "https://search.naver.com/search.naver?query=삼성전자";	// query만 남기고 지웠음.
		URL url = null;
		// URL 사용하려면 필수로 예외처리가 필요
		
		try {
			
			url = new URL(apiURL);    // 반드시 예외 처리가 필요한 코드(try안에 넣어라)
			
			System.out.println("프로토콜 : " + url.getProtocol());
			System.out.println("호스트   : " + url.getHost());
			System.out.println("파라미터 : " + url.getQuery());   // 파라미터를 불러오는 것(자바에서는 쿼리라고 한다. 파라미터라고 외워라)
			
		} catch (MalformedURLException e) {
			System.out.println("apiURL 주소 오류");
		}
		
	}
	
	// File 경로 적는 것과 비슷, URL (https:// ~~ ) 경로로 바뀐 것뿐이라고 생각해라.
	// 접속한 다음에 데이터 통로를 뚫어야 한다. Stream이 필요하다.(데이터 주고 받는, input outputStream)
	// 주로 서버측에서 데이터를 받아오는 것을 많이 쓰게 될 것이다. (InputStream)
	// 받아오는 데이터 대부분 2가지 형식 : 1.XML , 2.JSON (서버측은 2가지형식으로 데이터를 제공. 우리의 선택은 JSON)
	// 이 과정이 공공데이터API를 활용하는 것과 비슷하다. (미세먼지 알고싶다. 버스 어디에 있나 알고싶다(GPS) 등등)
	
	public static void ex02() {
		
		// 웹 접속을 담당하는 HttpURLConnection
		
		String apiURL = "https://www.naver.com";
		URL url = null;
		HttpURLConnection con = null;	// 선언만
		
		try {
			// 항상 기초로 들어가는 2가지
			url = new URL(apiURL);			// MalfomredURLException 처리가 필요하다.
			con = (HttpURLConnection)url.openConnection();  // 타입에 문제가 있어서 (HttpURLConnection) 해줘야함. 또, IOException 처리가 필요하다.
			
			/*  HTTP 응답 코드 공부하기 (HTTP 응답 코드 : 접속이 잘 됐는지 안 됐는지 여부 확인)
				1. 200 : 정상
				2. 40X(400번대) : 잘못된 요청(사용자가 잘못하였음). ex) 404 를 제일 많이 봤을 것(잘못된 주소)
				3. 50X : 서버측 오류(서버가 잘못하였음). 우리가 자바코드를 잘못 짰을 때의 경우(수업하면서 만들면서 많이 봄)
			*/
			System.out.println("정상 응답 : " + HttpURLConnection.HTTP_OK); 		  // 코드에서 그냥 200(정상 응답)이라고 적어주기도 함.
			System.out.println("Not Found : " + HttpURLConnection.HTTP_NOT_FOUND);    // 값을 그냥 외워서 써도 된다.
			System.out.println("Internal Error : " + HttpURLConnection.HTTP_INTERNAL_ERROR);
			
			// apiURL 접속 확인
			int responseCode = con.getResponseCode();
			if(responseCode == 200) {
				System.out.println(apiURL + " 접속 완료");
			}
			
			// 요청 방식(요청 메소드)
			String requestMethod = con.getRequestMethod();
			System.out.println("요청 방식 : " + requestMethod);		// GET => 데이터의 요청을 주소창으로 할게.. 
			
			// 컨텐트 타입 -> 우리가 손으로 쓰는 것이다.
			String contentType = con.getContentType();				// 웹 상으로 주고받는 데이터의 타입( 자바에서의 int, double 같은
			System.out.println("컨텐트 타입 : " + contentType);    	// 네이버 -> 웹문서를 보여준다. (text/html, image/png, applicatino/json ... ). 정해진 타입이 있다.
			
			// 요청 헤더 (크롬으로 접속했네?, 엣지로 접속했네?. 지금은 자바로 접속함 뭘 가지고 접속했는지 요청 헤더에 남는다.)
			String userAgent = con.getRequestProperty("User-Agent");   	// 이 정보로 뭘 알 수 있을까? => 넌 사람이 아니네..? 프로그램이네? / 매크로 잡을 수 있다.
			System.out.println("User-Agent : " + userAgent);
			
			String referer = con.getRequestProperty("Referer");
			System.out.println("Referer : " + referer);   // 이전 주소가 나옴.(새주소 말고 요청 전의 주소) => 로그인하면 직전 페이지가 열린다. / 로그인했는데 첫페이지 돌아가는 사이트도 있다.(짜증난다. 질이 떨어진다)
			// 네이버는 리퍼러값 사용하진 않은 거 같고 네가 돌아갈 곳은 ~~~구나 하고 직접 파라미터를 넘겨주는 방식으로 처리함.(네이버의 방식)
			
		} catch(MalformedURLException e) {
			System.out.println("apiURL 주소 오류");
		} catch(IOException e) {
			System.out.println("apiURL 접속 오류");
		}
	}
	
	public static void main(String[] args) {
		ex02();
	}

}
