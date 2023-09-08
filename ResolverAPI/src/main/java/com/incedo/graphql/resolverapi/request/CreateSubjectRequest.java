package com.incedo.graphql.resolverapi.request;

import com.incedo.graphql.resolverapi.entity.Student;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@AllArgsConstructor
@Data
public class CreateSubjectRequest {
    private Long id;
    private String subjectName;
    private double marksObtained;
    private Student student;
}
