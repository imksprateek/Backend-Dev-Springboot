package com.ksprateek.springboot.cruddemo.service;

import com.ksprateek.springboot.cruddemo.entity.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> getAllEmployees();
}
