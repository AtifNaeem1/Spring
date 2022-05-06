package com.zemoso.SpringDemo.controller;

import com.zemoso.SpringDemo.dao.CourseDAO;
import com.zemoso.SpringDemo.entity.Course;
import com.zemoso.SpringDemo.entity.Student;
import com.zemoso.SpringDemo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/student")
public class StudentController {
    private StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @Autowired
    private CourseDAO courseDao;

    @GetMapping("/list")
    public String listStudents(Model theModel)
    {
        //get student from db
        List<Student> theStudents = studentService.findAll();

        //add to the spring model
        theModel.addAttribute("students", theStudents);

        return "list-students";
    }

    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model theModel)
    {
        List<Course> courseList = courseDao.findAll();
        //create model attribute to bind data
        Student student = new Student();

        theModel.addAttribute("courseList",courseList);
        theModel.addAttribute("student",student);

        return "student-form";
    }

    @PostMapping("/save")
    public String saveStudent(@ModelAttribute("student") Student theStudent)
    {
        //theStudent.setId(0);
        studentService.save(theStudent);

        return "redirect:/student/list";
    }
    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("studentId") int theId,
                                    Model theModel)
    {

        Student theStudent = studentService.findById(theId);
        List<Course> courseList = courseDao.findAll();


        theModel.addAttribute("student", theStudent);
        theModel.addAttribute("courseList",courseList);

        //send over to our form
        return "student-form";

    }

    @GetMapping("/delete")
    public String delete(@RequestParam("studentId") int theId)
    {
        //delete the student
        studentService.deleteById(theId);

        //redirect to student
        return "redirect:/student/list";
    }

}
