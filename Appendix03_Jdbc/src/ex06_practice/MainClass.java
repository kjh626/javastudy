package ex06_practice;

import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;

public class MainClass {

	public static void ex01() {
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			
			Class.forName("oracle.jdbc.OracleDriver");
			Properties p = new Properties();
			p.load(new BufferedReader(new FileReader("db.properties")));
			
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			
			con = DriverManager.getConnection(url, p);
			
			String sql = "SELECT MEMBER_NO, ID, NAME, ADDRESS, JOIN_DATE";
			sql += " FROM MEMBER_TBL";
			sql += " WHERE MEMBER_NO = ?";
			
			ps = con.prepareStatement(sql);
			
			int memberNo = 2;
			
			ps.setInt(1, memberNo);
			
			rs = ps.executeQuery();
			
			Member member = null;
			
			if(rs.next()) {
				
				member = new Member();
				member.setMember_no(rs.getInt("MEMBER_NO"));
				member.setId(rs.getString("ID"));
				member.setName(rs.getString("NAME"));
				member.setAddress(rs.getString("ADDRESS"));
				member.setJoin_date(rs.getDate("JOIN_DATE"));
				
			}
			System.out.println(member);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs != null) rs.close();
				if(ps != null) ps.close();
				if(con != null) con.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
	}
	
	public static void main(String[] args) {
		ex01();
	}

}
