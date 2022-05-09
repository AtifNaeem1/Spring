package com.zemoso.SpringDemo.service;

import com.zemoso.SpringDemo.dao.StudentDAO;
import com.zemoso.SpringDemo.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService{

    @Autowired
    private StudentDAO studentDAO;


    @Override
    public List<Student> findAll() {
        return studentDAO.findAll();
    }

    @Override
    public Student findById(int theId) {
        Optional<Student> result = studentDAO.findById(theId);

        Student theStudent= null;
        if(result.isPresent())
        {
            theStudent= result.get();
        }
        return theStudent;
    }

    @Override
    public Student save(Student theStudent) {
            studentDAO.save(theStudent);
        return theStudent;
    }

    @Override
    public boolean deleteById(int theId) {
        studentDAO.deleteById(theId);
        return false;
    }
}
