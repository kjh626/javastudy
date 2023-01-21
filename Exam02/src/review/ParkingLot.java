package review;

import java.util.Scanner;

import parking.Car;

public class ParkingLot {

	private String name;
	private Car[] cars;
	private int idx;		// idx는 1|1|0|0|...| 라고 가정하면 idx가 2면 차량이 비어있는 자리 [2]
	private Scanner sc;
	
	public ParkingLot(String name) {
		super();
		this.name = name;
		cars = new Car[10];
		sc = new Scanner(System.in);
	}
	
	public void addCar() {
		System.out.println("현재 등록된 차량 : " + idx + "대");
		if(idx == cars.length) {
			System.out.println("더 이상 차량 등록이 불가능합니다.");
			return;
		}
		System.out.print("차량번호 >>> ");
		String carNo = sc.next();
		System.out.print("모델 >>> ");
		String model = sc.next();
		
		cars[idx++] = new Car(carNo, model);
		System.out.println("차량번호 " + carNo + " 차량이 등록되었습니다.");
	}
	
	public void deleteCar() {
		if(idx == 0) {
			System.out.println("등록된 차량이 없습니다.");
			return;
		}
		System.out.print("제거할 차량번호 >>> ");
		String carNo = sc.next();
		
		for(int i = 0; i < idx; i++) {
			Car car = cars[i];
		 	if(carNo.equals(car.getCarNo())) {
		 		
		 		/* 방법 1. 삭제할 요소의 뒤에 있는 것들을 모두 한 칸씩 앞으로 옮기기
		 		 * 그림을 그려야 이해하기 쉬울 것이다.
		 		 |1|1|1|1|null| -> 우리는 첫 번째 것을 없애고 싶음. 차량 4대. null 자리는 [idx]에 해당
		 		 i 다음부터 null 자리 전까지의 개수를 구할 때, i 다음은 무조건 i+1~~ 로 시작 -> [i+1] ~ [idx-1]
		 		 첫 번째가 i, 2번째~4번째([1]~[3]) 까지의 개수 => idx - 1 - i => 4 - 1 - 0 3개
		 		 우리의 목표는 삭제할 자리[0]를 없애고, 뒤에 것[1~3]들을 앞으로 옮겨준다.
		 		 옮겨줄 애들의 정보가 i + 1 부터이고 옮겼을 때는 i 부터가 된다.
		 		 
		 		 System.arraycopy(cars, i+1, cars, i, 3)
		 		 자동차 배열의 i+1부터 두번째 배열의 i로 총 개수(idx -i -1) 3개
		 		 앞에 있는 배열을 뒤에 있는 배열로 옮긴다고 생각( 3개 )
		 		 삭제할 다음 요소(i+1)들을 삭제할 자리들(i)로 보낸다.
		 		*/
		 		System.arraycopy(cars, i + 1, cars, i, idx - i - 1);
		 		cars[--idx] = null;	// 마지막 자리는 null값으로 바꿔줘야한다.
		 		System.out.println("차량번호 " + carNo + " 인 차량이 삭제되었습니다.");
		 		return;
		 		
		 		
		 		/* 방법 2. 마지막 차량을 옮겨오기
		 		제거할 차량의 위치 : i
		 		마지막 차량의 위치 : idx - 1
		 		cars[i] = cars[idx - 1];	// 첫 번째 차량을 뺀다고 치면 첫 번째 차량이 마지막 차량으로 덮어쓰기 됨.
		 									// |3|2|3|null|...| 이런식으로 됨. 마지막 자리에 여전히 남아있음. -> [2] 자리를 없애줘야 한다. => idx를 줄여줘야한다.
		 		cars[--idx] = null;			// 3번 차량의 정보를 null값으로 바꿔줌.
		 		return;
		 		*/
		 	} // else {} => if else 문은 이거 아니면 else다 가 된다. 차량 3대면 다 해당 안 되면 else가 3번 쓰임. 이런걸 원하지 않음
			
			/*
			if(cars[i].getCarNo().equals(carNo)) {
				cars[i] = cars[--idx];
				System.out.println("차량번호 " + carNo + " 차량이 삭제되었습니다.");
				return;
			} 
			*/
		}
		// for문 밖. 삭제할 차량이 없을 때 여기로 와야 한다.(이미 전체 순회를 했다. for-> if에서)
		System.out.println("대상 차량이 존재하지 않습니다.");
		
	}
	
	public void printAllCars() {
		if(idx == 0) {
			System.out.println("등록된 차량이 없습니다.");
			return;
		}
		System.out.println( name + "차량 목록");
		for(int i = 0; i < idx; i++) {
			// Car car = cars[i];
			// System.out.println(car.toString());		// toString 오버라이드하는 이유 시스템아웃으로 출력하려고
			System.out.println(cars[i].toString());
		}
		/*
		for(int i = 0; i < cars.length; i++) {
			Car car = cars[i];
			if(car != null) {
				System.out.println(car);
			}
		}
		*/
		/*
		for(Car car : cars) {
			if(car != null) {
				System.out.println(car);
			}
		} // 두 개는 같은 문장임.
		*/ 
		
	}
	
	public void manage() {
		while(true) {
		
		System.out.print("1.추가  2.삭제  3.전체  0.종료 >>> ");
		
		String choice = sc.next();
		switch(choice) {
		case "1":
			addCar();
			break;
		case "2":
			deleteCar();
			break;
		case "3":
			printAllCars();
			break;
		case "0":
			return;
		default: 
			System.out.println("존재하지 않는 메뉴입니다.");
		}
		
		}
	}
	
	
	
}
