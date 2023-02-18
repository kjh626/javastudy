package dao;

import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;

public class ContactDAO {

	/***** 1. singleton *****/
	private static ContactDAO dao = new ContactDAO();
	private ContactDAO() { }
	public static ContactDAO getInstance() {
		return dao;
	}
	
	/***** 2. field *****/
	private Connection con;
	private PreparedStatement ps;
	private ResultSet rs;
	private String sql;
	private int res;
	
	/***** 3. method *****/
	
	// 공통 메소드 - 1 (Connection 얻기)
	private Connection getConnection() {
		
		Connection con = null;
		
		try {
			
			Class.forName("oralce.jdbd.OracleDriver");
			
			Properties p = new Properties();
			p.load(new BufferedReader(new FileReader("db.properties")));
			
			con = DriverManager.getConnection(p.getProperty("url"), p);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return con;
	}
	
	// 공통 메소드 - 2 (사용한 자원 반납)
	private void close() {
		
		try {
			if(rs != null) rs.close();
			if(ps != null) ps.close();
			if(con != null) con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
