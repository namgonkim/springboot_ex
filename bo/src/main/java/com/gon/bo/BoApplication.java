package com.gon.bo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// @EnableAutoConfiguration, @ComponentScan, @Configuration
// 이 3가지를 합쳐놓은게 SpringBootApplication이라고 함.
@SpringBootApplication
public class BoApplication {

	public static void main(String[] args) {
		SpringApplication.run(BoApplication.class, args);
	}

}
