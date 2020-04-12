package com.grace.student.repositories;

import com.grace.student.entities.Student;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface StudentRepository extends CrudRepository<Student, Integer> {

    @Query("SELECT id, sname, gender, class FROM student WHERE sname = :sname")
    Student findByName(@Param("sname") String name);
}
