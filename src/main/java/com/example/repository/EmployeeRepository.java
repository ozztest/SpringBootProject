package com.example.repository;

import com.example.model.Employee;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by ozgen.gures on 05.04.2017.
 */
@Repository
public interface EmployeeRepository extends CrudRepository<Employee,Long> {

}
