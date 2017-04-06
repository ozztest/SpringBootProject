package com.example;

import com.example.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication

public class DemoApplication {

	@Autowired
	private DepartmentRepository departmentRepository;



	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}


}
