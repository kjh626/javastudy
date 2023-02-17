package controller;

import java.util.Scanner;

import service.ContactService;
import service.ContactServiceImpl;

public class ContactController {
	
	/************* 1. field **************/
	// 스캐너와 서비스 객체가 필요할 것으로 보임.
	private Scanner sc;
	private ContactService service;
	
	/************* 2. constructor **************/
	public ContactController() {
		sc = new Scanner(System.in);
		service = new ContactServiceImpl();   // ContactServiceImpl로 new 해야한다. 인터페이스는 new로 만들면 안 됨.
	}
	
	/************* 3. method **************/
	
	public void play() {
		
		while(true) {
			System.out.print("1.추가  2.삭제  3.수정  4.개별조회  5.전체조회  6.연락처.csv생성  0.종료 >>> ");
			String choice = sc.next();
			switch(choice) {
			case "1":
				service.addContact();
				break;
			case "0":
				System.out.println("연락처 관리 프로그램이 종료되었습니다.");
				return;
			default:
				System.out.println("잘못된 입력입니다. 다시 시도하세요");
			}
		}
		
	}
	
	
}
