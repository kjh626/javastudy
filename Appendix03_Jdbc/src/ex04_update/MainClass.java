package ex04_update;

import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Properties;

public class MainClass {

	public static void main(String[] args) {
		// DB에 어떤 데이터가 들어있는 지 모른다고 가정하고 쿼리문 짜보자.
		
		// id가 admin인 회원이 작성한 게시글의 TITLE 앞에 "[NEW]"를 추가하시오.
		Connection con = null;
		PreparedStatement ps = null;
		
		try {
			
			Class.forName("oracle.jdbc.OracleDriver");
			Properties p = new Properties();
			p.load(new BufferedReader(new FileReader("db.properties")));
			
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			
			con = DriverManager.getConnection(url, p);
			
			String sql = "UPDATE BOARD_TBL SET TITLE ='[NEW]' || TITLE";
			sql += " WHERE MEMBER_NO = (SELECT MEMBER_NO FROM MEMBER_TBL WHERE ID = ?)";
			// 서브쿼리의 WHERE절(ID = ?) 단일행 서브쿼리 다중행 서브쿼리 기준은!!
			// 서브쿼리의 WHERE절(ID = ?) 이 PK거나 UNIQUE면 결과가 하나밖에 안 나오기 때문에 단일행 서브쿼리임. 그래서 단일행 연산자 =(등호)를 사용해야 한다.
			ps = con.prepareStatement(sql);
			
			String id = "admin";
			
			ps.setString(1, id);
						
			int updateResult = ps.executeUpdate();
			
			System.out.println(updateResult + "행이 수정되었습니다.");
			
		} catch(Exception e) {
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
