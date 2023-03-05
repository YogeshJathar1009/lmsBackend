package com.example.springboot.lms.services;

import java.util.List;

import com.example.springboot.lms.model.User;
//import com.example.springboot.lms.payloads.UserDto;

public interface UserService {

	User saveUser(User user);
	
	List<User> getAllUsers();
	
	User getUserById(int userId);
	
	User updateUser(User user,int userId);
     
     void deleteUser(int userId);

	
}
