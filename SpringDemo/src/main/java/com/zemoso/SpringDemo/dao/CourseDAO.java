package com.zemoso.SpringDemo.dao;


import com.zemoso.SpringDemo.entity.Course;
        import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseDAO extends JpaRepository <Course, Integer> {
    //that's it .. no need to write any code
}