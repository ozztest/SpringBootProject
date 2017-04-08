package com.example.service;

import com.example.model.Department;

/**
 * Created by ozgen on 06.04.2017.
 */
public interface IDepartmentService {

    Iterable<Department> findAll();

    Department findById(Long id);

    void save(Department department);

    void update(Department department);

    boolean remove(Long id);

}
