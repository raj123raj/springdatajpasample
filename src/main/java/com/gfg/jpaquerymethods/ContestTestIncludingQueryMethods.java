package com.gfg.jpaquerymethods;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ContestTestIncludingQueryMethods {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext appContext = new AnnotationConfigApplicationContext();
		appContext.scan("com.gfg.jpaquerymethods");
		appContext.refresh();

		ContestQueryService contestService = (ContestQueryService) appContext.getBean("contestQueryService");
		contestService.test();

		appContext.close();
	}

}
