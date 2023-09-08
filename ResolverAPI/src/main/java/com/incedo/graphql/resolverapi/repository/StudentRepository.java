package com.incedo.graphql.resolverapi.repository;

import com.incedo.graphql.resolverapi.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student,Long> {
}
