package com.example.component;

import com.example.model.Department;
import com.example.model.Employee;
import com.example.model.Meeting;
import com.example.repository.DepartmentRepository;
import com.example.repository.EmployeeRepository;
import com.example.repository.MeetingRepository;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.HashSet;

/**
 * Created by ozgen.gures on 05.04.2017.
 */
@Component
public class DataLoader {

    private EmployeeRepository employeeRepository;

    private DepartmentRepository departmentRepository;

    private MeetingRepository meetingRepository;


    public DataLoader(EmployeeRepository employeRepository, DepartmentRepository departmentRepository, MeetingRepository meetingRepository) {
        this.employeeRepository = employeRepository;
        this.departmentRepository = departmentRepository;
        this.meetingRepository = meetingRepository;
    }

    @PostConstruct
    private void loadData() {

        final Employee employee = new Employee("oz", "sadf", 1L);
        final Department department = new Department("survivor", "sex");
        final Meeting meeting = new Meeting("Toplanti", "sebepsiz");
        employeeRepository.save(employee);
        meetingRepository.save(meeting);
        department.setEmployees(new HashSet<Employee>() {
            {
                add(employee);
            }
        });

        department.setMeetings(new HashSet<Meeting>() {
            {
                add(meeting);
            }

        });


        meeting.setDepartments(new HashSet<Department>() {
            {
                add(department);
            }
        });


        departmentRepository.save(department);


        System.out.print("ses");

        Employee emp = employeeRepository.findOne(1L);
        System.out.print(emp.getDepartment().getName());



    }

}

