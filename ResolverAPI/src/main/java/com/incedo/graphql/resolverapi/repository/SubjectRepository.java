package com.incedo.graphql.resolverapi.repository;

import com.incedo.graphql.resolverapi.entity.Subject;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubjectRepository extends JpaRepository<Subject,Long> {
}
