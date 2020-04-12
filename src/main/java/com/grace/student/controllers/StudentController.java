package com.grace.student.controllers;

import com.grace.student.entities.Student;
import com.grace.student.exceptions.AlreadyExistException;
import com.grace.student.exceptions.NullOfStudentException;
import com.grace.student.repositories.StudentRepository;
import org.springframework.web.bind.annotation.*;

@RestController
public class StudentController {

    private final StudentRepository studentRepository;

    public StudentController(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @GetMapping("/system/{name}")
    public Student getStudent(@PathVariable String name) {
        Student stu = studentRepository.findByName(name);
        if (null == stu) {
            throw new NullOfStudentException("该学生不存在");
        }
        return stu;
    }

    @GetMapping("/system/all")
    public Iterable<Student> getStudents() {
        return studentRepository.findAll();
    }

    @PostMapping("system/add")
    public String saveStudent(@RequestBody Student stu) {
        if (null != studentRepository.findByName(stu.getName())) {
            throw new AlreadyExistException("该学生已存在");
        }
        studentRepository.save(stu);
        return "添加成功";
    }

    @DeleteMapping("system/remove/{name}")
    public String deleteStudent(@PathVariable String name) {
        Student stu = studentRepository.findByName(name);
        if (null == stu) {
            throw new NullOfStudentException("该学生不存在");
        }
        studentRepository.delete(stu);
        return "删除成功";
    }
}
