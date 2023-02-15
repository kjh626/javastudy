package ex01_connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MainClass {

	public static void ex01() {
		
		// 클래스를 로드하는 방법(메모리에 로드한다 : 사용하겠다)
		try {
			
			Class.forName("oracle.jdbc.OracleDriver"); // oracle.jdbc.driver.OracleDriver도 가능하다.
			System.out.println("클래스가 로드되었습니다.");
			
		} catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		
	}

	public static void ex02() {
		
		// Oracle 접속 정보 . 접속하려면 주소를 알아야 하는데 아직 주소를 모름.
		String url = "jdbc:oracle:thin:@localhost:1521:xe";    // thin의 의미는 가벼운db를 말함.
		// 접속 정보는 언제나 필요하다. 외우는 것도 방법임.
		String user = "GDJ61";
		String password = "1111";	// 비밀번호 썼는데 git에 올릴 거니? 안 된다 안 돼!

		// Oracle DataBase와 연결할 때 사용하는 Connection 인터페이스(임포트 잘 해줘야 한다)
		Connection con = null;   // 선언만 하는 이유 : 예외처리가 필요해서
		
		// DriverManager 클래스로부터 Connection 객체를 받아 온다. 
		try {
			// 소스코드는 gitignore 안 되지만 파일은 이그노어 된다. id와 pw를 *.properties 파일로 옮기고 소스코드에서는 없애는 방식으로 저장해주는 방법 있다.
			con = DriverManager.getConnection(url, user, password);
			System.out.println("DB에 접속되었습니다.");
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
		// 사용이 끝난 Connection 객체는 !반드시! 닫아야 한다.
		try {
			if(con != null)
				con.close();
		} catch(SQLException e) {
			e.printStackTrace();
		}
		// 원래는 ex01,02 같이 해야 하는 것임.
	}
	
	public static void main(String[] args) {
		ex02();
	}

}
