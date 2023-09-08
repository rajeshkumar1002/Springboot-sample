package com.incedo.graphql.resolverapi.mutation;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.incedo.graphql.resolverapi.request.CreateStudentRequest;
import com.incedo.graphql.resolverapi.response.StudentResponse;
import com.incedo.graphql.resolverapi.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.stereotype.Component;

@Component
public class Mutation implements GraphQLMutationResolver {
    @Autowired
    StudentService studentService;

    public StudentResponse createStudent(CreateStudentRequest createStudentRequest){
        System.out.println("==========================================");
        return new StudentResponse(studentService.createStudent(createStudentRequest));
    }
}
