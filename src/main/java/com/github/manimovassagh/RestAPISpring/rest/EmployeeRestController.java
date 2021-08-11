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


    private  EmployeeService employeeService;

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
    public Employee addEmployee(@RequestBody Employee theEmployee) {

        theEmployee.setId(0);
        employeeService.save(theEmployee);
        return theEmployee;
    }


    @DeleteMapping("/employees/{id}")
    public String deleteEmployeeById(@PathVariable int id){
        Employee foundEmployee = employeeService.findById(id);
        if (foundEmployee==null){
            throw new RuntimeException("Id Number " + id + " Not Exist");
        }
        employeeService.deleteById(id);
        return "Deleted employee id - " + id;

    }

    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee theEmployee){
        employeeService.save(theEmployee);
        return theEmployee;

    }


}
