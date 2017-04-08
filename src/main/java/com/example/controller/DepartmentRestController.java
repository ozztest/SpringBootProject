package com.example.controller;

import com.example.model.Department;
import com.example.service.IDepartmentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Created by ozgen on 08.04.2017.
 */
@RestController
@RequestMapping("/dept")
public class DepartmentRestController {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private IDepartmentService departmentService;

    public DepartmentRestController(IDepartmentService departmentService) {
        this.departmentService = departmentService;
    }


    @RequestMapping(value = "/findOne/{id}", method = RequestMethod.GET)
    public Department findById(@PathVariable("id") Long id) {
        logger.info("Fetching department wit id:{}", id);
        return this.departmentService.findById(id);
    }


    @RequestMapping(value = "/findAll", method = RequestMethod.GET)
    public ResponseEntity<Iterable<Department>> departments() {
        logger.info("Fetching all departments");
        Iterable<Department> departments = departmentService.findAll();
        return new ResponseEntity<Iterable<Department>> (departments,HttpStatus.OK);
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public ResponseEntity<Department> save(@RequestBody Department department) {
        this.departmentService.save(department);
        return new ResponseEntity<Department>(department, HttpStatus.OK);
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public ResponseEntity<Department> update(@RequestBody Department department) {
        this.departmentService.update(department);
        return new ResponseEntity<Department>(department, HttpStatus.OK);
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public String delete(@PathVariable("id") Long id) {
        Department department = this.departmentService.findById(id);
        boolean wasOk = this.departmentService.remove(department.getId());
        if (wasOk) {
            return "redirect:/findAll";
        }
        return "redirect:/fail";
    }


}
