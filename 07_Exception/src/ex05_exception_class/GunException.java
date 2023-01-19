package ex05_exception_class;

/*
	예외 클래스 만들기 <- 안 중요함
	1. Exception 클래스를 상속받는다. (필수)
	2. Exception 클래스의 슈퍼 클래스인 Throwable 클래스가 Serializable 인터페이스를 구현하기 때문에 serialVersionUID 값을 가질 수 있다. (선택)
	왜 클래스 만듦? 추가로 더 저장시킬 수 있다. (주로 예외 코드 + 메시지 를 추가할 목적)
	Serializable : 직렬화
*/

public class GunException extends Exception {

	private static final long serialVersionUID = 3700059434730916901L;
	
	private String exceptionCode;
	
	public GunException(String message, String exceptionCode) {
		super(message);	// Exception에 message 전달! 최우선적으로 해야될 것
		this.exceptionCode = exceptionCode;
	}

	public String getExceptionCode() {
		return exceptionCode;
	}

	public void setExceptionCode(String exceptionCode) {
		this.exceptionCode = exceptionCode;
	}

	
	
}
