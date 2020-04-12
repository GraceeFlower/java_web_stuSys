package com.grace.student.services;

import com.grace.student.entities.Student;
import com.grace.student.exceptions.AlreadyExistException;
import com.grace.student.exceptions.NullOfStudentException;
import com.grace.student.repositories.StudentRepository;
import com.grace.student.repositories.StudentRepositoryI;

import java.util.List;

public class StudentService implements StudentServiceI {

    private StudentRepositoryI studentRepository = new StudentRepository();

    @Override
    public String saveStudent(Student stu) {
        if (studentRepository.saveStudent(stu)) {
            throw new AlreadyExistException("姓名重复");
        }
        return "添加成功";
    }

    @Override
    public List<Student> getStuList() {
        return studentRepository.getStuList();
    }

    @Override
    public Student getSingleStudent(String name) {
        Student stu = studentRepository.getSingleStudent(name);
        if (null == stu) {
            throw new NullOfStudentException("该学生不存在");
        }
        return stu;
    }

    @Override
    public String deleteStudent(String name) {
        if (!studentRepository.deleteStudent(name)) {
            throw new NullOfStudentException("该学生不存在");
        }
        return "删除成功";
    }
}
