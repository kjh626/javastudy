package ex04_throws;

public class Gun {

	private int bullet;
	public static final int MAX_BULLET = 10;	// final로 막아 놓으면 못 건드리니까 -> public static 으로 처리해버림
	
	// 총알 넣기
	public void reload(int bullet) throws RuntimeException {	// throws RuntimeException : reload 메소드를 호출하는 곳으로 예외를 던지겠다. 
		if(this.bullet + bullet > MAX_BULLET) {	// try,catch(예외처리) 해야됨, throw 가능
			throw new RuntimeException("장전 불가능");	// (return;지우고)  예외 발생했을 때 던진다. -> 받는 애는 어디..?
		}												// => try, catch없이 예외처리 하는 방법
		this.bullet += bullet;
	}
	
	// 총 쏘기
	public void shoot() throws RuntimeException {	// throws 생략 못 한다고 생각하고 꼭 적어라. (unchecked exception의 경우 throws 생략해도 잘 돌아가긴 함)
		if(bullet == 0) {			// try,catch(예외처리) 해야됨
			throw new RuntimeException("총알 부족");
		}
		bullet--;
	}

	public int getBullet() {
		return bullet;
	}

	public void setBullet(int bullet) {
		this.bullet = bullet;
	}
	
	
}
