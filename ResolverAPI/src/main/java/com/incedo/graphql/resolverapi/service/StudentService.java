package com.incedo.graphql.resolverapi.service;

import com.incedo.graphql.resolverapi.entity.Address;
import com.incedo.graphql.resolverapi.entity.Student;
import com.incedo.graphql.resolverapi.entity.Subject;
import com.incedo.graphql.resolverapi.repository.AddressRepository;
import com.incedo.graphql.resolverapi.repository.StudentRepository;
import com.incedo.graphql.resolverapi.repository.SubjectRepository;
import com.incedo.graphql.resolverapi.request.CreateStudentRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService {

    @Autowired
    StudentRepository studentRepository;

    @Autowired
    SubjectRepository subjectRepository;

    @Autowired
    AddressRepository addressRepository;

    public Student getStudentById(Long id){
        return studentRepository.findById(id).orElseThrow(()-> new RuntimeException("Not found"));
    }

    public Student createStudent(CreateStudentRequest createStudentRequest){
        Student student = new Student(createStudentRequest);

        Address address = new Address();
        address.setCity(createStudentRequest.getCity());
        address.setStreet(createStudentRequest.getStreet());
        addressRepository.save(address);

        student.setAddress(address);
        studentRepository.save(student);

        List<Subject> subjects = new ArrayList<>();
        if(createStudentRequest.getSubjects()!=null){
            createStudentRequest.getSubjects().forEach(createSubjectRequest -> {
                Subject subject = new Subject();
                subject.setStudent(student);
                subject.setSubjectName(createSubjectRequest.getSubjectName());
                subject.setMarksObtained(createSubjectRequest.getMarksObtained());
                subjects.add(subject);
            });
            subjectRepository.saveAll(subjects);
        }
        student.setSubjects(subjects);
        return student;
    }

}
