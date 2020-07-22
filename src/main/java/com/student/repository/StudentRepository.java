package com.student.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.student.modal.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {

	Student findByAge(int age);
	
	Student findByAgeAndStudentName(int age, String studentName);
}
