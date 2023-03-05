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

import com.example.springboot.lms.model.Batch;
//import com.example.springboot.lms.model.Student;
//import com.example.springboot.lms.model.Student;
import com.example.springboot.lms.services.BatchServices;
//import com.example.springboot.lms.services.ResultService;

@RestController
@RequestMapping("/api/batches")
public class BatchController {
private BatchServices batchServices;
	
	public BatchController () {
		super();
		
	}
	
	public@Autowired BatchController(BatchServices batchServices) {
		super();
		this.batchServices=batchServices;
	}
	
	@PostMapping
	public ResponseEntity<Batch> saveBatch(@RequestBody Batch batch){
	return new ResponseEntity<Batch>(batchServices.saveBatch(batch),HttpStatus.CREATED);	
	}
	
	//build get all students REST API
	@GetMapping
	List<Batch>getAllBatches(){
		return batchServices.getAllBatches();
	}
	
	// build get employee by id REST API
	// http://localhost:8080/api/students/1
	@GetMapping("/{id}")
	public ResponseEntity<Batch> getBatchById(@PathVariable("id") int batchId){
		return new ResponseEntity<Batch>(batchServices.getBatchById(batchId),HttpStatus.OK);
	}
	
	//build update students REST API
	// http://localhost:8080/api/students/1
	@PutMapping("/{id}")
     public ResponseEntity<Batch> updateBatch(@PathVariable("id") int batchId,@RequestBody Batch batch){
		return new ResponseEntity<Batch>(batchServices.updateBatch(batch,batchId),HttpStatus.OK);
	}
	
	//build update students REST API
	// http://localhost:8080/api/students/1
	@DeleteMapping("/{id}")
    public ResponseEntity<String> deleteBatch(@PathVariable("id") int batchId){
	//delete student from DB
	batchServices.deleteBatch(batchId);
				
	return new ResponseEntity<String>("Batch deleted sucessfully).",HttpStatus.OK);
				
	}
	


}
