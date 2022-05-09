package com.zemoso.SpringDemo.service;

import com.zemoso.SpringDemo.dao.CourseDAO;
import com.zemoso.SpringDemo.entity.Course;
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

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertFalse;

@RunWith(SpringRunner.class)
@SpringBootTest
class CourseServiceImplTest {
    @Autowired
    private CourseService courseService;

    @MockBean
    private CourseDAO courseDAO;


    @Test
    void findAll() {
        Course course1= new Course("Marathi");
        Course course2 = new Course("German");
        course1.setId(100);
        course2.setId(101);

        List<Course> courseList = new ArrayList<>();
       courseList.add(course1);
        courseList.add(course2);

        Mockito.when(courseDAO.findAll()).thenReturn((courseList));
        assertThat(courseService.findAll()).isEqualTo(courseList);

    }

    @Test
    void findById() {
        Course course = getCourse();
        course.setId(100);

        Mockito.when(courseDAO.findById(100)).thenReturn(Optional.of(course));
        assertThat(courseService.findById(100)).isEqualTo(course);
    }

    @Test
    void save() {
        Course course = getCourse();

        Mockito.when(courseDAO.save(course)).thenReturn(course);
        assertThat(courseService.save(course)).isEqualTo(course);

    }

    @Test
    void deleteById() {
        Course course = getCourse();
        course.setId(100);
        int id=course.getId();

        assertFalse(courseService.deleteById(course.getId()));
    }

    public Course getCourse()
    {
        Course course = new Course("Economics");
        return course;
    }

}