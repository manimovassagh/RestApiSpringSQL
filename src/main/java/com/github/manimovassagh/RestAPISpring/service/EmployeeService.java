package com.github.manimovassagh.RestAPISpring.service;

import com.github.manimovassagh.RestAPISpring.entity.Employee;

import java.util.List;

public interface EmployeeService {
    public List<Employee> findAll();

    public Employee findById(int theId);

    public void save(Employee employee);

    public void deleteById(int theId);


}
