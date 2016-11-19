package com.sumeeth.webapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@ImportResource({"classpath*:applicationContext.xml"})
public class SmsUiServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(SmsUiServiceApplication.class, args);
	}
}
