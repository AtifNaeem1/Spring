package com.zemoso.SpringDemo.dao;

import com.zemoso.SpringDemo.entity.Course;
import com.zemoso.SpringDemo.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentDAO extends JpaRepository<Student, Integer> {
    //that's it .. no need to write any code
}
