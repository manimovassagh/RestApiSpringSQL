package com.github.manimovassagh.RestAPISpring.dao;

import com.github.manimovassagh.RestAPISpring.entity.Employee;

import java.util.List;

public interface EmployeeDAO {
     List<Employee> findAll();
     Employee findById(int theId);
     void save(Employee theEmployee);
     void deleteById(int theId);

}
