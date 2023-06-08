package ex03_functional_interface.ch04;

@FunctionalInterface  // 걸어두면 추상메소드 2개 이상 있으면 오류난다. 필수는 아닌데, 안전장치라고 생각.
public interface MyInterface {
	public int method(int a); // 매개변수, 반환타입 모두 있는 마지막 타입
}
