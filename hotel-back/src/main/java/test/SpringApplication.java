package test;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import configspring.ApplicationConfig;

public class SpringApplication {

	public static void main(String[] args) throws Exception {
//		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("application-context.xml");
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfig.class);
		
		
		Principal p = context.getBeanFactory().createBean(Principal.class);
		
		p.run(args);
		
		
		context.close();
	}

}