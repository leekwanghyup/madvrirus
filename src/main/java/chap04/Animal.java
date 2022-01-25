package chap04;

public interface Animal {

	default void cry() {};
	default void eat() {}; 
	void sleep(); 
}
