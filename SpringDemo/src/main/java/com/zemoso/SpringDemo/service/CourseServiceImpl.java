package com.zemoso.SpringDemo.service;

import com.zemoso.SpringDemo.dao.CourseDAO;
import com.zemoso.SpringDemo.entity.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseServiceImpl implements CourseService{

    @Autowired
    private CourseDAO courseDao;

    @Override
    public List<Course> findAll() {
        return courseDao.findAll();
    }

    @Override
    public Course findById(int theId){
        Optional<Course> result = courseDao.findById(theId);

        Course theCourse = null;
        if(result.isPresent())
        {
            theCourse= result.get();
        }
        return theCourse;
    }

    @Override
    public Course save(Course theCourses) {
        courseDao.save(theCourses);
        return theCourses;
    }

    @Override
    public boolean deleteById(int theId) {
        courseDao.deleteById(theId);
        return false;
    }
}
