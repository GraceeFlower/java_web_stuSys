package com.grace.student.controllers;

import com.grace.student.entities.Student;
import com.grace.student.services.StudentService;
import com.grace.student.services.StudentServiceI;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {

    private StudentServiceI studentService = new StudentService();

    @PostMapping("system/add")
    public String saveStudent(@RequestBody Student stu) {
        return studentService.saveStudent(stu);
    }


}
