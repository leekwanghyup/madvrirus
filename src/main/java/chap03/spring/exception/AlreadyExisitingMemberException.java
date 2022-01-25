package chap03.spring.exception;

public class AlreadyExisitingMemberException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public AlreadyExisitingMemberException(String message) {
		super(message);
	}
}
