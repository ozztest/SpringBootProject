package com.example.model;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

/**
 * Created by ozgen.gures on 05.04.2017.
 */
@Data
@Entity
public class Department {

	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String name;

	private String description;

	@OneToMany
	@Setter(AccessLevel.PUBLIC)
	private List<Employee> employees;

	@ManyToMany
	@Setter(AccessLevel.PUBLIC)
	private List<Meeting> meetings;

	public Department(String name, String description) {
		this.name = name;
		this.description = description;
	}
}
