package com.example.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by ozgen.gures on 05.04.2017.
 */
@Data
@Entity
public class Meeting {

	@Id @GeneratedValue
	private Long id;

	private String name;

	private String description;

	@ManyToMany
	private Set<Department> departments = new HashSet<>();

	public Meeting(String name, String description) {
		this.name = name;
		this.description = description;
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Set<Department> getDepartments() {
		return departments;
	}

	public void setDepartments(Set<Department> departments) {
		this.departments = departments;
	}

	@Override
	public String toString() {
		return "Meeting{" +
				"id=" + id +
				", name='" + name + '\'' +
				", description='" + description + '\'' +
				", departments=" + departments +
				'}';
	}
}
