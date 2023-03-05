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

import com.example.springboot.lms.model.Result;
//import com.example.springboot.lms.model.Student;
import com.example.springboot.lms.services.ResultService;


@RestController
@RequestMapping("/api/results")
public class ResultController {
	private ResultService resultService;
	
	
	public ResultController () {
		super();
		
	}
	public@Autowired ResultController(ResultService resultService) {
		super();
		this.resultService=resultService;
	}
	
	@PostMapping
	public ResponseEntity<Result> saveResult(@RequestBody Result result){
	return new ResponseEntity<Result>(resultService.saveResult(result),HttpStatus.CREATED);	
	}
	
	//build get all students REST API
	@GetMapping
	List<Result>getAllResults(){
		return resultService.getAllResults();
	}

	// build get employee by id REST API
	// http://localhost:8080/api/students/1
	@GetMapping("/{id}")
	public ResponseEntity<Result> getResultById(@PathVariable("id") int resultId){
		return new ResponseEntity<Result>(resultService.getResultById(resultId),HttpStatus.OK);
	}
	
	//build update students REST API
	// http://localhost:8080/api/students/1
	@PutMapping("/{id}")
     public ResponseEntity<Result> updateResult(@PathVariable("id") int resultId,@RequestBody Result result){
		return new ResponseEntity<Result>(resultService.updateResult(result,resultId),HttpStatus.OK);
	}
	
	//build update students REST API
	// http://localhost:8080/api/students/1
	@DeleteMapping("/{id}")
     public ResponseEntity<String> deleteResult(@PathVariable("id") int resultId){
	//delete student from DB
	resultService.deleteResult(resultId);
				
	return new ResponseEntity<String>("Result deleted sucessfully).",HttpStatus.OK);
			
	}
	
	
	
	
	
}
