package ex02_create;

import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Properties;

public class MemberTableMainClass {

	public static void main(String[] args) {
		// 모든 DB작업의 시작은 커넥션 (그래서 모든DB가 jar가 필요.. 자르파일뿐만아니라 인터넷으로도 제공해줌)
		
		/*1. Connection 생성 */               /* 2. 쿼리문 작성 및 실행 */            /* 3. 사용한 자원 반납하기 */
		// => Jdbc는 쿼리를 하나만 작성할 수 있다. 1,2,3 과정 해야한다. 쿼리문 하나 더 작성하려면 -> 다른 클래스에서 1,2,3 과정

		Connection con = null;
		
		try {
			
			// 오라클 드라이버 로드
			Class.forName("oracle.jdbc.OracleDriver");  // 오타를 내거나 빌드패스를 안 잡았을 때 ClassNotFoundException 예외가 나올 수 있다.
			
			// 프로퍼티 파일 읽어서 프로퍼티 객체 생성
			Properties p = new Properties();
			p.load(new BufferedReader(new FileReader("db.properties")));
			
			// 프로퍼티 객체에 저장된 각 프로퍼티(속성) 가져오기
			String url = p.getProperty("url");	// 프로퍼티의 이름은 정해져 있지 않다. 우리가 정해주면 된다. url, user -> a,b,c로 해도 된다. 나중에는 프로퍼티 이름이 정해져 있다.
			String user = p.getProperty("user"); 
			String password = p.getProperty("password");
			
			// Connection 생성 (커넥션은 오라클 드라이버 관리자가 만들어준다.)
			con = DriverManager.getConnection(url, user, password);
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		
		/* 2. 쿼리문 작성 및 실행 */
		
		/*
			PreparedStatement 인터페이스 
			1. Prepared  : 미리 준비하시오.
			2. Statement : 쿼리문
			3. 작성된 쿼리문을 전달하면 해당 쿼리문을 실행해 주는 역할을 수행한다.
			4. Statement 인터페이스는 보안 문제로 사용하지 않는 것이 좋다.
		*/
		
		// 주의! Jdbc에서는 쿼리문의 마지막에 세미콜론(;)을 붙이지 않는다.
		
		StringBuilder sb = new StringBuilder();   // 쿼리문 길 것 같아서 스트링 빌더
		sb.append("CREATE TABLE MEMBER_TBL (");
		sb.append("MEMBER_NO NUMBER NOT NULL");
		sb.append(", ID VARCHAR2(30 BYTE) NOT NULL UNIQUE");
		sb.append(", NAME VARCHAR2(30 BYTE) NOT NULL");
		sb.append(", ADDRESS VARCHAR2(30 BYTE)");
		sb.append(", JOIN_DATE DATE NOT NULL");
		sb.append(", CONSTRAINT PK_MEMBER PRIMARY KEY(MEMBER_NO))");
		
		String sql = sb.toString();
		// ↑ 쿼리문을 미리 준비함 ↑
		
		PreparedStatement ps = null;    // 이거도 사용하려면 예외처리가 필요(try-catch)
		
		try {
			
			// PreparedStatement 객체 생성
			ps = con.prepareStatement(sql);
			
			// 쿼리문 실행하기
			ps.execute();
			System.out.println("쿼리문이 실행되었습니다.");
		} catch(Exception e) {	// 정확하게는 SQLException이 발생할 수 있음
			e.printStackTrace();
		}
		
		/* 3. 사용한 자원 반납하기 */
		
		try {
			
			if(ps != null) ps.close();
			if(con != null) con.close();
		
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}

}
