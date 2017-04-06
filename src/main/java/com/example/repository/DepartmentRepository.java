package com.example.repository;

import com.example.model.Department;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by ozgen.gures on 05.04.2017.
 */
public interface DepartmentRepository extends CrudRepository<Department,Long> {

}
