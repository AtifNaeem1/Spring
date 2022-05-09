package com.zemoso.SpringDemo.service;

import com.zemoso.SpringDemo.entity.Course;

import java.util.List;

public interface CourseService {

    public List<Course> findAll();

    public Course findById(int theId);

    public Course save(Course theCourses);

    public boolean deleteById(int theId);
}
