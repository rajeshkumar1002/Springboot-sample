package com.incedo.graphql.resolverapi.query;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.incedo.graphql.resolverapi.response.StudentResponse;
import com.incedo.graphql.resolverapi.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;;
import org.springframework.stereotype.Component;

@Component
public class Query implements GraphQLQueryResolver {
    @Autowired
    StudentService studentService;

    public StudentResponse getStudent(Long id){
        System.out.println("============================");
        return new StudentResponse(studentService.getStudentById(id));
    }
}
