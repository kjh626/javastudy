package ex01_generic;

public class Box<T> {
	// Object타입으로 쓰면 빼내서 쓸 때 어려움 다시 캐스팅해줘야 해서

	private T item;

	public T getItem() {
		return item;
	}

	public void setItem(T item) {
		this.item = item;
	}
	
	
	
	
}
