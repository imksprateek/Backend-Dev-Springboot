package com.ksprateek.springboot.cruddemo.dao;

import com.ksprateek.springboot.cruddemo.dao.EmployeeDAO;
import com.ksprateek.springboot.cruddemo.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDAOimpl implements EmployeeDAO {
    //Define field for entityManager
    private EntityManager entityManager;

    //Set up constructor injection
    public EmployeeDAOimpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Employee> getAllEmployees() {
        //Create a query
        TypedQuery<Employee> theQuery = entityManager.createQuery("from Employee ", Employee.class);

        //Execute query and get result list
        List<Employee> employees = theQuery.getResultList();

        //return the results
        return employees;
    }
}
