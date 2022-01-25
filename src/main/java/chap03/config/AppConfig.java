package chap03.config;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import chap03.spring.MemberDao;
import chap03.spring.service.MemberRegisterService;

@Configuration
@ComponentScan(basePackageClasses = MemberDao.class )
@EnableTransactionManagement
public class AppConfig {
		
	@Bean(destroyMethod = "close")
	public DataSource dataSource() {
		DataSource ds = new DataSource(); 
		ds.setDriverClassName("com.mysql.jdbc.Driver");
		ds.setUrl("jdbc:mysql://localhost/spring4fs");
		ds.setUsername("root"); 
		ds.setPassword("1234");
		ds.setInitialSize(2);
		ds.setMaxActive(10);
		return ds;
	}
	
	@Bean
	public PlatformTransactionManager transactionManager() {
		DataSourceTransactionManager tm = new DataSourceTransactionManager(); 
		tm.setDataSource(dataSource());
		return tm; 
	}
	
	@Bean
	public MessageSource messageSource() {
		ResourceBundleMessageSource ms = new ResourceBundleMessageSource();
		ms.setBasenames("message.label","message.errors");
		ms.setDefaultEncoding("UTF-8");
		return ms; 
	}
	
	
}
