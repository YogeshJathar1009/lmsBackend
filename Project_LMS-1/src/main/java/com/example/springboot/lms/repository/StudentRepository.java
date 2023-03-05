package com.example.springboot.lms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.springboot.lms.model.Student;

public interface StudentRepository extends JpaRepository<Student, Integer>{

	//Object findAllById(Integer studentId);

}
