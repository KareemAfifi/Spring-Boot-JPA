package com.example.JPA_Section.dao;

import com.example.JPA_Section.entity.Student;

import java.util.List;

public interface StudentDAO {
    void save(Student s) ;
    Student findById(Integer id);

    List<Student> findAll();
    List<Student> findByLastName(String lastname);
    void update(Student student) ;
    void delete(Integer id );

    int deleteAll() ;

}
