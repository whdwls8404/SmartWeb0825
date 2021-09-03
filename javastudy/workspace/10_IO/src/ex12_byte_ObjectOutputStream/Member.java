package ex12_byte_ObjectOutputStream;

import java.io.Serializable;

import lombok.AllArgsConstructor;

// ObjectOutputStream을 통해서 파일로 그대로 보낼 객체를 생성할 클래스
// 이런 클래스는 직렬화 처리해야 한다.

// Serializable 인터페이스
// 직렬화 처리를 수행하려면 Serializable 인터페이스를 구현한다.
// 직렬화 처리된 객체를 다시 모으기 위해서 serialVersionUID 필드 값이 필요하다.

@AllArgsConstructor
public class Member implements Serializable {
		
	/* 
	 * default serial version
	 * private static final long serialVersionUID = 1L;
	 */

	/*
	 * generated serial version
	 */
	private static final long serialVersionUID = -1736287765156557037L;
	
	private String id;
	private String password;
	
	public void info() {
		System.out.println(id + "(" + password + ")");
	}
	
}
