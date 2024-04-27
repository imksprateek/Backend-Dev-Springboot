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

    @Override
    public Employee findById(int theId) {
//        Get employee
        Employee theEmployee = entityManager.find(Employee.class, theId);
//        return employee
        return theEmployee;
    }

//    We don't use @Transactional at the DAO layer since it will be handled at the Service layer.
    @Override
    public Employee save(Employee theEmployee) {
//        Save employee
        Employee dbEmployee = entityManager.merge(theEmployee);
//What merge does is, If id == 0 then it performs an insert/save, else update.

//        Return dbEmployee
        return dbEmployee;
//        The returned dbEmployee has updated id from the database
    }

    @Override
    public void deleteById(int theId) {
        //find employee by id
        Employee theEmployee = entityManager.find(Employee.class, theId);

        //remove employee
        entityManager.remove(theEmployee);
    }
}
