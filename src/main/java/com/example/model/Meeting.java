package com.example.model;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.List;

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
	@Setter(AccessLevel.PUBLIC)
	private List<Department> departments;

}
