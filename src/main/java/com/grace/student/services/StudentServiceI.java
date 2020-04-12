package com.grace.student.services;

import com.grace.student.entities.Student;

import java.util.List;

public interface StudentServiceI {

    String saveStudent(Student stu);
    List<Student> getStuList();
    Student getSingleStudent(String name);
    String deleteStudent(String name);
}
