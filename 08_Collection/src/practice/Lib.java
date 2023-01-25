package practice;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Lib {

	private List<Book> books;		// 배열 대신 List 쓰기 => 양 제한없이 가능, idx값이 따로 필요없다.
	private Scanner sc;
	
	public Lib() {
		books = new ArrayList<Book>();
		sc = new Scanner(System.in);
	}
	
	private void addBook() {
		System.out.println("=== 책 추가하기 ===");
		System.out.print("isbn >>> ");
		String isbn = sc.next();
		System.out.print("title >>> ");
		String title = sc.next();
		System.out.print("author >>> ");
		String author = sc.next();

		Book book = new Book(isbn, title, author);
		books.add(book);
		System.out.println(title + " 책이 추가되었습니다.");
	
		// 가득 찼을 때의 체크가 필요 없다.
	}
	
	private void deleteBook() throws RuntimeException {	// RuntimeException은 UnChecked-Exception이므로 throws RuntimeException을 생략할 수 있다. 
		System.out.println("=== 책 삭제하기 ===");
		if(books.isEmpty()) {			
			throw new RuntimeException("등록된 책이 없습니다.");
		}
		System.out.print("삭제할 isbn >>> ");
		String isbn = sc.next();
		if(isbn.isEmpty() == false) {	
			/* 1. 객체 기반 삭제(Book 객체 간 동등 비교가 필요하기 때문에 equals 메소드를 오버라이드 해야 한다.)*/
			for(Book book : books) {
				if(isbn.equals(book.getIsbn())) {	// target을,책을 만들어서 equals로 비교하는 방법도 있다.
					books.remove(book);		// equals 메소드가 내부에서 사용된다.
					System.out.println(book + " 책이 삭제되었습니다.");	
					return;
				}
			}
						
			
			/* 2. 인덱스 기반 삭제
			for(int i = 0; i < books.size(); i++) {	// 왜 향상 for문을 안썼는지? 삭제에서는 index값이 필요하기 때문에! 일반 for문을 씀.
				Book book = books.get(i);	
				if(isbn.equals(book.getIsbn())) {		
					Book deletedBook = books.remove(i);
					System.out.println(deletedBook + " 책이 삭제되었습니다.");	
					return;
				}
			} */
		}
		throw new RuntimeException(isbn + " isbn을 가진 책이 없습니다.");		// 비어있으면 이 코드로 온다, 삭제를 못했을 때도 이 코드로..
			
	}
	
	private void findBook() {		// 삭제와 코드구성이 거의 같음
		System.out.println("=== 책 조회하기 ===");
		if(books.isEmpty()) {
				throw new RuntimeException("등록된 책이 없습니다.");
		}
		System.out.print("조회할 isbn >>> ");
		String isbn = sc.next();
		if(!isbn.isEmpty()) {	
			for(Book book : books) {	
				if(isbn.equals(book.getIsbn())) {
					System.out.println("조회결과 : " + book);
					return;
				}
			}
		}
		
		throw new RuntimeException(isbn + " isbn을 가진 책이 없습니다.");	// 조회가 실패했을 때..
		
	}
	
	private void printAllBooks() {
		System.out.println("=== 전체 조회하기 ===");
		if(books.isEmpty()) {
			throw new RuntimeException("등록된 책이 없습니다.");
		}
		for(Book book : books) {
			System.out.println(book);
		}
	}
	
	public void manage() {
		
		
		while(true) {
			
			try {	// try, catch를 메소드를 포함하게 넓게 설정해줘도 된다.
			
				System.out.print("1.추가 2.삭제 3.조회 4.전체 0.종료 >>> ");
				String choice = sc.next();
				
				switch(choice) {
				case "1":
					addBook();
					break;
				case "2":
					deleteBook();
					break;
				case "3":
					findBook();
					break;
				case "4":
					printAllBooks();
					break;
				case "0":
					System.out.println("도서관리 프로그램을 종료합니다.");
					return;
				default:
					System.out.println("잘못된 입력입니다. 다시 시도하세요.");
				}
			
			} catch(Exception e) {
				System.out.println(e.getMessage());
			}
		}
		
	}
	
}