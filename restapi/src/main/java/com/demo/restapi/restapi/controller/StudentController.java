package com.demo.restapi.restapi.controller;

import com.demo.restapi.restapi.entity.Student;
import com.demo.restapi.restapi.service.StudentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentController {
    @Autowired
    StudentServiceImpl studentService;

    @GetMapping
    public List<Student> students(){
        return studentService.getAllStudents();
    }

    @PostMapping
    public  Student createStudent(@RequestBody Student student){
        return studentService.createStudent(student);
    }

    @GetMapping("/{id}")
    public Student getStudentById(@PathVariable("id") Long id){
        return studentService.getStudentById(id);
    }

    @PutMapping("/{id}")
    public Student updateStudent(@PathVariable("id") Long id, @RequestBody Student student){
        return studentService.updateStudent(id, student);
    }

    @DeleteMapping("/{id}")
    public void deleteStudent(@PathVariable("id") Long id){
        studentService.deleteStudent(id);
    }
}
