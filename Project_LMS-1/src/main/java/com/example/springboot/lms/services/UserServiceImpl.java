package com.example.springboot.lms.services;

//import java.time.LocalDate;
//import java.time.LocalDate;
import java.util.List;
//import java.util.stream.Collectors;

//import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springboot.lms.exception.ResourceNotFoundException;
import com.example.springboot.lms.model.User;
//import com.example.springboot.lms.payloads.UserDto;
import com.example.springboot.lms.repository.UserRepository;
@Service
public class UserServiceImpl implements UserService {
	private UserRepository userRepository;
	
	@Autowired
	public UserServiceImpl(UserRepository userRepository) {
		super();
		this.userRepository = userRepository;
	}
	
	
	public UserServiceImpl() {
		super();
	}

	@Override
	public User saveUser(User user) {
		// TODO Auto-generated method stub
		return userRepository.save(user);
	}

	@Override
	public List<User> getAllUsers() {
		// TODO Auto-generated method stub
		return userRepository.findAll();
	}

	@Override
	public User getUserById(int userId) {
		// TODO Auto-generated method stub
		return userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User", "ID", userId));
	}

	@Override
	public User updateUser(User user, int userId) {
		User existingUser =  userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User", "ID", userId));
		
		existingUser.setAddress(user.getAddress());
		existingUser.setBloodGroup(user.getBloodGroup());
		existingUser.setContactNo(user.getContactNo());
		existingUser.setDesignation(user.getDesignation());
		existingUser.setDOB(user.getDOB());
		existingUser.setEmailId(user.getEmailId());
		existingUser.setGender(user.getGender());
		existingUser.setName(user.getName());
		existingUser.setPassword(user.getPassword());

		return existingUser;
	}

	@Override
	public void deleteUser(int userId) {
		// TODO Auto-generated method stub
		
		 userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User", "ID", userId));
		 userRepository.deleteById(userId);
	}
	
	
}
