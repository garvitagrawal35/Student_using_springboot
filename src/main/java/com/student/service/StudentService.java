package com.student.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.student.modal.Student;
import com.student.repository.StudentRepository;

@Service
public class StudentService {

	@Autowired
	private StudentRepository studentRepository;

	public Student addStudent(Student student) {
		return studentRepository.save(student);
	}

	public List<Student> getAllStudents() {
		return (List<Student>) studentRepository.findAll();
	}
	
	public String deleteStudent(int id) {
		studentRepository.deleteById(id);
		return "Successfully deleted";
	}
	
	public Student findByAge(int age) {
		return studentRepository.findByAge(age);
	}
	
	public Student findByAgeAndStudent(int age, String studentName) {
		return studentRepository.findByAgeAndStudentName(age, studentName);
	}
	
	/*
	 * public String updateTotalStudentInfo(Student student) { return
	 * studentRepository.updateTotalStudentInfo(student); }
	 * 
	 * public String updateStudent(Student student) { return
	 * studentRepository.updateStudent(student); }
	 */
}
