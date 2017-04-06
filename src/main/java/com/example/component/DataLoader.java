package com.example.component;

import com.example.model.Department;
import com.example.model.Employee;
import com.example.repository.DepartmentRepository;
import com.example.repository.EmployeeRepository;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ozgen.gures on 05.04.2017.
 */
@Component public class DataLoader {

	private EmployeeRepository employeeRepository;

	private DepartmentRepository departmentRepository;



	public DataLoader(EmployeeRepository employeRepository,DepartmentRepository departmentRepository) {
		this.employeeRepository = employeRepository;
		this.departmentRepository=departmentRepository;
	}

	@PostConstruct private void loadData() {

		Employee employee = new Employee("oz", "sadf", 1L);
		Department department=new Department("departman","sex");
		departmentRepository.save(department);
		List<Employee> list =new ArrayList<Employee>();
		list.add(employee);
		department.setEmployees(list);
		employee.setDepartment(department);

		employeeRepository.save(employee);

		System.out.print("ses");

	}

}

