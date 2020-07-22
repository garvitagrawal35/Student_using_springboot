package com.student.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.student.modal.Login;

public interface StudentLoginRepository extends JpaRepository<Login, String> {
		
	public Login findByUsername(String username);

}
