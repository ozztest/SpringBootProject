package com.example.controller;

import com.example.model.Employee;
import com.example.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Created by ozgen on 06.04.2017.
 */
@RestController
@RequestMapping("/app")
public class EmployeeRestController {

    @Autowired
    private IEmployeeService employeeService;

    public EmployeeRestController(IEmployeeService iEmployeeService) {

        this.employeeService=iEmployeeService;
    }

    @RequestMapping(value = "/findAll", method = RequestMethod.GET)
    public Iterable<Employee> employees() {
        return employeeService.findAll();
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public ResponseEntity<Employee> save(@RequestBody Employee employee) {
        employeeService.save(employee);
        return new ResponseEntity<Employee>(employee, HttpStatus.OK);
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public ResponseEntity<Employee> update(@RequestBody Employee employee) {
        employeeService.update(employee);
        return new ResponseEntity<Employee>(employee, HttpStatus.OK);
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public String delete(@PathVariable("id") Long id) {
        Employee employee = employeeService.findById(id);
        boolean wasOk = employeeService.remove(employee.getId());
        if (wasOk){
            return "redirect:/findAll";
        }
        return "redirect:/fail";
    }
}
