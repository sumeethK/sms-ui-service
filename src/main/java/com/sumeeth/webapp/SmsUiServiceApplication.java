package com.sumeeth.webapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@ImportResource({"classpath*:applicationContext.xml"})
public class SmsUiServiceApplication {

	public static void main(String[] args) {
		/*
		Entry point
		*/

		SpringApplication.run(SmsUiServiceApplication.class, args);
	}
}
