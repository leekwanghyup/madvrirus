package chap04;

public class Hello {
	
	Message message;

	public Hello(Message message) {
		this.message = message;
	} 
	
	public void greeting() {
		String msg = message.getMessage();
		System.out.println(msg);
	}
	
}
