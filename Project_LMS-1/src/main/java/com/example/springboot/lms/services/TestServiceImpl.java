package com.example.springboot.lms.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springboot.lms.exception.ResourceNotFoundException;
//import com.example.springboot.lms.model.Result;
import com.example.springboot.lms.model.Test;
import com.example.springboot.lms.repository.TestRepository;
@Service
public class TestServiceImpl implements TestService {
	private TestRepository testRepository;
	
	
	
	

	public TestServiceImpl() {
		super();
	}
	  @Autowired 
	public TestServiceImpl(TestRepository testRepository) {
		super();
		this.testRepository = testRepository;
	}

	@Override
	public Test saveTest(Test test) {
		
		return testRepository.save(test);
	}

	@Override
	public List<Test> getAllTests() {
		// TODO Auto-generated method stub
		return testRepository.findAll();
	}

	@Override
	public Test getTestById(int testId) {
		// TODO Auto-generated method stub
		return testRepository.findById(testId).orElseThrow(() -> new ResourceNotFoundException("Test", "ID", testId));
	}

	@Override
	public Test updateTest(Test test, int testId) {
		Test existingTest =  testRepository.findById(testId).orElseThrow(() -> new ResourceNotFoundException("Test", "ID", testId));
		
		existingTest.setTestName(test.getTestName());
		existingTest.setModule(test.getModule());
		existingTest.setTotalMarks(test.getTotalMarks());

		return existingTest;
	}

	@Override
	public void deleteTest(int testId) {
		testRepository.findById(testId).orElseThrow(() -> new ResourceNotFoundException("Test", "ID", testId));
	testRepository.deleteById(testId);
		
	}

}
