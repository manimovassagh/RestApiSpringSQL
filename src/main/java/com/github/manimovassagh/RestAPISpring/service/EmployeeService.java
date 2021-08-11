package com.github.manimovassagh.RestAPISpring.service;

import com.github.manimovassagh.RestAPISpring.entity.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> findAll();
    Employee findById(int theId);
    void save(Employee employee);
    void deleteById(int theId);


}
