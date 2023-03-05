package com.example.springboot.lms.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springboot.lms.exception.ResourceNotFoundException;
import com.example.springboot.lms.model.Result;
import com.example.springboot.lms.repository.ResultRepository;
@Service
public class ResultServiceImpl implements ResultService{
	private ResultRepository resultRepository;
	
	
	
	
	public ResultServiceImpl() {
		super();
	}
	  @Autowired 
	public ResultServiceImpl(ResultRepository resultRepository) {
		super();
		this.resultRepository = resultRepository;
	}

	@Override
	public Result saveResult(Result result) {
		// TODO Auto-generated method stub
		return resultRepository.save(result);
	}

	@Override
	public List<Result> getAllResults() {
		// TODO Auto-generated method stub
		return resultRepository.findAll();
	}

	@Override
	public Result getResultById(int resultId) {
		// TODO Auto-generated method stub
		 return resultRepository.findById(resultId).orElseThrow(() -> new ResourceNotFoundException("Result", "ID", resultId));
	}

	@Override
	public Result updateResult(Result result, int resultId) {
		Result existingResult= resultRepository.findById(resultId).orElseThrow(() -> new ResourceNotFoundException("Result", "ID", resultId));
		
		 existingResult.setStudent(result.getStudent());
		 existingResult.setTest(result.getTest());
		 existingResult.setObtainedMarks(result.getObtainedMarks());
		
		return existingResult;
	}

	@Override
	public void deleteResult(int resultId) {
		 resultRepository.findById(resultId).orElseThrow(() -> new ResourceNotFoundException("Result", "ID", resultId));
	resultRepository.deleteById(resultId);
	}

}
