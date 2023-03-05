package com.example.springboot.lms.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity

@Table(name = "Tests")
public class Test {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int testId;
	private String testName;
	private int totalMarks;	
	
	
	
	@ManyToOne(cascade = CascadeType.ALL)
	private Module module;
	
	@ManyToMany(cascade = CascadeType.ALL)
	private List<Question> questionList = new ArrayList<>();
	
	@OneToMany(mappedBy = "test" , cascade = CascadeType.ALL)
	private List<Result> resultList = new ArrayList<>();

	public Test() {
		super();
		
	}

	 
	public Test(int testId, String testName, int totalMarks, Module module, List<Question> questionList,
			List<Result> resultList) {
		super();
		this.testId = testId;
		this.testName = testName;
		this.totalMarks = totalMarks;
		this.module = module;
		this.questionList = questionList;
		this.resultList = resultList;
	}

	
	

	public int getTestId() {
		return testId;
	}

	public void setTestId(int testId) {
		this.testId = testId;
	}

	public String getTestName() {
		return testName;
	}

	public void setTestName(String testName) {
		this.testName = testName;
	}

	public int getTotalMarks() {
		return totalMarks;
	}

	public void setTotalMarks(int totalMarks) {
		this.totalMarks = totalMarks;
	}

	public Module getModule() {
		return module;
	}

	public void setModule(Module module) {
		this.module = module;
	}

	public List<Question> getQuestionList() {
		return questionList;
	}

	public void setQuestionList(List<Question> questionList) {
		this.questionList = questionList;
	}

	public List<Result> getResultList() {
		return resultList;
	}

	public void setResultList(List<Result> resultList) {
		this.resultList = resultList;
	}
	
	
}
