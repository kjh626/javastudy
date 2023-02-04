package ex05_practice;

public class GunException extends Exception {

	private static final long serialVersionUID = -8268202645790430750L;
	
	private String exceptionCode;
	
	public GunException(String message, String exceptionCode) {
		super(message);
		this.exceptionCode = exceptionCode;
	}

	public String getExceptionCode() {
		return exceptionCode;
	}

	public void setExceptionCode(String exceptionCode) {
		this.exceptionCode = exceptionCode;
	}
	
	
}
