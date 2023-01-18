package ex04_builder;

public class MainClass {

	public static void main(String[] args) {

		// Builder builder = new Builder();	  빌더는 내부클래스이기 때문에 외부에서 못 부른다.
		
		//User user = new User();
		//Builder builder = user.builder();

		//User user2 = builder.id("admin").pw("123456").build();		// .build() 는 결과를 받아오겠습니다.를 뜻함
		
		// 클래스 이름을 가지고 부를 수 있게 해보자. -> static 처리 필요
		User user = User.builder()
						.id("admin")
						.pw("123456")
						.build();
		// 빌더 패턴, 객체 생성하는 속도가 빨라진다.
		// 잘 모르겠으면 롬복 쓰면 된다.
		System.out.println(user);
		
	}

}
