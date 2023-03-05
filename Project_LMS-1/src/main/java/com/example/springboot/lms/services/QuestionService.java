package com.example.springboot.lms.services;

import java.util.List;

import com.example.springboot.lms.model.Question;

public interface QuestionService {
	Question saveQuestion(Question question);
	List<Question> getAllQuestions();
	Question getQuestionById(int questionId);
	Question updateQuestion(Question question,int questionId);
     void deleteQuestion(int questionId);
}
