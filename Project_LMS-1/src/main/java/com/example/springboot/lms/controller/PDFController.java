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

import com.example.springboot.lms.model.PDF;
//import com.example.springboot.lms.model.Student;
//import com.example.springboot.lms.model.Student;
import com.example.springboot.lms.services.PDFService;

@RestController
@RequestMapping("/api/pdfs")
public class PDFController {
	private PDFService pdfService;
	
	@Autowired
	public PDFController(PDFService pdfService) {
		super();
		this.pdfService = pdfService;
	}

	public PDFController() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	@PostMapping
	public ResponseEntity<PDF> savePDF(@RequestBody PDF pdf){
	return new ResponseEntity<PDF>(pdfService.savePDF(pdf),HttpStatus.CREATED);	
	}
	
	//build get all students REST API
	@GetMapping
	List<PDF>getAllPDFs(){
		return pdfService.getAllPDFs();
	}
	
	// build get employee by id REST API
	// http://localhost:8080/api/students/1
	@GetMapping("/{id}")
	public ResponseEntity<PDF> getPDFById(@PathVariable("id") int pdfId){
		return new ResponseEntity<PDF>(pdfService.getPDFById(pdfId),HttpStatus.OK);
	}
	
	
	//build update students REST API
	// http://localhost:8080/api/students/1
	@PutMapping("/{id}")
     public ResponseEntity<PDF> updatePDF(@PathVariable("id") int pdfId,@RequestBody PDF pdf){
		return new ResponseEntity<PDF>(pdfService.updatePDF(pdf,pdfId),HttpStatus.OK);
	}
	
	//build update students REST API
	// http://localhost:8080/api/students/1
	@DeleteMapping("/{id}")
    public ResponseEntity<String> deletePDF(@PathVariable("id") int pdfId){
	//delete student from DB
	pdfService.deletePDF(pdfId);
				
	return new ResponseEntity<String>("PDF deleted sucessfully).",HttpStatus.OK);
				
				}
	
	
	
	
	
}
