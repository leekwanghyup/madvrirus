package chap02;

import org.springframework.context.support.GenericXmlApplicationContext;

public class MainForSpring {
	public static void main(String[] args) {
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("classpath:/applicationContext.xml"); 
		Greeter g = ctx.getBean("greeter", Greeter.class);
		String msg = g.greet("이광협");
		System.out.println(msg);
		Greeter g2 = ctx.getBean("greeter", Greeter.class);
		System.out.println(g);
		System.out.println(g2);
		System.out.println(g == g2); // 스프링은 싱글톤 객체다 

		
		Hello hello = ctx.getBean("hello",Hello.class);

		hello.greeting();
		
		ctx.close();
	}
}
