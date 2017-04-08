package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages={"com.example"})// same as @Configuration @EnableAutoConfiguration @ComponentScan combined

public class DemoApplication {
		public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

}
