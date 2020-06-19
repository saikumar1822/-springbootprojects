package com.student.student.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.student.student.model.Student;


public interface StundentRepository extends JpaRepository<Student, Long> {
	
	public Student findByName(String name);

}
