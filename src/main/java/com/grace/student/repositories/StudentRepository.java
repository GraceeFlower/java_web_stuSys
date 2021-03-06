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

    @Override
    public List<Student> getStuList() {
        return stuList;
    }

    @Override
    public Student getSingleStudent(String name) {
        return stuList.stream().filter(item -> item.getName().equals(name)).findAny().orElse(null);
    }

    @Override
    public boolean deleteStudent(String name) {
        if (null == getSingleStudent(name)) {
            return false;
        } else {
            stuList.removeIf(item -> item.getName().equals(name));
        }
        return true;
    }

}
