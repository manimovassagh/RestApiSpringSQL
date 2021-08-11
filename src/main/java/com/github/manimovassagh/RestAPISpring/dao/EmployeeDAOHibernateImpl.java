package com.github.manimovassagh.RestAPISpring.dao;

import com.github.manimovassagh.RestAPISpring.entity.Employee;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class EmployeeDAOHibernateImpl implements EmployeeDAO {

    private EntityManager entityManager;

    @Autowired
    public EmployeeDAOHibernateImpl(EntityManager theEntityManager) {
        entityManager = theEntityManager;
    }

    @Override
    public List<Employee> findAll() {
        Session currentSession = entityManager.unwrap(Session.class);
        //create a query
        Query<Employee> theQuery =
                currentSession.createQuery("From Employee", Employee.class);
        List<Employee> employees = theQuery.getResultList();
        return employees;
    }


    @Override
    public Employee findById(int theId) {
        Session currentSession = entityManager.unwrap(Session.class);
        //get the employee
        Employee theEmployee = currentSession.get(Employee.class, theId);
        return theEmployee;
    }

    @Override
    public void save(Employee theEmployee) {
        Session currentSession = entityManager.unwrap(Session.class);
        currentSession.saveOrUpdate(theEmployee);


    }

    @Override
    public void deleteById(int theId) {
        Session currentSession = entityManager.unwrap(Session.class);
        Query<Employee> theQuery = currentSession.createQuery("DELETE From Employee WHERE id=:employee", Employee.class);
        theQuery.setParameter("employeeId", theId);
        theQuery.executeUpdate();
    }


}
