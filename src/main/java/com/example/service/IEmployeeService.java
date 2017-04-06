package com.example.service;

import com.example.model.Employee;

/**
 * Created by ozgen on 06.04.2017.
 */
public interface IEmployeeService {

    Iterable<Employee> findAll();

    Employee findById(Long id);

    Employee save(Employee employee);

    Employee update(Employee employee);

    boolean remove(Long id);

}
