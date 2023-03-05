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

import com.example.springboot.lms.model.Question;
//import com.example.springboot.lms.model.Student;
//
//import com.example.springboot.lms.model.Student;
import com.example.springboot.lms.services.QuestionService;

@RestController
@RequestMapping("/api/questions")
public class QuestionController {
	
	private QuestionService questionService;
	
	@Autowired
	public QuestionController(QuestionService questionService) {
		super();
		this.questionService = questionService;
	}
	
	public QuestionController() {
		super();
		// TODO Auto-generated constructor stub
	}


	@PostMapping
	public ResponseEntity<Question> saveQuestion(@RequestBody Question question){
	return new ResponseEntity<Question>(questionService.saveQuestion(question),HttpStatus.CREATED);	
	}
	//build get all students REST API
	
	
	@GetMapping
	List<Question>getAllQuestions(){
		return questionService.getAllQuestions();
	}	
	// build get employee by id REST API
		// http://localhost:8080/api/students/1
		
	
	
	@GetMapping("/{id}")
	public ResponseEntity<Question> getQuestionById(@PathVariable("id") int questionId){
		return new ResponseEntity<Question>(questionService.getQuestionById(questionId),HttpStatus.OK);
	}
	
	//build update students REST API
	// http://localhost:8080/api/students/1
	@PutMapping("/{id}")
    public ResponseEntity<Question> updateQuestion(@PathVariable("id") int questionId,@RequestBody Question question){
		return new ResponseEntity<Question>(questionService.updateQuestion(question,questionId),HttpStatus.OK);
	}
	
	//build update students REST API
	// http://localhost:8080/api/students/1
	@DeleteMapping("/{id}")
     public ResponseEntity<String> deleteQuestion(@PathVariable("id") int questionId){
	//delete student from DB
	questionService.deleteQuestion(questionId);
				
	return new ResponseEntity<String>("Question deleted sucessfully).",HttpStatus.OK);
			
			}
}
