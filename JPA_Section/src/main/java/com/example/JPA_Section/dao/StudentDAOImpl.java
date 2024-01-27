package com.example.JPA_Section.dao;

import com.example.JPA_Section.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class StudentDAOImpl implements StudentDAO{
    private EntityManager entityManager ;

    @Autowired
    public StudentDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public void save(Student s) {
        entityManager.persist((s));

    }

    @Override
    public Student findById(Integer id) {
        return entityManager.find(Student.class, id);
    }

    @Override
    public List<Student> findAll() {
        TypedQuery<Student> thequery  = entityManager.createQuery("From Student ", Student.class);
        List<Student> students= thequery.getResultList();
        return students;
    }

    @Override
    public List<Student> findByLastName(String lastname) {
        TypedQuery<Student> thequery = entityManager.createQuery("From Student where lastName=:name", Student.class);
        thequery.setParameter("name",lastname );
        return thequery.getResultList();
    }

    @Override
    @Transactional
    public void update(Student student) {
        entityManager.merge(student);


    }

    @Override
    @Transactional
    public void delete(Integer id) {
        Student s = entityManager.find(Student.class, id);
        entityManager.remove(s);
    }

    @Override
    public int deleteAll() {
        int nums = entityManager.createQuery("DELETE from Student", Student.class).executeUpdate();
        return nums;
    }
}
