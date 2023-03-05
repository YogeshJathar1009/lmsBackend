package com.example.springboot.lms.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;

//import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;


@Entity
@Table(name = "Users")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int userId;
	private String password;
	private String name;
	private String emailId;
	private LocalDate DOB;
	private String  bloodGroup;
	private String gender;
	private String designation;
	private String contactNo;
	private String address;
	
	@OneToOne(mappedBy = "user",cascade = CascadeType.ALL)
	@JsonBackReference(value="user_student")
	//@JoinColumn(name = "user_id")
	private Student student;
	
	
	@ManyToMany(mappedBy = "userList",cascade = CascadeType.ALL)
	private List<Module> moduleList = new ArrayList<>();
	
	
	
	
	
	public User() {
		super();
		
	}


	
	public User(int userId, String password, String name, String emailId, LocalDate dOB, String bloodGroup,
			String gender, String designation, String contactNo, String address) {
		super();
		this.userId = userId;
		this.password = password;
		this.name = name;
		this.emailId = emailId;
		DOB = dOB;
		this.bloodGroup = bloodGroup;
		this.gender = gender;
		this.designation = designation;
		this.contactNo = contactNo;
		this.address = address;
	}


	public int getUserId() {
		return userId;
	}


	public void setUserId(int userId) {
		this.userId = userId;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getEmailId() {
		return emailId;
	}


	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}


	public LocalDate getDOB() {
		return DOB;
	}


	public void setDOB(LocalDate dOB) {
		DOB = dOB;
	}


	public String getBloodGroup() {
		return bloodGroup;
	}


	public void setBloodGroup(String bloodGroup) {
		this.bloodGroup = bloodGroup;
	}


	public String getGender() {
		return gender;
	}


	public void setGender(String gender) {
		this.gender = gender;
	}


	public String getDesignation() {
		return designation;
	}


	public void setDesignation(String designation) {
		this.designation = designation;
	}


	public String getContactNo() {
		return contactNo;
	}


	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public Student getStudent() {
		return student;
	}


	public void setStudent(Student student) {
		this.student = student;
	}


	public List<Module> getModuleList() {
		return moduleList;
	}


	public void setModuleList(List<Module> moduleList) {
		this.moduleList = moduleList;
	}


	



}
