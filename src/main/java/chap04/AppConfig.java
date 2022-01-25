package chap04;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
	
	@Bean
	public Message message() {
		return new Message();
	}
	/*
	 <bean id="message" class="spring.chap04.Message"/>
	*/
	
	@Bean
	public Hello hello() {
		return new Hello(message());
	}
	
	/*
	  	<bean id="hello" class="spring.chap04.Hello">
	  		<construct-arg ref="message">
	  	</bean>
	 */
	
}
