package com.zemoso.SpringDemo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="student_course")
public class StudentCourse {

    @Id
    @Column(name="course_id")
    public int courseId;

//    @Id
    @Column(name="student_id")
    public int studentId;

    public StudentCourse(){

    }

    public StudentCourse(int courseId, int studentId) {
        this.courseId = courseId;
        this.studentId = studentId;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }
}
