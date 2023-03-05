package com.example.springboot.lms.services;

import java.util.List;

import com.example.springboot.lms.model.Student;

public interface StudentService {
	
	Student saveStudent(Student student);
	List<Student> getAllStudents();
	Student getStudentById(int studentId);
     Student updateStudent(Student student,int studentId);
     void deleteStudent(int studentId);
}
