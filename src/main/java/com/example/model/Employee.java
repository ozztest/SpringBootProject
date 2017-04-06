package com.example.model;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;

import javax.persistence.*;

/**
 * Created by ozgen.gures on 05.04.2017.
 */
@Data
@Entity
public class Employee {

	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private Long id ;

	private String name;

	private String surname;

	private Long salary;

	@ManyToOne
	@Setter(AccessLevel.PUBLIC)
	private Department department;

	public Employee() {
	}

	public Employee(String name, String surname, Long salary) {
		this.name = name;
		this.surname = surname;
		this.salary = salary;
	}
}
