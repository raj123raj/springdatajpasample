package com.gfg.jpa;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ContestTest {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext appContext = new AnnotationConfigApplicationContext();
		appContext.scan("com.gfg.jpa");
		appContext.refresh();

		ContestService contestService = (ContestService) appContext.getBean("contestService");
		contestService.test();

		appContext.close();
	}

}
