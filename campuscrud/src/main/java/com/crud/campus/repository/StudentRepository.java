package com.crud.campus.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.crud.campus.model.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

}
