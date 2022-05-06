package com.zemoso.SpringDemo.service;

import com.zemoso.SpringDemo.entity.Course;

import java.util.List;

public interface CourseService {

    public List<Course> findAll();

    public Course findById(int theId);

    public void save(Course theCourses);

    public void deleteById(int theId);
}
