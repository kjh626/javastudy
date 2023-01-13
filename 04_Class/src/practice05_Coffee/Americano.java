package practice05_Coffee;

//아메리카노

public class Americano {

	// 필드
	private Espresso[] cups;  // 에스프레소 여러 잔 들어갈 수 있음
	private int shotCount;    // 아메리카노에 들어간 에스프레소 개수(샷)
	private int extraWater;   // 물
	
	// 생성자
	public Americano(int shotCount, int extraWater) {
		super();
		this.shotCount = shotCount;
		this.extraWater = extraWater;
	}
	
	
	// 조회 info 메소드
	public void info() {
		System.out.println();  // 커피 원두 원산지, 에스프레소 샷 정보 등 조회
	}

}