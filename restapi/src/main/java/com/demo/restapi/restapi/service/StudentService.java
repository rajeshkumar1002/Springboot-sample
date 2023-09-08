package com.demo.restapi.restapi.service;

import com.demo.restapi.restapi.entity.Student;

import java.util.List;

public interface StudentService {

    List<Student> getAllStudents();
    Student getStudentById(Long id);
    Student createStudent(Student student);
    Student updateStudent(Long id, Student student);
    void deleteStudent(Long id);
}
