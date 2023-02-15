package ex05_lombok;
	// 	연습

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor 
@Getter
@Setter
public class Practice_Student {
	private String name;
	private String stuNo;
}
