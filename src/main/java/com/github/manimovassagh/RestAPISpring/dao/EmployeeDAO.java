package com.github.manimovassagh.RestAPISpring.dao;

import com.github.manimovassagh.RestAPISpring.entity.Employee;

import java.util.List;

public interface EmployeeDAO {
    public List<Employee> findAll();
}
