package service;

import dao.ContactDAO;

public class ContactService {

	// 서비스는 다오를 불러서 그 작업을 호출해줘야 한다.
	// ContactDAO 객체를 필드로 선언해 보자.
	private ContactDAO dao = ContactDAO.getInstance();   // 현재 dao는 없음.
	
	public void 목록서비스() {
		
		dao.목록보기();
		
	}
	
}
