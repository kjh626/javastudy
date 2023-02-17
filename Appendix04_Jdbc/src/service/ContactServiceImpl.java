package service;

import java.util.List;
import java.util.Scanner;

import dao.ContactDAO;
import dto.ContactDTO;

public class ContactServiceImpl implements ContactService {
	
	/************* 1. field **************/
	private Scanner sc;
	private ContactDAO dao;
	
	/************* 2. constructor **************/
	public ContactServiceImpl() {
		sc = new Scanner(System.in);
		dao = ContactDAO.getInstance();
	}
	
	/************* 3. method **************/
	
	@Override
	public void addContact() {
		
		System.out.println("===== 연락처 추가하기 =====");
		
		// 입력 받을 거임 sc로
		System.out.print("신규 연락처 이름 >>> ");
		String name = sc.next();
		System.out.print("신규 연락처 번호 >>> ");
		String tel = sc.next();
		System.out.print("신규 연락처 이메일 >>> ");
		String email = sc.next();
		System.out.print("신규 연락처 주소 >>> ");
		String address = sc.next();
		
		// 이 4개를 ContactDTO로 하나로 모아줘야 함
		ContactDTO contact = new ContactDTO();
		contact.setName(name);
		contact.setTel(tel);
		contact.setEmail(email);
		contact.setAddress(address);
		
		int addResult = dao.insertContact(contact);
		System.out.println(addResult + "개의 연락처가 등록되었습니다.");  // 1개 아니면 0개(실패) 겠지!
		
	}

	@Override
	public void removeContact() {
		
		System.out.println("===== 연락처 삭제하기 =====");
		
		System.out.print("삭제할 연락처의 이름 >>> ");
		String name = sc.next();
		
		List<ContactDTO> contactList = dao.selectContactsByName(name);  // dao 1번째 호출(SELECT)
		System.out.println("<<< 조회된 연락처 목록 >>>");
		for(ContactDTO contact : contactList) {
			System.out.println(contact);
		}
		
		System.out.print("삭제할 연락처 No >>> ");
		int contact_no = sc.nextInt();
		
		int removeResult = dao.deleteContact(contact_no);  // dao 2번째 호출(DELETE)  
														// --> 2번 호출했는데 트랜잭션의 대상인가?(insert,update,delete 만 해당) select가 하나 있어서.. 트랙잭션 대상 아님..
		
		System.out.println(removeResult + "개의 연락처가 삭제되었습니다.");
		
	}
	
	@Override
	public void modifyContact() {
		
		System.out.println("===== 연락처 수정하기 =====");
		
		System.out.print("수정할 연락처 이름 >>> ");
		String name = sc.next();
		
		List<ContactDTO> contactList = dao.selectContactsByName(name);    // remove와 코드 똑같.
		System.out.println("<<< 조회된 연락처 목록 >>>");
		for(ContactDTO contact : contactList) {
			System.out.println(contact);
		}
		
		System.out.print("수정할 연락처 No >>> ");
		int contact_no = sc.nextInt();
		ContactDTO contact = dao.selectContactByNo(contact_no);   // 수정하기 전의 내용을 저장한 contact 객체 수정 전 내용 다 가지고 있었음.
		// dao.selectContactByNo(contact_no) 단 하나의 객체임. no가 pk라 하나의 행만 나오니까.
		// 이 하나의 contact 객체를 아래에서 선택한 항목만 수정해주는 거임.
		
		System.out.print("수정할 항목 선택(1.이름  2.전화  3.이메일  4.주소) >>> "); // 선택한 항목만 바꿔주겠다. 나머지 정보는 그대로 남아있음....
		String choice = sc.next();
		switch(choice) {
		case "1" : 
			System.out.print("수정할 이름 입력 >>> ");
			contact.setName( sc.next());
			break;
		case "2":
			System.out.print("수정할 전화 입력 >>> ");
			contact.setTel( sc.next());
			break;
		case "3": 
			System.out.print("수정할 이메일 입력 >>> ");
			contact.setEmail( sc.next());
			break;
		case "4":
			System.out.print("수정할 주소 입력 >>> ");
			contact.setAddress( sc.next());
			break;
		default:
			System.out.println("잘못된 입력입니다. 수정을 취소합니다.");
			return;
		}
			
		int modifyResult = dao.updateContact(contact);  // DAO에 수정한 contact 전달
		
		System.out.println(modifyResult + "개의 연락처가 수정되었습니다.");
		
	}
	
	@Override
	public void findContactsByName() {

		System.out.println("===== 연락처 조회하기 =====");
		
		System.out.print("조회할 연락처 이름 >>> ");
		String name = sc.next();
		
		List<ContactDTO> contactList = dao.selectContactsByName(name);
		for(ContactDTO contact : contactList) {
			System.out.println(contact);
		}
		
	}
	
	@Override
	public void findAllContacts() {
		
		System.out.println("===== 전체 연락처 목록 =====");
		for(ContactDTO contact : dao.selectAllContacts()) {    // dao.selectAllContacts() 이게 arraylist를 반환한다. 그래서 이걸 arraylist라고 생각하면 된다.
			System.out.println(contact);
		}
		
	}
	
}
