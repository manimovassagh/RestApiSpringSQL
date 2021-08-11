package com.github.manimovassagh.RestAPISpring.rest;


import com.github.manimovassagh.RestAPISpring.dao.EmployeeDAO;
import com.github.manimovassagh.RestAPISpring.entity.Employee;
import com.github.manimovassagh.RestAPISpring.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

    private EmployeeService employeeService;

    @Autowired
    public EmployeeRestController(EmployeeService theEmployeeService) {
        this.employeeService = theEmployeeService;
    }

    @GetMapping("/employees")
    public List<Employee> findAll() {
        return employeeService.findAll();
    }

    @GetMapping("/employees/{id}")
    public Employee findById(@PathVariable int id) {
        Employee theEmployee = employeeService.findById(id);
        if (theEmployee == null) {
            throw new RuntimeException("The Given Employee With id Number " + id + " Not Exist !");
        }
        return theEmployee;
    }

    @PostMapping("/employees")
    public void addEmployee(Employee employee) {
        employeeService.save(employee);
    }


}
