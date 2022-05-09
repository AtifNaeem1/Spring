package com.zemoso.SpringDemo.service;

import com.zemoso.SpringDemo.entity.Student;

import java.util.List;

public interface StudentService {

    public List<Student> findAll();

    public Student findById(int theId);

    public Student save(Student theStudent);

    public boolean deleteById(int theId);
}

