package com.prateek.cruddemo.dao;

import com.prateek.cruddemo.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

//@Repository annotation provides support for component scanning and Translates JDBC exceptions.
@Repository
public class StudentDAOImpl implements StudentDAO{

    //Define field for entity manager
    private EntityManager entityManager;

    //Inject entity manager using constructor injection
    @Autowired
    public StudentDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    //Implement save method
    //Add @Transactional annotation since we are performing an update on database
    @Override
    @Transactional
    public void save(Student theStudent) {
        entityManager.persist(theStudent);
    }

    @Override
    public Student findById(Integer id) {
        //Here, there's no need for @Transactional annotation since we're doing a query, that is read only and not an update on the database. If not found, it returns null
        //Student.class is the entity class and id is the primary key
        return entityManager.find(Student.class, id);
    }
}
