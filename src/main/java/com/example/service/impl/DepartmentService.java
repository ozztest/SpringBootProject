package com.example.service.impl;

import com.example.exception.CustomException;
import com.example.model.Department;
import com.example.repository.DepartmentRepository;
import com.example.service.IDepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * Created by ozgen on 06.04.2017.
 */
@Transactional
@Service
public class DepartmentService implements IDepartmentService {

    @Autowired
    DepartmentRepository departmentRepository;


    @Override
    public Iterable<Department> findAll() {
        return this.departmentRepository.findAll();
    }

    @Override
    public Department findById(Long id) {
        return this.departmentRepository.findOne(id);
    }

    @Override
    public void save(Department department) {
        this.departmentRepository.save(department);
    }

    @Override
    public void update(Department department) {
        if (this.departmentRepository.exists(department.getId())) {
            this.departmentRepository.save(department);
        } else {
            throw new CustomException("Guncellenecek Kayit Bulunamadi");
        }

    }

    @Override
    public boolean remove(Long id) {
        if (this.departmentRepository.exists(id)) {
            this.departmentRepository.delete(id);
            return true;
        } else {
            throw new CustomException("Silinecek Kayit Bulunamadi");
        }

    }
}
