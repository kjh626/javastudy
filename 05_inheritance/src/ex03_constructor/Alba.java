package ex03_constructor;
	// 연습
public class Alba extends Student {
	
	// 필드
	private String company;
	
	// 생성자
	public Alba(String name, String school, String company) {
		super(name, school);
		this.company = company;
	}

	// 메소드
	public String getCompany() {
		return company;
	}
	public void setCompony(String company) {
		this.company = company;
	}
	
	
}
