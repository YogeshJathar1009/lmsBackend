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
import com.example.springboot.lms.model.User;

//import com.example.springboot.lms.repository.UserRepository;
//import com.example.springboot.lms.services.StudentService;
import com.example.springboot.lms.services.UserService;
@RestController
@RequestMapping("/api/users")
public class UserController {	
	private UserService userService;
	
	@Autowired
	public UserController(UserService userService) {
		super();
		this.userService = userService;
	}

	public UserController() {
		super();
	}
	//build create student REST API
	@PostMapping
	public ResponseEntity<User> saveUser(@RequestBody User user){
		return new ResponseEntity<User>(userService.saveUser(user),HttpStatus.CREATED);	
	}
	
    //build get all students REST API
	@GetMapping
	List<User>getAllUsers(){
		return userService.getAllUsers();
	}	
	
	@GetMapping("/{id}")
	public ResponseEntity<User> getUserById(@PathVariable("id") int userId){
		return new ResponseEntity<User>(userService.getUserById(userId),HttpStatus.OK);
	}
	
	@PutMapping("/{id}")
     public ResponseEntity<User> updateUser(@PathVariable("id") int userId,@RequestBody User user){
		return new ResponseEntity<User>(userService.updateUser(user,userId),HttpStatus.OK);
	}
	
	//build update students REST API
	// http://localhost:8080/api/students/1
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteUser(@PathVariable("id") int userId){
	//delete student from DB
	userService.deleteUser(userId);
				
	return new ResponseEntity<String>("User deleted sucessfully).",HttpStatus.OK);
	}				
		
}
