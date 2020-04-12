package com.grace.student.controllers;

import com.grace.student.entities.Student;
import com.grace.student.exceptions.AlreadyExistException;
import com.grace.student.exceptions.NullOfStudentException;
import com.grace.student.repositories.StudentRepository;
import com.grace.student.services.StudentService;
import org.springframework.web.bind.annotation.*;

@RestController
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/system/{name}")
    public Student getStudent(@PathVariable String name) {
        return studentService.getStudent(name);
    }

    @GetMapping("/system/all")
    public Iterable<Student> getStudents() {
        return studentService.getStudents();
    }

    @PostMapping("system/add")
    public String saveStudent(@RequestBody Student stu) {
        return studentService.saveStudent(stu);
    }

    @DeleteMapping("system/remove/{name}")
    public String deleteStudent(@PathVariable String name) {
        return studentService.deleteStudent(name);
    }
}
