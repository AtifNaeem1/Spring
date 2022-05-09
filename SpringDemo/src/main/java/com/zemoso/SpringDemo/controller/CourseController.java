package com.zemoso.SpringDemo.controller;


import com.zemoso.SpringDemo.entity.Course;
import com.zemoso.SpringDemo.entity.Student;
import com.zemoso.SpringDemo.service.CourseService;
import com.zemoso.SpringDemo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/course")
public class CourseController {

    @Autowired
    private CourseService courseService;

    @Autowired
    private StudentService studentService;


    @GetMapping("/list")
    public String listCourses(Model theModel)
    {

        List<Course> theCourses = courseService.findAll();

        //add to the spring model
        theModel.addAttribute("courses", theCourses);

        return "list-courses";
    }

    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model theModel)
    {
        List<Student> studentList = studentService.findAll();
        //create model attribute to bind data
        Course course = new Course();

        theModel.addAttribute("studentList",studentList);
        theModel.addAttribute("course",course);

        return "course-form";
    }

    @PostMapping("/save")
    public String saveStudent(@ModelAttribute("course") Course theCourse)
    {

        courseService.save(theCourse);

        return "redirect:/course/list";
    }


    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("courseId") int theId,
                                    Model theModel) {
        Course theCourse = courseService.findById(theId);
        List<Student> studentList = studentService.findAll();


        theModel.addAttribute("studentList", studentList);
        theModel.addAttribute("course",theCourse);

        //send over to our form
        return "course-form";

    }

    @GetMapping("/delete")
    public String delete(@RequestParam("courseId") int theId)
    {

        courseService.deleteById(theId);

        return "redirect:/course/list";
    }
}
