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

    @GetMapping("/employees/{employeeId}")
    public Employee getEmployee(@PathVariable int employeeId){
        Employee theEmployee = employeeService.findById(employeeId);

        if(theEmployee == null){
            throw new RuntimeException("Employee id not found - " + employeeId);
        }
        return theEmployee;
    }

//    Add mapping for POST /employees - add new employees
    @PostMapping("/employees")
    public Employee addEmployee(@RequestBody Employee theEmployee){
        //Also just in case they pass an id in json.. Set id to 0
        //This is to force a save of a new item instead of an update
        theEmployee.setId(0);

        Employee dbEmployee = employeeService.save(theEmployee);
        return dbEmployee;
    }

    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee theEmployee){
        //Id is not set to 0 here. So the merge call from EmployeeServiceImpl updates the data instead of insert
        Employee dbEmployee = employeeService.save(theEmployee);

        return dbEmployee;
    }

    @DeleteMapping("/employees/{employeeId}")
    public String deleteEmployee(@PathVariable int employeeId){
        Employee theEmployee = employeeService.findById(employeeId);

        if (theEmployee == null){
            throw new RuntimeException("Employee id not found - " + employeeId);
        }

        employeeService.deleteById(employeeId);

        return "Deleted employee id - " + employeeId;
    }
}
