package ex03_insert;

import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Properties;

public class MainClass {

	/* sql에서 insert의 리턴값은 int값이다.
	 1이 반환 = 삽입이 된 것.(1 행이 삽입되었습니다.) 
	 0이 반환 = 삽입이 안 된 것.
	 => 삽입이 됐으면 1이 반환될 것이다.
	 ※ insert의 리턴 타입은 int
	 ps.execute()는 이제 안 쓴다. 
	 ★★★ DML(삽입,수정,삭제)을 처리할 때는 ps.executeUpdate() 메소드 쓴다. ★★★
	 		int가 반환된다. 0이나 1(0 or 1) = 삽입성공(1) or 삽입실패(0)
	 jdbc는 삽입,수정,삭제하면 자동 커밋이 되게끔 되어있다.
	*/
	
	// 지금 하는 게 나중에 하는 것의 원본 코드(String으로 입력해주는..)라고 보면 됨. 여기서 코드가 돌아가면 어디서든 되는 거라 보면 됨.
	
	// 상수 삽입 (거의 안 쓴다. 실무에서 없는 개념이라고 보면 됨.)
	public static void ex01() {
		
		Connection con = null;
		PreparedStatement ps = null;
		
		try {
			
			Class.forName("oracle.jdbc.OracleDriver");
			
			Properties p = new Properties();
			p.load(new BufferedReader(new FileReader("db.properties")));
			
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			
			con = DriverManager.getConnection(url, p);	// 프로퍼티 파일의 요소를 따로 빼지 않고 프로퍼티 객체를 그대로 던져주는 방법. 그러나 url주소는 따로 적어줘야 한다(String url)
			// con.setAutoCommit(false);  // 자동커밋 꺼주는 방법. 트랜잭션 처리를 위해 이렇게 할 수도 있다.
			// 트랜잭션 처리 : insert, update, delete가 2개 이상일 때 필요함. 2개 이상 하고 마지막에 커밋을 넣어 줘야 한다. (몰라도 되긴 함)
			String sql = "INSERT INTO MEMBER_TBL(MEMBER_NO, ID, NAME, ADDRESS, JOIN_DATE)";
			sql += " VALUES(MEMBER_SEQ.NEXTVAL, 'admin', '관리자', '서울', TO_DATE('2023-02-15', 'YYYY-MM-DD'))";
			
			ps = con.prepareStatement(sql);
			
			// 삽입 결과
			int insResult = ps.executeUpdate();	   // 반환타입이 int이다.
			
			System.out.println(insResult + "개의 행이 삽입되었습니다.");
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			
			try {
				if(ps != null) ps.close();
				if(con != null) con.close();	// 나중에 만든 것을 먼저 닫고 먼저 만든 것을 나중에 닫는 게 원칙임.
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
	}
	
	// 변수 삽입 (이게 중요!)
	public static void ex02() {
		
		Connection con = null;
		PreparedStatement ps = null;
		try {
			
			Class.forName("oracle.jdbc.OracleDriver");
			Properties p = new Properties();
			p.load(new BufferedReader(new FileReader("db.properties")));
			
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			con = DriverManager.getConnection(url, p);
			
			String sql = "INSERT INTO MEMBER_TBL(MEMBER_NO, ID, NAME, ADDRESS, JOIN_DATE)";
			sql += " VALUES(MEMBER_SEQ.NEXTVAL, ?, ?, ?, SYSDATE)"; // 변수처리하려면 ?로 하면 된다.
			
			ps = con.prepareStatement(sql);
			
			// id,name,address 변수 만들기
			String id = "master";
			String name = "운영자";
			String address = "경기";
			// 이제 저 ?로 이 변수들을 전달하는 방법
			ps.setString(1, id);		// 1번째 물음표(?) 자리에 id를 넣으시오.
			ps.setString(2, name);		// 2번째 물음표(?) 자리에 name를 넣으시오.
			ps.setString(3, address);	// 3번째 물음표(?) 자리에 address를 넣으시오.
			//※ 앞으로 이 변수 처리법은 항상 똑같을 것이다.(insert,update,delete에서 변수처리할 때 똑같은 형식으로..)
			int insResult = ps.executeUpdate();
			
			System.out.println(insResult + "개의 행이 삽입되었습니다.");
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(ps != null) ps.close();
				if(con != null) con.close();
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		
	}
	
	
	public static void ex03() {
	// admin이 작성한 임의의 게시글을 삽입해 보자
		Connection con = null;
		PreparedStatement ps = null;
		try {
			
			Class.forName("oracle.jdbc.OracleDriver");
			Properties p = new Properties();
			p.load(new BufferedReader(new FileReader("db.properties")));
			
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			
			con = DriverManager.getConnection(url, p);
		
			String sql = "INSERT INTO BOARD_TBL(BOARD_NO, MEMBER_NO, TITLE, CONTENT, CREATE_DATE)";
			sql += " VALUES(BOARD_SEQ.NEXTVAL, ?, ?, ?, SYSDATE)";
			
			ps = con.prepareStatement(sql);
			
			int memberNo = 1;
			String title = "board tttitle";
			String content = "hello";
			
			ps.setInt(1, memberNo);
			ps.setString(2, title);
			ps.setString(3, content);
			
			int insResult = ps.executeUpdate();
			
			System.out.println(insResult + "개의 행이 삽입되었습니다.");
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(ps != null) ps.close();
				if(con != null) con.close();
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		
	}
	
	
	public static void main(String[] args) {
		ex03();
	}

}
