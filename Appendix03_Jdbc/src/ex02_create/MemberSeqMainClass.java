package ex02_create;

import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Properties;

public class MemberSeqMainClass {

	public static void main(String[] args) {

		Connection con = null;
		PreparedStatement ps = null;
		
		try {
			
			Class.forName("oracle.jdbc.OracleDriver");  // 컴퓨터를 껐을 때는 다시 해줘야 하는데 지금은 미리 앞에 써서 안 써줘도 괜찮긴 함
			
			Properties p = new Properties();
			p.load(new BufferedReader(new FileReader("db.properties")));
			
			String url = p.getProperty("url");
			String user = p.getProperty("user");
			String password = p.getProperty("password");
			
			con = DriverManager.getConnection(url, user, password);
			
			String sql = "CREATE SEQUENCE MEMBER_SEQ NOCACHE";
			
			ps = con.prepareStatement(sql);
			// 성공과 실패를 나눠서 보려면 if 써주면 됨
			ps.execute(); // 약간의 오류가 나든 그냥 넘어감.. 그냥 자바로 쿼리문 적는거 연습하는거임..
						  // 시퀀스는 어차피 sql에서 적을 예정.
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			
			try {
				if(ps != null) ps.close();
				if(con != null) con.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}
		
	}

}
