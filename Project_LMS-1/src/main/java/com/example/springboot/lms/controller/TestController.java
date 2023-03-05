package com.example.springboot.lms.controller;

import java.util.List;

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

//import com.example.springboot.lms.model.Student;
import com.example.springboot.lms.model.Test;
//import com.example.springboot.lms.model.User;
import com.example.springboot.lms.services.TestService;

@RestController
@RequestMapping("/api/tests")
public class TestController {

	private TestService testService;

	public TestController() {
		super();
	}
	
	@Autowired
	public TestController(TestService testService) {
		super();
		this.testService = testService;
	}
	
	//build create student REST API
	@PostMapping
	public ResponseEntity<Test> saveTest(@RequestBody Test test){
	return new ResponseEntity<Test>(testService.saveTest(test),HttpStatus.CREATED);	
	}

	//build get all students REST API
	@GetMapping
	List<Test>grtAllTests(){
		return testService.getAllTests();
	}
	
	// build get employee by id REST API
	// http://localhost:8080/api/students/1
	@GetMapping("/{id}")
	public ResponseEntity<Test> getTestById(@PathVariable("id") int testId){
		return new ResponseEntity<Test>(testService.getTestById(testId),HttpStatus.OK);
	}
	
	//build update students REST API
	// http://localhost:8080/api/students/1
	@PutMapping("/{id}")
     public ResponseEntity<Test> updateTest(@PathVariable("id") int testId,@RequestBody Test test){
		return new ResponseEntity<Test>(testService.updateTest(test,testId),HttpStatus.OK);
	}
	
	
	//build update students REST API
	// http://localhost:8080/api/students/1
	@DeleteMapping("/{id}")
    public ResponseEntity<String> deleteTest(@PathVariable("id") int testId){
	//delete student from DB
	testService.deleteTest(testId);
		
	return new ResponseEntity<String>("Test deleted sucessfully).",HttpStatus.OK);
	
	}
		
	
}
