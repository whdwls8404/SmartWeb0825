package ex6_exception_class;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DepositException extends Exception {
	
	private int errorCode;
	
	public DepositException(String message, int errorCode) {
		super(message);
		this.errorCode = errorCode;
	}

}
