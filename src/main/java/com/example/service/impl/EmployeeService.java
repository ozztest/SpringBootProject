package com.example.service.impl;

import com.example.exception.CustomException;
import com.example.model.Employee;
import com.example.repository.EmployeeRepository;
import com.example.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * Created by ozgen on 06.04.2017.
 */
@Transactional
@Service
public class EmployeeService implements IEmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;


    @Override
    public Iterable<Employee> findAll() {
        return this.employeeRepository.findAll();
    }

    @Override
    public Employee findById(Long id) {
        return this.employeeRepository.findOne(id);
    }

    @Override
    public void save(Employee employee) {
        this.employeeRepository.save(employee);
    }

    @Override
    public void update(Employee employee) {
        if (employeeRepository.exists(employee.getId())) {
            employeeRepository.save(employee);
        } else {
            throw new CustomException("Guncellenecek Kayit Bulunamadi");
        }
    }

    @Override
    public boolean remove(Long id) {
        if (employeeRepository.exists(id)) {
            employeeRepository.delete(id);
            return true;
        } else {
            throw new CustomException("Silinecek Kayit Bulunamadi");
        }

    }
}
