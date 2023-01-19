package ex02_practice;

public class Person {

	private String name;
	private String height;
	
	public Person() {
		
	}

	public Person(String name, String height) {
		super();
		this.name = name;
		this.height = height;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getHeight() {
		return height;
	}

	public void setHeight(String height) {
		this.height = height;
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", height=" + height + "]";
	}
	
	
	
}
