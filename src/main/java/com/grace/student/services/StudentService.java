package com.grace.student.services;

import com.grace.student.entities.Student;
import com.grace.student.repositories.StudentRepository;
import com.grace.student.repositories.StudentRepositoryI;

import java.util.List;

public class StudentService implements StudentServiceI {

    private StudentRepositoryI studentRepository = new StudentRepository();

    @Override
    public String saveStudent(Student stu) {
        return studentRepository.saveStudent(stu) ? "姓名重复" : "添加成功";
    }

    @Override
    public List<Student> getStuList() {
        return studentRepository.getStuList();
    }
}
