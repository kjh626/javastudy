package ex05_lombok;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

	/*설치 경로에 포함되어 있으면 안 되는 것 2가지
		1. 폴더이름에 띄어쓰기 등 "공백"
		2. "한글"이 포함되어 있는 경우
		-javaagent:C:\GDJ61\installer\eclipse\lombok.jar
		
		잘못되면 이클립스가 실행이 안 된다.
		
		잘못된 경우
		이클립스 폴더의 lombok.jar 파일을 지우고
		.ini에서 마지막 줄(설치경로)을 지우면 다시 실행된다.
	*/
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
