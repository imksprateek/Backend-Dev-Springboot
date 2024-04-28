package com.ksprateek.springboot.cruddemo.dao;

import com.ksprateek.springboot.cruddemo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

//Syntax: JpaRepository<EntityType, PrimaryKey>
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    //That's it.. No need to write any code here.
    //When we use spring data jpa, there's no need for DAO and its implementations. All the CRUD methods come with JpaRepository
}
