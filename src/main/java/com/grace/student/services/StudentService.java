package com.grace.student.services;

import com.grace.student.entities.Student;
import com.grace.student.exceptions.AlreadyExistException;
import com.grace.student.exceptions.NullOfStudentException;
import com.grace.student.repositories.StudentRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public Student getStudent(String name) {
        Student stu = studentRepository.findByName(name);
        if (null == stu) {
            throw new NullOfStudentException("该学生不存在");
        }
        return stu;
    }

    public Iterable<Student> getStudents() {
        return studentRepository.findAll();
    }

    public String saveStudent(Student stu) {
        if (null != studentRepository.findByName(stu.getName())) {
            throw new AlreadyExistException("该学生已存在");
        }
        studentRepository.save(stu);
        return "添加成功";
    }

    public String deleteStudent(String name) {
        Student stu = studentRepository.findByName(name);
        if (null == stu) {
            throw new NullOfStudentException("该学生不存在");
        }
        studentRepository.delete(stu);
        return "删除成功";
    }

}
