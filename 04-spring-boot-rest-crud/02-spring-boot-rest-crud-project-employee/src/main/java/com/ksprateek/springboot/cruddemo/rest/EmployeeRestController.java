package com.ksprateek.springboot.cruddemo.rest;

import com.ksprateek.springboot.cruddemo.dao.EmployeeDAO;
import com.ksprateek.springboot.cruddemo.entity.Employee;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {
    private EmployeeDAO employeeDAO;

    //Inject employee DAO using constructor injection
    public EmployeeRestController(EmployeeDAO employeeDAO) {
        this.employeeDAO = employeeDAO;
    }


    //expose "/employees" endpoint and reutrn a list of employees
    @GetMapping("/employees")
    public List<Employee> findAll(){
        return employeeDAO.getAllEmployees();
    }
}
