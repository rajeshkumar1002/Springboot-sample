package com.demo.restapi.restapi.repository;

import com.demo.restapi.restapi.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface StudentRepository extends JpaRepository<Student,Long> {
}
