package com.incedo.graphql.resolverapi.request;

import com.incedo.graphql.resolverapi.entity.Address;
import com.incedo.graphql.resolverapi.entity.Subject;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class CreateStudentRequest {
    private Long id;
    private String firstName;
    private String lastName;
    private String city;
    private String street;
    private List<CreateSubjectRequest> subjects;
}
