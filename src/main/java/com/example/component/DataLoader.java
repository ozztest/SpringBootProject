package com.example.component;

import com.example.model.Department;
import com.example.model.Employee;
import com.example.model.Meeting;
import com.example.service.impl.DepartmentService;
import com.example.service.impl.EmployeeService;
import com.example.service.impl.MeetingService;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;

/**
 * Created by ozgen.gures on 05.04.2017.
 */
@Component
public class DataLoader {

    private EmployeeService employeeRepository;

    private DepartmentService departmentRepository;

    private MeetingService meetingRepository;


    public DataLoader(EmployeeService employeRepository,
                      DepartmentService departmentRepository,
                      MeetingService meetingRepository) {
        this.employeeRepository = employeRepository;
        this.departmentRepository = departmentRepository;
        this.meetingRepository = meetingRepository;
    }

    @PostConstruct
    private void loadData() {

        final Department department = new Department("survivor", "sex");
        final Employee employee =new Employee("adı", "soyadi", 20L);
        final Meeting meeting = new Meeting("Toplanti", "sebepsiz");
        department.setEmployee(new ArrayList<Employee>(){{
            add(employee);
        }
        });
        employeeRepository.save(employee);



        department.setMeetings(new ArrayList<Meeting>() {
            {
                add(meeting);
            }
        });

        departmentRepository.save(department);
    }

}

