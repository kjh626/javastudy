package dao;

import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import dto.ContactDTO;

/* ★오늘의 핵심★
	DAO ( 어제 배운 jdbc코드는 전부 여기에 모여서 들어갈 것임 )
	1. Database Access Object
	2. Database에 접근해서 쿼리문을 실행하고 쿼리문의 실행 결과를 받아온다.
	3. 여러 객체가 만들어 지지 않도록 singleton 패턴으로 생성한다. 
		(insert->select , select->insert (insert된 게 select에 포함되지 않음)
 	  		-->동시성에 문제가 생기기 때문에 이런 문제를 애초에 방지하기 위해 한 놈만 만들어준다.
*/


public class ContactDAO {

	/************* 1. singleton **************/
	private static ContactDAO dao = new ContactDAO(); // 미리 dao를 만들어 놓는다. 디폴트 형태의 생성자가 호출된 것임.
	private ContactDAO() { } // 디폴트 타입의 생성자 만들어 놓음. 외부에서는 new Dao()가 안 됨.
	public static ContactDAO getInstance() {  // 외부에서는 이거밖에 안 보임.
		return dao;   // 만들어 놓은 dao를 갖다 써라는 의미.
	}  // 클래스메소드라고 불림. 클래스이름으로 호출해야함.
	
	/************* 2. field **************/
	
	// ContactDAO 클래스의 메소드들이 공통으로 사용할 요소를 선언한다. (커넥션 , 쿼리 실행 , 닫기)
	private Connection con;			// DB 접속
	private PreparedStatement ps;	// 쿼리문 실행
	private ResultSet rs;			// SELECT 결과
	private String sql;				// 쿼리문 자체
	private int res;				// INSERT, UPDATE, DELETE 결과
	
	
	/************* 3. method **************/
	
	// CRUD : CREATE(INSERT), READ(SELECT), UPDATE, DELETE  <- CRUD를 DB기본 작업이라고 말함. ex)게시판 CRUD할 줄 아시죠?
	
	// CRUD 메소드의 진행 순서 : Connection 얻기 -> CRUD 작업 -> 사용한 자원 반납 (항상 이 순서로 작업하는 게 가장 좋다)
	//	 ※ <Connection 얻기> , <사용한 자원 반납> 이 두 과정을 메소드화 할 거임. 그렇게 하고 불러다 쓸 거임.
	
	// 공통 메소드 - 1 (Connection 얻기)
	private Connection getConnection() {
		
		Connection con = null;
		
		try {
			
			Class.forName("oracle.jdbc.OracleDriver");
			
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
	
	// CRUD 메소드 - 1 (연락처 추가하기)
	// 1. 반환값   : 0(실패) 또는 1(성공)
	// 2. 매개변수 : ContactDTO contact 객체에는 연락처 정보(name, tel, email, address)가 모두 저장되어 있다.
	public int insertContact(ContactDTO contact) {	// ContactDTO타입으로 다 받을 수 있다.( 임포트 필요 ) , 매개변수에 정보가 다 저장되어있다고 생각해라
		
		try {
			
			con = getConnection();
			sql = "INSERT INTO CONTACT_TBL(CONTACT_NO, NAME, TEL, EMAIL, ADDRESS) VALUES (CONTACT_SEQ.NEXTVAL, ?, ?, ?, ?)";
			ps = con.prepareStatement(sql);
			
			ps.setString(1, contact.getName());   // name은 어디 들어있나? -> contact객체에 들어있음. 겟네임!
			ps.setString(2, contact.getTel());
			ps.setString(3, contact.getEmail());
			ps.setString(4, contact.getAddress());
			res = ps.executeUpdate();
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			close();	// close()라는 메소드 호출만 하면 끝. (공통메소드 close)
		}
		
		return res;		// 0아니면 1
		
	}
	
	// CRUD 메소드 - 2 (연락처 삭제하기)
	// 1. 반환값   : 0(실패) 또는 1(성공)
	// 2. 매개변수 : int contact_no 변수에는 삭제할 연락처의 고유 번호가 저장되어 있다.
	public int deleteContact(int contact_no) {
		
		try {
			
			con = getConnection();
			sql = "DELETE FROM CONTACT_TBL WHERE CONTACT_NO = ?";
			ps = con.prepareStatement(sql);
			ps.setInt(1, contact_no);
			res = ps.executeUpdate();
			
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
	
		return res;		// 0아니면 1
		
	}
	
	// CRUD 메소드 - 3 (이름을 이용한 연락처 조회하기)
	// 1. 반환값   : List<ContactDTO>  // contactDTO가 연락처 하나의 정보,,
	// 2. 매개변수 : String name 변수에는 조회할 연락처의 이름이 저장되어 있다.
	public List<ContactDTO> selectContactsByName(String name) {
	
		List<ContactDTO> contactList = new ArrayList<ContactDTO>();
		
		try {
			
			con = getConnection();
			sql =  "SELECT CONTACT_NO, NAME, TEL, EMAIL, ADDRESS";
			sql += "  FROM CONTACT_TBL";
			sql += " WHERE NAME = ?";
			ps = con.prepareStatement(sql);
			ps.setString(1, name);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				
				ContactDTO contact = new ContactDTO();   // rs.get으로 한 행의 데이터를 하나하나씩 가져오고 여기 하나의 객체(contact)에 저장.
				contact.setContact_no( rs.getInt("CONTACT_NO"));
				contact.setName( rs.getString("name"));
				contact.setTel( rs.getString("TEL"));
				contact.setEmail( rs.getString("EMAIL"));
				contact.setAddress( rs.getString("ADDRESS"));
								
				contactList.add(contact);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
		
		return contactList;
		
	}
	
	// CRUD 메소드 - 4 (연락처 수정하기)
	// 1. 반환값   : 0(실패) 또는 1(성공)
	// 2. 매개변수 : ContactDTO contact 객체에는 연락처 정보(name, tel, email, address)가 모두 저장되어 있다.
	public int updateContact(ContactDTO contact) {
		
		try {
		
			con = getConnection();
			sql  = "UPDATE CONTACT_TBL";
			sql += "   SET NAME = ?, TEL = ?, EMAIL = ?, ADDRESS = ?";
			sql += " WHERE CONTACT_NO = ?";
			ps = con.prepareStatement(sql);
			ps.setString(1, contact.getName());
			ps.setString(2, contact.getTel());
			ps.setString(3, contact.getEmail());
			ps.setString(4, contact.getAddress());
			ps.setInt(5, contact.getContact_no());
			res = ps.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
		
		return res;
		
	}
	
	// CRUD 메소드 - 5 (연락처 No를 이용한 연락처 조회하기)
	// 1. 반환값   : ContactDTO ( 연락처 No는 PK라 1개만 나온다.)
	// 2. 매개변수 : int contact_no 변수에는 조회할 연락처의 고유 번호가 저장되어 있다.
	public ContactDTO selectContactByNo(int contact_no) {
		
		ContactDTO contact = null; // 주의 null 해줘야함.
		
		try {
			
			con = getConnection();
			sql  = "SELECT CONTACT_NO, NAME, TEL, EMAIL, ADDRESS";
			sql += "  FROM CONTACT_TBL";
			sql += " WHERE CONTACT_NO = ?";
			ps = con.prepareStatement(sql);
			ps.setInt(1, contact_no);
			rs = ps.executeQuery();
			
			if(rs.next()) {
				contact = new ContactDTO();
				contact.setContact_no(contact_no);
				contact.setName( rs.getString(2) );
				contact.setTel( rs.getString(3) );
				contact.setEmail( rs.getString(4) );
				contact.setAddress( rs.getString(5) );
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
		
		return contact;		// null값이 반환되는 경우도 있다.
	}
}
