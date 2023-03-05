package com.example.springboot.lms.services;

import java.util.List;

import com.example.springboot.lms.model.Result;

public interface ResultService {
	Result saveResult(Result result);
	List<Result> getAllResults();
	Result getResultById(int resultId);
	Result updateResult(Result result,int resultId);
     void deleteResult(int resultId);
}
