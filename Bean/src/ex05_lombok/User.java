package ex05_lombok;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

	// 집 가서 롬복 설치 , 이클립스 실행, 오류발생 => 애너테이션 지우고 다시 입력해줘야 함
	// 임포트가 안 될 경우 : 빌드패스를 안 했을 거다.
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class User {
	private String id;
	private String pw;
}
