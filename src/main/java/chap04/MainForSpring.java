package chap04;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainForSpring {
	
	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx =
				new AnnotationConfigApplicationContext(AppConfig.class); 
		
		Hello hello = ctx.getBean("hello", Hello.class);
		hello.greeting();
	}
}
