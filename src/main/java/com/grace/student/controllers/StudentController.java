package com.grace.student.controllers;

import com.grace.student.entities.Student;
import com.grace.student.services.StudentService;
import com.grace.student.services.StudentServiceI;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("system/{name}")
    public Student getSingleStudent( @PathVariable String name) {
        return studentService.getSingleStudent(name);
    }

    @DeleteMapping("system/remove/{name}")
    public String deleteStudent(@PathVariable String name) {
        return studentService.deleteStudent(name);
    }
}
