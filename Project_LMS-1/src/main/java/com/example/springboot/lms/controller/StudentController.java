 package com.example.springboot.lms.controller;

import java.util.List;
import com.example.springboot.lms.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.springboot.lms.model.Student;

@RestController
@RequestMapping("/api/students")
public class StudentController {
	
	private StudentService studentService;
	
	public StudentController() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public@Autowired StudentController(StudentService studentService) {
		super();
		this.studentService=studentService;
	}
	
	//build create student REST API
	@PostMapping
	public ResponseEntity<Student> saveStudent(@RequestBody Student student){
	return new ResponseEntity<Student>(studentService.saveStudent(student),HttpStatus.CREATED);	
	}
	
     //build get all students REST API
	@GetMapping
	List<Student>getAllStudents(){
		return studentService.getAllStudents();
	}
	
	// build get employee by id REST API
	// http://localhost:8080/api/students/1
	@GetMapping("/{id}")
	public ResponseEntity<Student> getStudentById(@PathVariable("id") int studentId){
		return new ResponseEntity<Student>(studentService.getStudentById(studentId),HttpStatus.OK);
	}
	
	//build update students REST API
	// http://localhost:8080/api/students/1
	@PutMapping("/{id}")
     public ResponseEntity<Student> updateStudent(@PathVariable("id") int studentId,@RequestBody Student student){
		return new ResponseEntity<Student>(studentService.updateStudent(student,studentId),HttpStatus.OK);
	}
	
	//build update students REST API
	// http://localhost:8080/api/students/1
	@DeleteMapping("/{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable("id") int studentId){
	//delete student from DB
	studentService.deleteStudent(studentId);
	
	return new ResponseEntity<String>("Students deleted sucessfully).",HttpStatus.OK);
	
	}
	
}
