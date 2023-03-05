package com.example.springboot.lms.services;

import java.util.List;
//import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.springboot.lms.exception.ResourceNotFoundException;
import com.example.springboot.lms.model.Student;
import com.example.springboot.lms.repository.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService {
	private StudentRepository studentRepository;
	
	//using constructor
    @Autowired 
	public StudentServiceImpl(StudentRepository studentRepository) {
		super();
		this.studentRepository = studentRepository;
	}

	@Override
	public Student saveStudent(Student student) {
		return studentRepository.save(student);
	}
	
	public StudentServiceImpl() {
		super();
	
	}

	@Override
	public List<Student> getAllStudents(){
		return studentRepository.findAll();
	}

	@Override
	public Student getStudentById(int studentId) {
//		Optional<Student> students= studentRepository.findById(studentId);
//		if(students.isPresent()) {
//			return students.get();
//		}else {
//			throw new ResourceNotFoundException("Student","ID",studentId);
//		}
		return studentRepository.findById(studentId).orElseThrow(() -> new ResourceNotFoundException("Student","ID",studentId)); 
	}

	@Override
	public Student updateStudent(Student student, int studentId) {
		// we need check whether students with given id is exist in DB or not
		Student existingStudent=studentRepository.findById(studentId).orElseThrow(() -> new ResourceNotFoundException("Student","ID",studentId));
		
		existingStudent.setBatch(student.getBatch());
		existingStudent.setUser(student.getUser());
		existingStudent.setStudentPRN(student.getStudentPRN());
		existingStudent.setCcat_Roll_no(student.getCcat_Roll_no());
		return existingStudent;
	}

	@Override
	public void deleteStudent(int studentId) {
		// we need check whether students with given id is exist in DB or not
		studentRepository.findById(studentId).orElseThrow(() -> 
		new ResourceNotFoundException("Student","ID",studentId));
		
		studentRepository.deleteById(studentId);
		
	}
}

