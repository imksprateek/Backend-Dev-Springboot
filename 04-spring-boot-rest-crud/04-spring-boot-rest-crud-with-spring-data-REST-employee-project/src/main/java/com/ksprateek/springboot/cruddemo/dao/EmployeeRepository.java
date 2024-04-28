package com.ksprateek.springboot.cruddemo.dao;

import com.ksprateek.springboot.cruddemo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

//Syntax: JpaRepository<EntityType, PrimaryKey>
@RepositoryRestResource(path = "members")
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    //That's it.. No need to write any code here.
    //When we use spring data jpa, there's no need for DAO and its implementations. All the CRUD methods come with JpaRepository

    //Upon using Spring Data REST, the default path to access Employee entity becomes /employees
//    Spring Data REST adds "s" at the end of entity name for the path by default. It can be changed via configuration. For this we use @RepositoryRestResource annotation to repository and specify the desired path (Configuration).

/*
    By default, spring only gives 20 elements at once in a response page (page size = 20). This is page 1. To navigate different pages, we can use http://localhost:8080/employees?page=1 , http://localhost:8080/employees?page=2 , etc.
    The first page is http://localhost:8080/employees?page=0
    To display pages in sizes of 3: http://localhost:8080/employees?page=1&size=3
 */

//    We can also sort the response (Sorting)
    /*
    To sort by last name(ascending is default): http://localhost:8080/employees?sort=lastName
    To sort by first name(descending): http://localhost:8080/employees?sort=firstName,desc

    To customize the order of responses: http://localhost:8080/employees?sort=lastName,firstName,asc
     */
}
