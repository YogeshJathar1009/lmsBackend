package com.example.springboot.lms.model;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;

//import com.fasterxml.jackson.annotation.JsonIgnore;

//import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
//import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;





@Entity
@Table(name = "Students")
public class Student {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int  studentId;
	private long ccat_Roll_no;
	private long studentPRN;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JsonManagedReference(value="user_student")
	public User user;
	@JsonManagedReference(value="batch_student")
	@ManyToOne(cascade = CascadeType.ALL)
	private Batch batch;
	
	@OneToMany(mappedBy = "student" ,cascade = CascadeType.ALL)
	private List<Result> resultList = new ArrayList<>();

	
	public Student() {
		super();
		
	}

	
	

	
	public Student(int studentId, long ccat_Roll_no, long studentPRN, User user, Batch batch, List<Result> resultList) {
		super();
		this.studentId = studentId;
		this.ccat_Roll_no = ccat_Roll_no;
		this.studentPRN = studentPRN;
		this.user = user;
		this.batch = batch;
		this.resultList = resultList;
	}




	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public long getCcat_Roll_no() {
		return ccat_Roll_no;
	}

	public void setCcat_Roll_no(long ccat_Roll_no) {
		this.ccat_Roll_no = ccat_Roll_no;
	}

	public long getStudentPRN() {
		return studentPRN;
	}

	public void setStudentPRN(long studentPRN) {
		this.studentPRN = studentPRN;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Batch getBatch() {
		return batch;
	}

	public void setBatch(Batch batch) {
		this.batch = batch;
	}

	public List<Result> getResultList() {
		return resultList;
	}

	public void setResultList(List<Result> resultList) {
		this.resultList = resultList;
	}

	


	
	

}
