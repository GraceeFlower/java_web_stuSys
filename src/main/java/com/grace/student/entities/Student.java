package com.grace.student.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table("student")
public class Student {

    @Id
    private int id;
    @Column("sname")
    private String name;
    private String gender;
    @Column("class")
    private String classNum;

    public Student() {
    }

    public Student(int id, String name, String gender, String classNum) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.classNum = classNum;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getClassNum() {
        return classNum;
    }

    public void setClassNum(String classNum) {
        this.classNum = classNum;
    }
}
