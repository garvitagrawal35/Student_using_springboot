package com.student.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.student.modal.Login;
import com.student.repository.StudentLoginRepository;

import java.util.List;

@Service
public class StudentLoginServices {
	
	@Autowired
	private StudentLoginRepository studentLoginRepository;

	public Login addUser(Login login) {
		return studentLoginRepository.save(login);
	}
	
	public List<Login> getAllUsers() {
		return studentLoginRepository.findAll();
	}
}
