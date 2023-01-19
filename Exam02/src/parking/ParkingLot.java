package parking;

import java.util.Scanner;

public class ParkingLot {

	private String name;
	private Car[] cars;	// 자동차 여러 개 저장할 자동차 배열
	private int idx;	// 배열 뒤에 따라다닐 인덱스. 필드라서 처음엔 0임. => idx는 자동차가 들어오는 자리이기도 하고, 주차장에 주차된 자동차의 대수이기도 함. 
	private Scanner sc;
	
	public ParkingLot(String name) {
		super();
		this.name = name;
		cars = new Car[10];
		sc = new Scanner(System.in);
	}
	
	// 메소드
	// 주차장에 차가 들어왔다.
	public void addCar() {
		System.out.println("현재 등록된 차량 : " + idx + "대");
		// 예외 처리
		if(idx == cars.length) {
			System.out.println("더 이상 차량 등록이 불가능합니다.");
			return;
		}
		System.out.print("차량번호 >>> ");
		String carNo = sc.next();
		System.out.print("모델 >>> ");
		String model = sc.next();
		/* 자동차 객체를 만들어서 첫입력, 두번째 입력을 집어넣는 방법
		안내문 : System.out.println("차량번호와 모델명을 순서대로 입력하세요");
		Car car = new Car(sc.next(), sc.next());
		*/
		cars[idx++] = new Car(carNo, model); // 카[인덱스]에 차량 등록해주기 
		/* Car car = new Car(carNo, model);
			cars[idx++] = car;    // cars[0] = car;    cars[1] = car;     cars[2] = car; ...
		*/
		System.out.println("차량번호 " + carNo + " 차량이 등록되었습니다.");
	}
	
	public void deleteCar() {
		
	}
	
	public void printAllCars() {
		
	}
	
	public void manage() {
		
		while(true) {
			
			System.out.print("1.추가  2.삭제  3.전체  0.종료 >>> ");
			// 1,2,3,0 뭐로 받을지 선택할 수 있다. 1) int 2) String
			/*
			int choice = sc.nextInt();	// 숫자로 입력받으면 위험할 수 있음.
			String choice = sc.next();	// 문자열은 입력의 형식이 잘못되었다 하더라도 뻗어버리지 않음. 특별히 예외처리 안 해도 괜찮다.
			*/
			String choice = sc.next();
			
			switch(choice) {
			case "1":
				addCar();   // addCar메소드 호출
				break;
			case "2":
				deleteCar();	// deleteCar 호출
				break;
			case "3":
				printAllCars();	// printAllCars 호출
				break;
			case "0":
				return;		// break;는 나가봤자 무한루프임. 대신 return을 쓰자.=> manage 메소드 종료
			default:
				System.out.println("존재하지 않는 메뉴입니다.");
			}
		}
		
	}
	
}
