package com.ksprateek.springboot.cruddemo.dao;

import com.ksprateek.springboot.cruddemo.entity.Employee;

import java.util.List;

public interface EmployeeDAO {
    List<Employee> getAllEmployees();
}
