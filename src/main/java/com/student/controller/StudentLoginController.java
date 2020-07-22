package com.student.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.student.modal.Login;
import com.student.modal.LoginRequest;
import com.student.modal.LoginResponse;
import com.student.service.StudentLoginServices;

@RestController
public class StudentLoginController {

	@Autowired
	StudentLoginServices studentLoginServices;
	
	@PostMapping(value = "/addUser", consumes = "application/json")
	public Login addUser(@RequestBody LoginRequest loginRequest) {
		Login login = new Login();
		BeanUtils.copyProperties(loginRequest, login);
		return studentLoginServices.addUser(login);
	}
	
	@GetMapping(value = "/getAllUsers", produces = "application/json")
	public List<LoginResponse> getAllUsers() {
		return studentLoginServices.getAllUsers().stream().map(StudentLoginController::convert).collect(Collectors.toList());
	}
	
	private static LoginResponse convert(Login login) {
		
		LoginResponse loginResponse = new LoginResponse();
		BeanUtils.copyProperties(login, loginResponse);
		return loginResponse;
	}
}