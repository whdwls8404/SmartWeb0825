package ex6_exception_class;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class WithdrawalException extends Exception {

	private int errorCode;
	
	public WithdrawalException(String message, int errorCode) {
		super(message);
		this.errorCode = errorCode;
	}
	
}
