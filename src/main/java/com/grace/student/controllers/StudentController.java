package com.grace.student.controllers;

import com.grace.student.entities.Student;
import com.grace.student.services.StudentService;
import com.grace.student.services.StudentServiceI;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StudentController {

    private StudentServiceI studentService = new StudentService();

    @PostMapping("system/add")
    public String saveStudent(@RequestBody Student stu) {
        return studentService.saveStudent(stu);
    }

    @GetMapping("system/all")
    public List<Student> getStuList() {
        return studentService.getStuList();
    }


}
