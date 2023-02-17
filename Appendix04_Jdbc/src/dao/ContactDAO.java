package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

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
	private Connection con;				// DB 접속
	private PreparedStatement ps;		// 쿼리문 실행
	private ResultSet rs;				// SELECT 결과
	private String sql;					// 쿼리문 자체
	private int res;					// INSERT, UPDATE, DELETE 결과
	
	
	/************* 3. method **************/
	
	// CRUD : CREATE(INSERT), READ(SELECT), UPDATE, DELETE  <- CRUD를 DB기본 작업이라고 말함. ex)게시판 CRUD할 줄 아시죠?
	
	// CRUD 메소드의 진행 순서 : Connection 얻기 -> CRUD 작업 -> 사용한 자원 반납 (항상 이 순서로 작업하는 게 가장 좋다)
	//	 ※ <Connection 얻기> , <사용한 자원 반납> 이 두 과정을 메소드화 할 거임. 그렇게 하고 불러다 쓸 거임.
	
}
