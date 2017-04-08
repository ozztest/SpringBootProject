package com.example.controller;

import com.example.model.Employee;
import com.example.service.IEmployeeService;
import com.example.service.impl.EmployeeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Created by ozgen on 06.04.2017.
 */
@RestController
@RequestMapping("/emp")
public class EmployeeRestController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private IEmployeeService employeeService;

    public EmployeeRestController(EmployeeService EmployeeService) {

        this.employeeService = EmployeeService;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ResponseEntity<Iterable<Employee>> employees() {
        Iterable<Employee> employees = this.employeeService.findAll();
        return new ResponseEntity < Iterable < Employee >> (employees,HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> getEmployee(@PathVariable("id") long id) {
        logger.info("Fetching User with id {}", id);
        Employee employee = employeeService.findById(id);
        if (employee == null) {
            logger.error("User with id {} not found.", id);
            return new ResponseEntity( HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Employee>(employee, HttpStatus.OK);
    }



    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public ResponseEntity<Employee> save(@RequestBody Employee employee) {
        this.employeeService.save(employee);
        return new ResponseEntity<Employee>(employee, HttpStatus.OK);
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public ResponseEntity<Employee> update(@RequestBody Employee employee) {
        this.employeeService.update(employee);
        return new ResponseEntity<Employee>(employee, HttpStatus.OK);
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public String delete(@PathVariable("id") Long id) {
        Employee employee = this.employeeService.findById(id);
        boolean wasOk = this.employeeService.remove(employee.getId());
        if (wasOk) {
            return "redirect:/findAll";
        }
        return "redirect:/fail";
    }
}
