package com.prateek.cruddemo.dao;

import com.prateek.cruddemo.entity.Student;

public interface StudentDAO {
    void save(Student theStudent);

    Student findById(Integer id);
}
