package com.incedo.graphql.resolverapi.response;

import com.incedo.graphql.resolverapi.entity.Subject;

public class SubjectResponse {
    private Long id;
    private String subjectName;
    private Double marksObtained;

    public SubjectResponse(Subject subject){
        this.id = subject.getId();
        this.subjectName = subject.getSubjectName();
        this.marksObtained = subject.getMarksObtained();
    }
}
