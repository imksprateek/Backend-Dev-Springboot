package com.ksprateek.demo.rest;

import com.ksprateek.demo.entity.Student;
import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {

    private List<Student> theStudents;

    //This approach is better because it will only load the data once. @PostConstruct is used to initialize attributes after construction of bean
    @PostConstruct
    public void loadData(){
        theStudents = new ArrayList<>();

        theStudents.add(new Student("Prateek", "Bhat"));
        theStudents.add(new Student("John", "Snow"));
        theStudents.add(new Student("Maestro", "Max"));

    }

    @GetMapping("/students")
    public List<Student> getStudents(){
        return theStudents;
    }

    @GetMapping("/students/{studentId}")
    public Student getStudentById(@PathVariable int studentId){
        //Just index into the list... Keep it simple for now


        //Check the studentId against list size
        if((studentId>=theStudents.size()) || (studentId<0)){
            //Throw an exception
            throw new StudentNotFoundException("Student id is not found - " + studentId);
        }
        return theStudents.get(studentId);
    }
}
