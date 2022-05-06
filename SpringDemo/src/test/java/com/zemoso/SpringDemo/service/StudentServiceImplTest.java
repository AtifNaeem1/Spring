package com.zemoso.SpringDemo.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertFalse;
import com.zemoso.SpringDemo.dao.StudentDAO;
import com.zemoso.SpringDemo.entity.Student;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
class StudentServiceImplTest {

    @Autowired
    private StudentService studentService;

    @MockBean
    private StudentDAO studentDAO;


    @Test
    void findAll() {
        Student student1 =  new Student("Jhon","Doe","jdoe@gmail.com");
        Student student2 =  new Student("Alan","Turing","alan@gmail.com");
        student1.setId(100);
        student2.setId(101);

        List<Student> studentList = new ArrayList<>();
        studentList.add(student1);
        studentList.add(student2);

        Mockito.when(studentDAO.findAll()).thenReturn((studentList));
        assertThat(studentService.findAll()).isEqualTo(studentList);

    }

    @Test
    void findById() {
        Student student = getStudent();
        student.setId(100);

        Mockito.when(studentDAO.findById(100)).thenReturn(Optional.of(student));
        assertThat(studentService.findById(100)).isEqualTo(student);
    }

    @Test
    void save() {
        Student student = getStudent();

        Mockito.when(studentDAO.save(student)).thenReturn(student);
        assertThat(studentService.save(student)).isEqualTo(student);

    }

    @Test
    void deleteById() {
        Student student = getStudent();
        student.setId(100);
        int id=student.getId();

        assertFalse(studentService.deleteById(student.getId()));
    }

    public Student getStudent()
    {
        Student student =  new Student("Jhon","Doe","jdoe@gmail.com");
        return student;
    }
}