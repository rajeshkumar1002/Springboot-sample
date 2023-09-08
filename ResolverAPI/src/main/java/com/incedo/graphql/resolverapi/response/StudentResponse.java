package com.incedo.graphql.resolverapi.response;

import com.incedo.graphql.resolverapi.entity.Student;
import com.incedo.graphql.resolverapi.entity.Subject;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class StudentResponse {
    private Long id;
    private String firstName;
    private String lastName;

    private String street;
    private String city;
    private List<SubjectResponse> subjects;

    private Student student;
    public StudentResponse(Student student){
        this.student = student;
        this.id = student.getId();
        this.firstName = student.getFirstName();
        this.lastName = student.getLastName();

        this.street = student.getAddress().getStreet();
        this.city = student.getAddress().getCity();

        if(student.getSubjects() != null){
            subjects = new ArrayList<>();
            for(Subject subject: student.getSubjects()){
                subjects.add(new SubjectResponse(subject));
            }
        }
    }
}