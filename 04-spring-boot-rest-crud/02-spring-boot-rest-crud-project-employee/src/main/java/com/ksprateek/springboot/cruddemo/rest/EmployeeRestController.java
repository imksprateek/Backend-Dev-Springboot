package com.ksprateek.springboot.cruddemo.rest;

import com.ksprateek.springboot.cruddemo.dao.EmployeeDAO;
import com.ksprateek.springboot.cruddemo.entity.Employee;
import com.ksprateek.springboot.cruddemo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {
    private EmployeeService employeeService;
    //Inject employee DAO using constructor injection

    @Autowired
    public EmployeeRestController(EmployeeService theEmployeeService) {
        this.employeeService = theEmployeeService;
    }


    //expose "/employees" endpoint and reutrn a list of employees
    @GetMapping("/employees")
    public List<Employee> findAll(){
        return employeeService.getAllEmployees();
    }



}
