package com.grace.student.repositories;

import com.grace.student.entities.Student;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StudentRepository implements StudentRepositoryI {

    private List<Student> stuList = new ArrayList<>(Arrays.asList(
        new Student("jack", "male", "1-10"),
        new Student("grace", "female", "2-10"),
        new Student("edward", "male", "2-10"))
    );

    @Override
    public boolean saveStudent(Student stu) {
        boolean isExist = stuList.stream()
            .map(Student::getName)
            .anyMatch(item -> item.equals(stu.getName()));
        if (!isExist) {
            stuList.add(stu);
        }
        return isExist;
    }

}
