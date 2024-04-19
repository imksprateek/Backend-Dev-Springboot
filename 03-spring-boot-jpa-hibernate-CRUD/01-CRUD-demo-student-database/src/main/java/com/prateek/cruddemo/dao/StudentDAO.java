package com.prateek.cruddemo.dao;

import com.prateek.cruddemo.entity.Student;

import java.util.List;

public interface StudentDAO {
    void save(Student theStudent);

    Student findById(Integer id);

    List<Student> findAll();

    List<Student> findByLastName(String LastName);

    void update(Student theStudent);

    void delete(int target_id);

    int deleteAll();
}
