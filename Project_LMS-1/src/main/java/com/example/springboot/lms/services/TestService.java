package com.example.springboot.lms.services;

import java.util.List;

import com.example.springboot.lms.model.Test;

public interface TestService {
	Test saveTest(Test test);
	List<Test> getAllTests();
	Test getTestById(int testId);
	Test updateTest(Test test,int testId);
     void deleteTest(int testId);
}
