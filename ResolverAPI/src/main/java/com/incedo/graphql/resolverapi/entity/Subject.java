package com.incedo.graphql.resolverapi.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Subject {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String subjectName;
    private double marksObtained;
    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;
}
