package com.prateek.cruddemo.dao;

import com.prateek.cruddemo.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

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

    @Override
    public List<Student> findAll() {
        //Create query
        //Remember that all JPQL queries are based on Entity names and Entity fields and NOT the name of database table or database column
        //When "FROM Student order by lastname" is used, it sorts the results in ascending order by default
        //For descending order use "FROM Student order by lastname desc" or for ascending use "FROM Student order by lastname asc"
        //We can also use OR AND LIKE predicates for more specific query.
        //"FROM Student WHERE lastname='Doe' OR firstname='John'" - This gives all students whose either the firstname is John or lastname is Doe
        //"FROM Student WHERE lastname='Doe' AND firstname='John'" - This gives all students whose first name and last name are John and Doe respectively.
        //"FROM Student WHERE lastname='Doe' AND email LIKE '%@gmail.com'"  - This gives all students that have emails with @gmail.com in the end
        TypedQuery<Student> theQuery = entityManager.createQuery("FROM Student", Student.class);

        //return query results
        return theQuery.getResultList();
    }

    @Override
    public List<Student> findByLastName(String LastName) {
        //Create Query
        //JPQL named parameters are prefixed with a colon :
        //Think of parameters as a placeholder that is filled in later.
        TypedQuery<Student> theQuery = entityManager.createQuery("FROM Student WHERE lastname=:theParameter", Student.class);
        theQuery.setParameter("theParameter", LastName);

        //Return results
        return theQuery.getResultList();
    }
}
