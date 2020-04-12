package com.grace.student.repositories;

import com.grace.student.entities.Student;

import java.util.List;

public interface StudentRepositoryI {
    boolean saveStudent(Student stu);
    List<Student> getStuList();
    Student getSingleStudent(String name);
    boolean deleteStudent(String name);
}
