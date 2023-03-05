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

import com.example.springboot.lms.model.Module;
//import com.example.springboot.lms.model.Student;
import com.example.springboot.lms.services.ModuleService;

@RestController
@RequestMapping("/api/modules")
public class ModuleController {
private ModuleService moduleService;
	
	@Autowired
	public ModuleController(ModuleService moduleService) {
		super();
		this.moduleService = moduleService;
	}

	public ModuleController() {
		super();
	}
	
	@PostMapping
	public ResponseEntity<Module> saveModule(@RequestBody Module module){
	return new ResponseEntity<Module>(moduleService.saveModule(module),HttpStatus.CREATED);	
	}
	
	 //build get all students REST API
	@GetMapping
	List<Module>getAllModules(){
		return moduleService.getAllModules();
	}
	
	// build get employee by id REST API
	// http://localhost:8080/api/students/1
	@GetMapping("/{id}")
	public ResponseEntity<Module> getModuleById(@PathVariable("id") int moduleId){
		return new ResponseEntity<Module>(moduleService.getModuleById(moduleId),HttpStatus.OK);
	}
	
	//build update students REST API
	// http://localhost:8080/api/students/1
	@PutMapping("/{id}")
     public ResponseEntity<Module> updateModule(@PathVariable("id") int moduleId,@RequestBody Module module){
		return new ResponseEntity<Module>(moduleService.updateModule(module,moduleId),HttpStatus.OK);
	}
	
	//build update students REST API
	// http://localhost:8080/api/students/1
	@DeleteMapping("/{id}")
    public ResponseEntity<String> deleteModule(@PathVariable("id") int moduleId){
	//delete student from DB
	moduleService.deleteModule(moduleId);
				
	return new ResponseEntity<String>("Module deleted sucessfully).",HttpStatus.OK);
				
	}

	
	
}
