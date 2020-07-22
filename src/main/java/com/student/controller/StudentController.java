package com.student.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.student.modal.Student;
import com.student.service.StudentService;

@RestController
public class StudentController {

	@Autowired
	private StudentService studentService;

	@PostMapping(value = "/addStudent", consumes = "application/json")
	public Student addStudent(@RequestBody Student student) {
		return studentService.addStudent(student);
	}

	@GetMapping(value = "/getAllStudents", produces = "application/json")
	public List<Student> getALlStudents() {
		return studentService.getAllStudents();
	}
	
	@GetMapping(value = "/findByAge/{age}", produces = "application/json")
	public Student findByAge(@PathVariable int age) {
		return studentService.findByAge(age);
	}
	
	@DeleteMapping(value = "/deleteStudent")
	public String deleteStudent(@RequestParam int id) {
		return studentService.deleteStudent(id);
	}
	
	@GetMapping(value = "/findBy", produces = "application/json")
	public Student findBy(@RequestParam int age, @RequestParam String studentName) {
		return studentService.findByAgeAndStudent(age, studentName);
	}
	
	/*
	 * @PostMapping(value = "/updateTotalStudentInfo", consumes =
	 * "application/json") public String updateTotalStudentInfo(@RequestBody Student
	 * student) { return studentService.updateTotalStudentInfo(student); }
	 * 
	 * @PutMapping(value = "/updateStudent", consumes = "application/json") public
	 * String updateStudent(@RequestBody Student student) { return
	 * studentService.updateStudent(student); }
	 */
}