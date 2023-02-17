package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

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
	
}
