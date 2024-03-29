package ex03_method;

public class Car {
	
	// 필드
	int oilPot;
	int carSpeed;	// pushAccel 마다 속도는 10씩 증가, 최대 속도 100, pushBrake 마다 속도 10씩 감소.
	
	// 기름 넣기 메소드
	void addOil(int oil) {
		if(oilPot + oil > 50) {
			oilPot = 50;
			return;  // 메소드를 종료하시오. 반환타입이 void인 경우(return 반환값 없을 시에)에는 메소드를 종료하시오 로 의미가 바뀐다. / return : 리턴값을 반환하시오.
		}
		oilPot += oil;
	}
	
	// 달리기 메소드
	void pushAccel() {
		
		if(oilPot == 0) {
			return;
		}
		oilPot--;	// 기름이 줄었다.
		
		if(carSpeed + 10 > 100) {
			carSpeed = 100;
			return;
		}
		carSpeed += 10;
	}
	
	// 멈추기 메소드
	void pushBrake() {
		if(carSpeed == 0) {
			return;
		}
		carSpeed -= 10;
		if(carSpeed < 0) {
			carSpeed = 0;
		}
	}
	
}
