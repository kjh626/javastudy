package practice;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Library {

	private List<Book> books;		// 배열 대신 List 쓰기 => 양 제한없이 가능, idx값이 따로 필요없다.
	private Scanner sc;
	
	public Library() {
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
	
	private void deleteBook() {
		System.out.println("=== 책 삭제하기 ===");
		try {	// 예외 처리
			if(books.isEmpty()) {			// 공백 검사를 위한 메소드 : isEmpty() => 공백이면 true
				throw new RuntimeException("등록된 책이 없습니다.");
			}
			System.out.print("삭제할 isbn >>> ");
			String isbn = sc.next();
			if(isbn.isEmpty() == false) {	// 비어있지 않을 때! 삭제 절차를 진행
				for(int i = 0; i < books.size(); i++) {
					Book book = books.get(i);	// 저장된 책 한 권, 한 권.
					if(isbn.equals(book.getIsbn())) {		// ArrayList의 remove는 삭제하면 내부적으로 알아서 앞으로 당긴다.
						Book deletedBook = books.remove(i);	// remove(i)는 삭제된 요소(Book)를 반환한다. (Book deletedBook = ) 생략해도 괜찮다.
						System.out.println(deletedBook + " 책이 삭제되었습니다.");		// Book deletedBook = 생략하고, deletedBook은 book으로 바꿔주면 된다.
						return;
					}
				}
			}
			throw new RuntimeException(isbn + " isbn을 가진 책이 없습니다.");		// 비어있으면 이 코드로 온다, 삭제를 못했을 때도 이 코드로..
		} catch(Exception e) {
			System.out.println(e.getMessage());		// 던지면(throw) catch로 가서 적어준 메시지를 보여줄 것이다.
		}
			
	}
	
	private void findBook() {
		
	}
	
	private void printAllBooks() {
		
	}
	
	public void manage() {
		
		while(true) {
			
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
			
			
		}
		
	}
	
}
