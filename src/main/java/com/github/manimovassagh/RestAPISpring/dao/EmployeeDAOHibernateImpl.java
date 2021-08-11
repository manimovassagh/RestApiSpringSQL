package com.github.manimovassagh.RestAPISpring.dao;

import com.github.manimovassagh.RestAPISpring.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDAOHibernateImpl implements EmployeeDAO {

    @Override
    public List<Employee> findAll() {
        return null;
    }

    @Autowired
    public EmployeeDAOHibernateImpl() {
    }
}
