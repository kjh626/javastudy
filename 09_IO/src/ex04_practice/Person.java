package ex04_practice;

import java.io.Serializable;

public class Person implements Serializable{

	private static final long serialVersionUID = -3126190170465340502L;
	private String name;
	private int age;
	private double height;
	private boolean isAlive;
	
	public Person() {
		
	}
	
	
	public Person(String name, int age, double height, boolean isAlive) {
		super();
		this.name = name;
		this.age = age;
		this.height = height;
		this.isAlive = isAlive;
	}


	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public double getHeight() {
		return height;
	}
	public void setHeight(double height) {
		this.height = height;
	}
	public boolean isAlive() {
		return isAlive;
	}
	public void setAlive(boolean isAlive) {
		this.isAlive = isAlive;
	}
	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + ", height=" + height + ", isAlive=" + isAlive + "]";
	}
	
}
