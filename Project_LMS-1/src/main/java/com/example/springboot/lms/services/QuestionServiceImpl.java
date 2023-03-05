package com.example.springboot.lms.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springboot.lms.exception.ResourceNotFoundException;
//import com.example.springboot.lms.model.Module;
import com.example.springboot.lms.model.Question;
import com.example.springboot.lms.repository.QuestionRepository;

//import jakarta.persistence.ManyToOne;
@Service
public class QuestionServiceImpl implements QuestionService {
	private QuestionRepository questionRepository;
	
	
	
	public QuestionServiceImpl() {
		super();
	}
	  @Autowired 
	public QuestionServiceImpl(QuestionRepository questionRepository) {
		super();
		this.questionRepository = questionRepository;
	}

	@Override
	public Question saveQuestion(Question question) {
		// TODO Auto-generated method stub
		return questionRepository.save(question);
	}

	@Override
	public List<Question> getAllQuestions() {
		// TODO Auto-generated method stub
		return questionRepository.findAll();
	}

	@Override
	public Question getQuestionById(int questionId) {
		// TODO Auto-generated method stub
		return  questionRepository.findById(questionId).orElseThrow(() -> new ResourceNotFoundException("Question", "ID", questionId));
	}

	@Override
	public Question updateQuestion(Question question, int questionId) {
		Question existingQuestion = questionRepository.findById(questionId).orElseThrow(() -> new ResourceNotFoundException("Question", "ID", questionId));
		
		 existingQuestion.setOption_A(question.getOption_A());
		 existingQuestion.setOption_B(question.getOption_B());
		 existingQuestion.setOption_C(question.getOption_C());
		 existingQuestion.setOption_D(question.getOption_D());
		 existingQuestion.setCorrectAns(question.getCorrectAns());
		 existingQuestion.setPath(question.getPath());
		 existingQuestion.setQuestion(question.getQuestion());
		 existingQuestion.setWeightage(question.getWeightage());
		 existingQuestion.setModule(question.getModule());
		
		return existingQuestion;
		
		
	}

	@Override
	public void deleteQuestion(int questionId) {
		
		 questionRepository.findById(questionId).orElseThrow(() -> new ResourceNotFoundException("Question", "ID", questionId));
	questionRepository.deleteById(questionId);
	}

}
