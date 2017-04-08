package com.example.model;

import javax.persistence.*;

/**
 * Created by ozgen.gures on 05.04.2017.
 */
@Entity
public class Employee {

	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private Long id ;

	private String name;

	private String surname;

	private Long salary;

	@ManyToOne
	private Department department;

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public Employee() {
	}

	public Employee(String name, String surname, Long salary) {
		this.name = name;
		this.surname = surname;
		this.salary = salary;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public Long getSalary() {
		return salary;
	}

	public void setSalary(Long salary) {
		this.salary = salary;
	}


	@Override
	public String toString() {
		return "Employee{" +
				"id=" + id +
				", name='" + name + '\'' +
				", surname='" + surname + '\'' +
				", salary=" + salary +
				'}';
	}
}
